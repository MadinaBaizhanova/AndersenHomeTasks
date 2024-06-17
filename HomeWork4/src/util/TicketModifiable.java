package util;

import enums.StadiumSector;

public interface TicketModifiable {
    void changeTime(long time);

    void changeStadiumSector(StadiumSector stadiumSector);

    String getAllTicketValues();
}

/*
Task #3

For your Ticket class from the previous lesson, there should be a possibility to change only “time” and
“stadium sector” fields.

Also, there should be a possibility to get all Ticket values.
*/