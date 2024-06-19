package runner;

import entity.Ticket;
import enums.StadiumSector;
import user.Admin;
import user.Client;
import util.PhoneAndEmailSharing;
import util.PhoneSharing;
import util.Shareable;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Client client = new Client("Sasuke Uchiha");
        Admin admin = new Admin("Madara Uchiha");

        client.printRole();
        System.out.println();
        admin.printRole();
        System.out.println();

        Ticket ticket = new Ticket(
                "4AB5",
                "Hall 1",
                111,
                1717999200L,
                false,
                StadiumSector.A,
                3.5,
                BigDecimal.valueOf(59.9));
        ticket.print();
        System.out.println();

        client.performUniqueFunction(ticket);
        System.out.println();
        admin.performUniqueFunction(ticket);
        System.out.println();

        ticket.changeTime(1629000000L);
        ticket.changeStadiumSector(StadiumSector.B);
        System.out.println("Modified Ticket: " + ticket.getAllTicketValues());
        System.out.println();

        Shareable phoneSharing = new PhoneSharing();
        phoneSharing.share(ticket, "123-456-7890", null);
        System.out.println();

        Shareable phoneAndEmailSharing = new PhoneAndEmailSharing();
        phoneAndEmailSharing.share(ticket, "123-456-7890", "example@example.com");
        System.out.println();

        Ticket ticketWithNullId = new Ticket(
                null,
                "Hall 1",
                111,
                1717999200L,
                false,
                StadiumSector.A,
                3.5,
                BigDecimal.valueOf(59.9));
    }
}