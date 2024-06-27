package entity;

import java.sql.Timestamp;

public class UserEntity {

    private int id;
    private String name;
    private Timestamp creationDate;

    public UserEntity(int id, String name, Timestamp creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }

    public UserEntity(String name, Timestamp creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", creationDate=" + creationDate +
               '}';
    }
}