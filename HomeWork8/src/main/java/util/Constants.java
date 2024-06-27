package util;

public class Constants {
    public static final String URL = "jdbc:postgresql://localhost:5432/my_ticket_service_db";
    public static final String USER = "postgres";
    public static final String PASSWORD = "madina";
    public static final String INSERT_INTO_USERS = "INSERT INTO users (name, creation_date) VALUES (?, ?)";
    public static final String INSERT_INTO_TICKETS = "INSERT INTO tickets (user_id, ticket_type, creation_date) VALUES (?, ?, ?)";
    public static final String SELECT_FROM_TICKETS_WHERE_ID = "SELECT * FROM tickets WHERE id = ?";
    public static final String SELECT_FROM_TICKETS_WHERE_USER_ID = "SELECT * FROM tickets WHERE user_id = ?";
    public static final String SELECT_FROM_USERS_WHERE_ID = "SELECT * FROM users WHERE id = ?";
    public static final String UPDATE_TICKETS_SET_TICKET_TYPE_WHERE_ID = "UPDATE tickets SET ticket_type = ? WHERE id = ?";
    public static final String DELETE_FROM_TICKETS_WHERE_USER_ID = "DELETE FROM tickets WHERE user_id = ?";
    public static final String DELETE_FROM_USERS_WHERE_ID = "DELETE FROM users WHERE id = ?";
    public static final String ID = "id";
    public static final String USER_ID = "user_id";
    public static final String TICKET_TYPE = "ticket_type";
    public static final String CREATION_DATE = "creation_date";
    public static final String USER_NAME = "name";
    public static final String BEFORE_DELETING_USER_SAVEPOINT = "BeforeDeletingUser";
}