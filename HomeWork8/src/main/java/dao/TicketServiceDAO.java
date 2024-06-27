package dao;

import entity.TicketEntity;
import entity.UserEntity;
import enums.TicketType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static util.Constants.*;

public class TicketServiceDAO {

    public void saveUser(UserEntity user) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO_USERS)) {
            statement.setString(1, user.getName());
            statement.setTimestamp(2, user.getCreationDate());
            statement.executeUpdate();
        }
    }

    public void saveTicket(TicketEntity ticket) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO_TICKETS)) {
            statement.setInt(1, ticket.getUserId());
            statement.setObject(2, ticket.getTicketType(), Types.OTHER);
            statement.setTimestamp(3, ticket.getCreationDate());
            statement.executeUpdate();
        }
    }

    public TicketEntity fetchTicketById(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SELECT_FROM_TICKETS_WHERE_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new TicketEntity(
                        resultSet.getInt(ID),
                        resultSet.getInt(USER_ID),
                        TicketType.valueOf(resultSet.getString(TICKET_TYPE)),
                        resultSet.getTimestamp(CREATION_DATE));
            }
        }
        return null;
    }

    public List<TicketEntity> fetchTicketsByUserId(int userId) throws SQLException {
        List<TicketEntity> tickets = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SELECT_FROM_TICKETS_WHERE_USER_ID)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tickets.add(new TicketEntity(
                        resultSet.getInt(ID),
                        resultSet.getInt(USER_ID),
                        TicketType.valueOf(resultSet.getString(TICKET_TYPE)),
                        resultSet.getTimestamp(CREATION_DATE)));
            }
        }
        return tickets;
    }

    public UserEntity fetchUserById(int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SELECT_FROM_USERS_WHERE_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new UserEntity(
                        resultSet.getInt(ID),
                        resultSet.getString(USER_NAME),
                        resultSet.getTimestamp(CREATION_DATE));
            }
        }
        return null;
    }

    public void updateTicketType(int ticketId, TicketType newType) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(UPDATE_TICKETS_SET_TICKET_TYPE_WHERE_ID)) {
            statement.setObject(1, newType, Types.OTHER);
            statement.setInt(2, ticketId);
            statement.executeUpdate();
        }
    }

    public void deleteUserById(int userId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            connection.setAutoCommit(false);
            Savepoint savepoint = null;
            try (PreparedStatement deleteTicketsStatement = connection.prepareStatement(DELETE_FROM_TICKETS_WHERE_USER_ID);
                 PreparedStatement deleteUserStatement = connection.prepareStatement(DELETE_FROM_USERS_WHERE_ID)) {
                deleteTicketsStatement.setInt(1, userId);
                deleteTicketsStatement.executeUpdate();
                savepoint = connection.setSavepoint(BEFORE_DELETING_USER_SAVEPOINT);
                deleteUserStatement.setInt(1, userId);
                deleteUserStatement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                if (savepoint != null) {
                    connection.rollback(savepoint);
                }
                connection.rollback();
                throw e;
            } finally {
                connection.setAutoCommit(true);
            }
        }
    }
}