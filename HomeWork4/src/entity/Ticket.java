package entity;

import annotation.NullableWarning;
import annotation.NullableWarningChecker;
import enums.StadiumSector;
import util.Printable;
import util.TicketModifiable;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Ticket implements Printable, TicketModifiable {

    public static final String ID_VALIDATION = "ID must be a maximum of 4 digits and/or chars.";
    public static final String CONCERT_HALL_VALIDATION = "Concert hall must be a maximum of 10 chars.";
    public static final String EVENT_CODE_VALIDATION = "Event code must be exactly 3 digits.";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final int EVENT_CODE_MIN = 100;
    public static final int EVENT_CODE_MAX = 999;
    public static final int CONCERT_HALL_MAX = 10;
    public static final int ID_MAX = 4;

    @NullableWarning
    private String id;
    private String concertHall;
    private int eventCode;
    private long time;
    private boolean isPromo;
    private StadiumSector stadiumSector;
    private double maxBackpackWeight;
    private BigDecimal price;
    private final long creationTime;

    public Ticket(String id,
                  String concertHall,
                  int eventCode,
                  long time,
                  boolean isPromo,
                  StadiumSector stadiumSector,
                  double maxBackpackWeight,
                  BigDecimal price) {
        this.id = id;
        setConcertHall(concertHall);
        setEventCode(eventCode);
        setTime(time);
        setPromo(isPromo);
        setStadiumSector(stadiumSector);
        setMaxBackpackWeight(maxBackpackWeight);
        setPrice(price);
        this.creationTime = Instant.now().getEpochSecond();
        NullableWarningChecker.checkForNullableWarnings(this);
    }

    public Ticket(String concertHall, int eventCode, long time) {
        setConcertHall(concertHall);
        setEventCode(eventCode);
        setTime(time);
        this.creationTime = Instant.now().getEpochSecond();
        NullableWarningChecker.checkForNullableWarnings(this);
    }

    public Ticket() {
        this.creationTime = Instant.now().getEpochSecond();
        NullableWarningChecker.checkForNullableWarnings(this);
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

    public StadiumSector getStadiumSector() {
        return stadiumSector;
    }

    public void setStadiumSector(StadiumSector stadiumSector) {
        this.stadiumSector = stadiumSector;
    }

    public double getMaxBackpackWeight() {
        return maxBackpackWeight;
    }

    public void setMaxBackpackWeight(double maxBackpackWeight) {
        this.maxBackpackWeight = maxBackpackWeight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFormattedCreationTime() {
        return formatUnixTimestamp(this.creationTime);
    }

    private String formatUnixTimestamp(long timestamp) {
        return Instant.ofEpochSecond(timestamp)
                .atZone(ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    }

    @Override
    public void changeTime(long time) {
        this.time = time;
    }

    @Override
    public void changeStadiumSector(StadiumSector stadiumSector) {
        this.stadiumSector = stadiumSector;
    }

    @Override
    public String getAllTicketValues() {
        return toString();
    }

    /*
    Override equals(), toString() and hashCode() in your Ticket class, so they will be able to return meaningful
    values that follow equals & hashCode contract.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return eventCode == ticket.eventCode &&
               time == ticket.time &&
               isPromo == ticket.isPromo &&
               Double.compare(maxBackpackWeight, ticket.maxBackpackWeight) == 0 &&
               Objects.equals(id, ticket.id) &&
               Objects.equals(concertHall, ticket.concertHall) &&
               stadiumSector == ticket.stadiumSector &&
               Objects.equals(price, ticket.price) &&
               creationTime == ticket.creationTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, concertHall, eventCode, time, isPromo, stadiumSector, maxBackpackWeight, price, creationTime);
    }

    @Override
    public String toString() {
        return "Ticket{" +
               "id='" + id + '\'' +
               ", concertHall='" + concertHall + '\'' +
               ", eventCode=" + eventCode +
               ", time=" + time +
               ", isPromo=" + isPromo +
               ", stadiumSector=" + stadiumSector +
               ", maxBackpackWeight=" + maxBackpackWeight +
               ", price=" + price +
               ", creationTime=" + creationTime +
               '}';
    }
}