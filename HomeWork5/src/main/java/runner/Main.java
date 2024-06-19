package runner;

import entity.BusTicket;

import java.util.Map;
import java.util.logging.Logger;

import java.util.List;
import java.util.logging.Level;

import static java.util.stream.Collectors.*;
import static reader.BusTicketReader.readTicketsFromFile;
import static util.Constants.*;
import static validator.BusTicketValidator.validateTicket;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        List<BusTicket> tickets = readTicketsFromFile(FILE_NAME);
        if (tickets == null) {
            logger.log(Level.SEVERE, FAILED_TO_READ_TICKETS_FROM_FILE + FILE_NAME);
            return;
        }

        int total = tickets.size();

        List<BusTicket> validTickets = tickets.stream()
                .filter(ticket -> validateTicket(ticket).isEmpty())
                .toList();

        int valid = validTickets.size();

        Map<String, Long> violationCounts = tickets.stream()
                .flatMap(ticket -> validateTicket(ticket).stream())
                .collect(groupingBy(violation -> violation, counting()));

        String mostCommonViolation = violationCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(NO_VIOLATION);

        logger.log(Level.INFO, TOTAL + total);
        logger.log(Level.INFO, VALID + valid);
        logger.log(Level.INFO, MOST_POPULAR_VIOLATION + mostCommonViolation);

        logger.log(Level.INFO, VALID_TICKETS);
        validTickets.forEach(ticket -> logger.log(Level.INFO, ticket.toString()));
    }
}