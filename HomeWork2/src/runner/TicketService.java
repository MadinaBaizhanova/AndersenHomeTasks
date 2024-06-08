package runner;

import entity.Ticket;
import enums.StadiumSector;

import java.math.BigDecimal;

public class TicketService {

    public static final String EMPTY_TICKET = "Empty Ticket: ";
    public static final String LIMITED_TICKET = "Limited Ticket: ";
    public static final String FULL_TICKET = "Full Ticket: ";
    public static final String TICKET_CREATION_TIME = "Ticket Creation Time - ";
    public static final String CONCERT_HALL = "Concert Hall - ";
    public static final String EVENT_CODE = "Event Code - ";
    public static final String TIME = "Time - ";
    public static final String IS_PROMO = "Is Promo - ";
    public static final String STADIUM_SECTOR = "Stadium Sector - ";
    public static final String MAX_BACKPACK_WEIGHT_KG = "Max Backpack Weight, kg - ";
    public static final String PRICE_$ = "Price, $ - ";
    public static final String ID = "ID - ";
    public static final String NEW_LINE = "\n";

    public static final String EXAMPLE_ID = "4AB5";
    public static final String EXAMPLE_CONCERT_HALL = "Hall 1";
    public static final int EXAMPLE_TICKET_DATE_TIME = 1717999200;
    public static final int EXAMPLE_EVENT_CODE = 111;
    public static final StadiumSector EXAMPLE_STADIUM_SECTOR = StadiumSector.A;
    public static final double EXAMPLE_MAX_BACKPACK_WEIGHT = 3.5;
    public static final BigDecimal EXAMPLE_PRICE = BigDecimal.valueOf(59.9);

    public static void main(String[] args) {

        Ticket emptyTicket = new Ticket();
        System.out.println(EMPTY_TICKET + NEW_LINE + TICKET_CREATION_TIME + emptyTicket.getFormattedCreationTime());
        System.out.println();

        Ticket limitedTicket = new Ticket(EXAMPLE_CONCERT_HALL, EXAMPLE_EVENT_CODE, EXAMPLE_TICKET_DATE_TIME);
        System.out.println(LIMITED_TICKET + NEW_LINE
                           + CONCERT_HALL + limitedTicket.getConcertHall() + NEW_LINE
                           + EVENT_CODE + limitedTicket.getEventCode() + NEW_LINE
                           + TIME + limitedTicket.getFormattedTime() + NEW_LINE
                           + TICKET_CREATION_TIME + limitedTicket.getFormattedCreationTime());
        System.out.println();

        Ticket fullTicket = new Ticket(
                EXAMPLE_ID,
                EXAMPLE_CONCERT_HALL,
                EXAMPLE_EVENT_CODE,
                EXAMPLE_TICKET_DATE_TIME,
                false,
                EXAMPLE_STADIUM_SECTOR,
                EXAMPLE_MAX_BACKPACK_WEIGHT,
                EXAMPLE_PRICE);
        System.out.println(FULL_TICKET + NEW_LINE
                           + ID + fullTicket.getId() + NEW_LINE
                           + CONCERT_HALL + fullTicket.getConcertHall() + NEW_LINE
                           + EVENT_CODE + fullTicket.getEventCode() + NEW_LINE
                           + TIME + fullTicket.getFormattedTime() + NEW_LINE
                           + IS_PROMO + fullTicket.isPromo() + NEW_LINE
                           + STADIUM_SECTOR + fullTicket.getStadiumSector() + NEW_LINE
                           + MAX_BACKPACK_WEIGHT_KG + fullTicket.getMaxBackpackWeight() + NEW_LINE
                           + PRICE_$ + fullTicket.getPrice() + NEW_LINE
                           + TICKET_CREATION_TIME + fullTicket.getFormattedCreationTime());
    }
}