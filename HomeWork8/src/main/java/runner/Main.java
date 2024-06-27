package runner;

import dao.TicketServiceDAO;
import entity.TicketEntity;
import entity.UserEntity;
import enums.TicketType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;


public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        TicketServiceDAO ticketServiceDAO = new TicketServiceDAO();

        try {
//            demonstrateSavingUser(ticketServiceDAO);

//            saveTicketsForUser(ticketServiceDAO, 1);
//            saveTicketsForUser(ticketServiceDAO, 2);
//            saveTicketsForUser(ticketServiceDAO, 3);

//            logger.info(ticketServiceDAO.fetchUserById(1).toString());
//            logger.info(ticketServiceDAO.fetchTicketById(1).toString());
//            logger.info(ticketServiceDAO.fetchTicketsByUserId(1).toString());
//
//            ticketServiceDAO.updateTicketType(1, TicketType.MONTH);
            ticketServiceDAO.deleteUserById(3);

        } catch (SQLException exception) {
            logger.error("An error occurred", exception);
        }
    }

    private static void demonstrateSavingUser(TicketServiceDAO ticketServiceDAO) throws SQLException {
        UserEntity user1 = new UserEntity("Madara Uchiha", Timestamp.from(Instant.now()));
        UserEntity user2 = new UserEntity("Itachi Uchiha", Timestamp.from(Instant.now()));
        UserEntity user3 = new UserEntity("Sasuke Uchiha", Timestamp.from(Instant.now()));

        ticketServiceDAO.saveUser(user1);
        logger.info("User saved successfully: {}", user1.getName());

        ticketServiceDAO.saveUser(user2);
        logger.info("User saved successfully: {}", user2.getName());

        ticketServiceDAO.saveUser(user3);
        logger.info("User saved successfully: {}", user3.getName());
    }

    private static void saveTicketsForUser(TicketServiceDAO ticketServiceDAO, int userId) throws SQLException {
        TicketEntity ticket1 = new TicketEntity(userId, TicketType.DAY, Timestamp.from(Instant.now()));
        TicketEntity ticket2 = new TicketEntity(userId, TicketType.WEEK, Timestamp.from(Instant.now()));

        ticketServiceDAO.saveTicket(ticket1);
        logger.info("Ticket saved successfully: {} for user ID: {}", ticket1.getTicketType(), userId);

        ticketServiceDAO.saveTicket(ticket2);
        logger.info("Ticket saved successfully: {} for user ID: {}", ticket2.getTicketType(), userId);
    }
}