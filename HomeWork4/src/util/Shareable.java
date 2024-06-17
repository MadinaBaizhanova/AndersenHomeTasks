package util;

import entity.Ticket;

public interface Shareable {
    void share(Ticket ticket, String phone, String email);
}

/*
Task #4

A Ticket should be able to be .shared() by phone and by phone and email.

Think about the type of polymorphism that you will use here.

In the .main() method show the example of the chosen polymorphism approach.
 */