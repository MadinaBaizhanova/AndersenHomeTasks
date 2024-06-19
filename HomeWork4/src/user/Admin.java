package user;

import entity.Ticket;
import enums.UserRole;

public class Admin extends User {
    public Admin(String name) {
        super(name, UserRole.ADMIN);
    }

    @Override
    public void performUniqueFunction(Ticket ticket) {
        if (ticket != null) {
            System.out.println("Admin " + getName() + " checked ticket: " + ticket);
        } else {
            System.out.println("Ticket not found.");
        }
    }

    @Override
    public void print() {
        System.out.println("Admin{name='" + getName() + "', role=" + getRole() + "}");
    }
}

/*
Task #5

In your application, there should be 2 Users - Client and Admin.

Both should be able to .printRole().

Also, they should have unique functions - getTicket() for User and checkTicket() - for Admin.

Think about inheritance and the type of polymorphism that you will use here.

In the .main() method show the example of the chosen polymorphism approach.
 */