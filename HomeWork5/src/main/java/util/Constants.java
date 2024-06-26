package util;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final String FILE_NOT_FOUND = "File not found: ";
    public static final String FAILED_TO_PARSE_LINE = "Failed to parse line: ";
    public static final String FAILED_TO_READ_FILE = "Failed to read file: ";
    public static final String FAILED_TO_READ_TICKETS_FROM_FILE = "Failed to read tickets from file: ";
    public static final String FILE_NAME = "tickets.txt";
    public static final String TOTAL = "Total = ";
    public static final String VALID = "Valid = ";
    public static final String MOST_POPULAR_VIOLATION = "Most popular violation = ";
    public static final String NO_VIOLATION = "None";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final List<String> VALID_TICKET_TYPES = Arrays.asList("DAY", "WEEK", "MONTH", "YEAR");
    public static final String TICKET_TYPE_VIOLATION = "ticket type";
    public static final String PRICE_VIOLATION = "price";
    public static final int ZERO_PRICE = 0;
    public static final String START_DATE_VIOLATION = "start date";
    public static final List<String> TICKET_TYPES_WITH_MANDATORY_START_DATE = Arrays.asList("DAY", "WEEK", "YEAR");
    public static final String VALID_TICKETS = "Valid Tickets:";
}