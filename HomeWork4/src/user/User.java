package user;

import entity.Ticket;
import enums.UserRole;

public abstract class User implements util.Printable {
    private final String name;
    private final UserRole role;

    public User(String name, UserRole role) {
        this.name = name;
        this.role = role;
    }

    public void printRole() {
        System.out.println("Role: " + role);
    }

    public String getName() {
        return name;
    }

    public UserRole getRole() {
        return role;
    }

    public abstract void performUniqueFunction(Ticket ticket);

    @Override
    public void print() {
        System.out.println("User{name='" + name + "', role=" + role + "}");
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