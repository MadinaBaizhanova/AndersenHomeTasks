package service;

import entity.BusTicket;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * This class provides functionalities to manage bus tickets
 * including creation, storage, retrieval, and search within an in-memory storage.
 */

public class BusTicketService {

    private final Map<String, BusTicket> tickets = new HashMap<>();

    /**
     * Creates a bus ticket and stores it in the in-memory storage.
     *
     * @param ticketClass the class of the ticket (e.g., "CLA", "STD", etc.)
     * @param ticketType  the type of the ticket (e.g., "DAY", "MONTH", "WEEK", "YEAR", "PRIME")
     * @param startDate   the start date of the ticket validity (e.g., "2025-01-01")
     * @param price       the price of the ticket (e.g., "0", "100")
     */
    public void createTicket(String ticketClass, String ticketType, String startDate, String price) {
        String id = UUID.randomUUID().toString();
        BusTicket ticket = new BusTicket(ticketClass, ticketType, startDate, price);
        tickets.put(id, ticket);
    }

    public boolean removeTicketById(String id) {
        return tickets.remove(id) != null;
    }

    public BusTicket getTicketById(String id) {
        return tickets.get(id);
    }

    /**
     * Searches for tickets by type and a price range.
     *
     * @param ticketType the type of ticket to search for
     * @param priceFrom  the minimum price of the ticket
     * @param priceTo    the maximum price of the ticket
     * @return tickets that match the type and price criteria
     */
    public Map<String, BusTicket> searchTicketsByTypeAndPrice(String ticketType, int priceFrom, int priceTo) {
        return tickets.entrySet().stream()
                .filter(entry -> entry.getValue().getTicketType().equals(ticketType)
                                 && Integer.parseInt(entry.getValue().getPrice()) >= priceFrom
                                 && Integer.parseInt(entry.getValue().getPrice()) <= priceTo)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}