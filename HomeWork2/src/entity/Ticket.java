package entity;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Ticket {

    public static final String ID_VALIDATION = "ID must be a maximum of 4 digits and/or chars.";
    public static final String CONCERT_HALL_VALIDATION = "Concert hall must be a maximum of 10 chars.";
    public static final String EVENT_CODE_VALIDATION = "Event code must be exactly 3 digits.";
    public static final String STADIUM_SECTOR_VALIDATION = "Stadium sector must be between 'A' and 'C' including.";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final char STADIUM_SECTOR_MIN = 'A';
    public static final char STADIUM_SECTOR_MAX = 'C';
    public static final int EVENT_CODE_MIN = 100;
    public static final int EVENT_CODE_MAX = 999;
    public static final int CONCERT_HALL_MAX = 10;
    public static final int ID_MAX = 4;

    private String id;
    private String concertHall;
    private int eventCode;
    private long time;
    private boolean isPromo;
    private char stadiumSector;
    private double maxBackpackWeight;
    private double price;
    private final long creationTime;

    public Ticket(String id,
                  String concertHall,
                  int eventCode,
                  long time,
                  boolean isPromo,
                  char stadiumSector,
                  double maxBackpackWeight,
                  double price) {
        setId(id);
        setConcertHall(concertHall);
        setEventCode(eventCode);
        setTime(time);
        setPromo(isPromo);
        setStadiumSector(stadiumSector);
        setMaxBackpackWeight(maxBackpackWeight);
        setPrice(price);
        this.creationTime = Instant.now().getEpochSecond();
    }

    public Ticket(String concertHall, int eventCode, long time) {
        setConcertHall(concertHall);
        setEventCode(eventCode);
        setTime(time);
        this.creationTime = Instant.now().getEpochSecond();
    }

    public Ticket() {
        this.creationTime = Instant.now().getEpochSecond();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && id.length() <= ID_MAX) {
            this.id = id;
        } else {
            throw new IllegalArgumentException(ID_VALIDATION);
        }
    }

    public String getConcertHall() {
        return concertHall;
    }

    public void setConcertHall(String concertHall) {
        if (concertHall != null && concertHall.length() <= CONCERT_HALL_MAX) {
            this.concertHall = concertHall;
        } else {
            throw new IllegalArgumentException(CONCERT_HALL_VALIDATION);
        }
    }

    public int getEventCode() {
        return eventCode;
    }

    public void setEventCode(int eventCode) {
        if (eventCode >= EVENT_CODE_MIN && eventCode <= EVENT_CODE_MAX) {
            this.eventCode = eventCode;
        } else {
            throw new IllegalArgumentException(EVENT_CODE_VALIDATION);
        }
    }

    public long getTime() {
        return time;
    }

    public String getFormattedTime() {
        return formatUnixTimestamp(this.time);
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public void setPromo(boolean promo) {
        isPromo = promo;
    }

    public char getStadiumSector() {
        return stadiumSector;
    }

    public void setStadiumSector(char stadiumSector) {
        if (stadiumSector >= STADIUM_SECTOR_MIN && stadiumSector <= STADIUM_SECTOR_MAX) {
            this.stadiumSector = stadiumSector;
        } else {
            throw new IllegalArgumentException(STADIUM_SECTOR_VALIDATION);
        }
    }

    public double getMaxBackpackWeight() {
        return maxBackpackWeight;
    }

    public void setMaxBackpackWeight(double maxBackpackWeight) {
        this.maxBackpackWeight = maxBackpackWeight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public String getFormattedCreationTime() {
        return formatUnixTimestamp(this.creationTime);
    }

    private String formatUnixTimestamp(long timestamp) {
        return Instant.ofEpochSecond(timestamp)
                .atZone(ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    }
}