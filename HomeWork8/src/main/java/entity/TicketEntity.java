package entity;

import enums.TicketType;

import java.sql.Timestamp;

public class TicketEntity {

    private int id;
    private int userId;
    private TicketType ticketType;
    private Timestamp creationDate;

    public TicketEntity(int id, int userId, TicketType ticketType, Timestamp creationDate) {
        this.id = id;
        this.userId = userId;
        this.ticketType = ticketType;
        this.creationDate = creationDate;
    }

    public TicketEntity(int userId, TicketType ticketType, Timestamp creationDate) {
        this.userId = userId;
        this.ticketType = ticketType;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
               "id=" + id +
               ", userId=" + userId +
               ", ticketType=" + ticketType +
               ", creationDate=" + creationDate +
               '}';
    }
}