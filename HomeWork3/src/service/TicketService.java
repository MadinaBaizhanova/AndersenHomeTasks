package service;

import entity.Ticket;
import enums.StadiumSector;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class TicketService {
    private static final String HALL = "Hall";
    private static final int EVENT_CODE = 100;
    private static final int TICKET_DATE_TIME = 1717999200;
    private static final StadiumSector STADIUM_SECTOR = StadiumSector.A;
    private static final double MAX_BACKPACK_WEIGHT = 3.5;
    private static final BigDecimal PRICE = BigDecimal.valueOf(59.9);
    private static final String FORMAT = "0000";
    private static final int MIN_TICKET_NUMBER = 1;
    private static final int MAX_TICKET_NUMBER = 10;


    private final Map<String, Ticket> tickets;

    public TicketService() {
        tickets = new HashMap<>();
        for (int i = MIN_TICKET_NUMBER; i <= MAX_TICKET_NUMBER; i++) {
            String id = new DecimalFormat(FORMAT).format(i);
            tickets.put(id, new Ticket(id, HALL + i, EVENT_CODE + i, TICKET_DATE_TIME, false, STADIUM_SECTOR, MAX_BACKPACK_WEIGHT, PRICE));
        }
    }

    public Ticket getTicketById(String ticketId) {
        return tickets.get(ticketId);
    }
}