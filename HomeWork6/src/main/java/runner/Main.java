package runner;

import entity.BusTicket;
import service.BusTicketService;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static util.Constants.*;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        BusTicketService ticketService = new BusTicketService();

        ticketService.createTicket("CLA", "DAY", "2025-01-01", "0");
        ticketService.createTicket("CLA", "DAY", "2025-01-01", "10");
        ticketService.createTicket("CLA", "PRIME", null, "1000");
        ticketService.createTicket("STD", "DAY", "2025-01-01", "0");
        ticketService.createTicket("STD", "WEEK", "2020-01-01", "50");
        ticketService.createTicket("CLA", "YEAR", "2020-01-01", "500");
        ticketService.createTicket("CLA", "MONTH", "2020-01-01", "100");
        ticketService.createTicket("CLA", "DAY", "2020-01-01", "100");

        Map<String, BusTicket> searchResults = ticketService.searchTicketsByTypeAndPrice(DAY, 0, 10);
        logger.log(Level.INFO, SEARCH_RESULTS);
        searchResults.forEach((id, ticket) -> logger.log(Level.INFO, ID + id + TICKET + ticket));

        String sampleId = searchResults.keySet().iterator().next();
        BusTicket retrievedTicket = ticketService.getTicketById(sampleId);
        logger.log(Level.INFO, RETRIEVED_TICKET + retrievedTicket);

        boolean removed = ticketService.removeTicketById(sampleId);
        logger.log(Level.INFO, TICKET_REMOVED + removed);

        BusTicket removedTicket = ticketService.getTicketById(sampleId);
        logger.log(Level.INFO, RETRIEVED_AFTER_REMOVAL + removedTicket);
    }
}