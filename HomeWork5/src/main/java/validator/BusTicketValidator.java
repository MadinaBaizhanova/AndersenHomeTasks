package validator;

import entity.BusTicket;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import static util.Constants.*;

public class BusTicketValidator {

    public static List<String> validateTicket(BusTicket ticket) {

        List<String> violations = new ArrayList<>();

        if (ticket.getTicketType() == null || !VALID_TICKET_TYPES.contains(ticket.getTicketType())) {
            violations.add(TICKET_TYPE_VIOLATION);
        }

        if (ticket.getPrice() != null) {
            try {
                int price = Integer.parseInt(ticket.getPrice());
                if (price == ZERO_PRICE) {
                    violations.add(PRICE_VIOLATION);
                }
                if (price % 2 != 0) {
                    violations.add(PRICE_VIOLATION);
                }
            } catch (NumberFormatException e) {
                violations.add(PRICE_VIOLATION);
            }
        } else {
            violations.add(PRICE_VIOLATION);
        }

        if (ticket.getStartDate() != null && !ticket.getStartDate().isEmpty()) {
            try {
                LocalDate startDate = LocalDate.parse(ticket.getStartDate(), DATE_FORMATTER);
                if (startDate.isAfter(LocalDate.now())) {
                    violations.add(START_DATE_VIOLATION);
                }
            } catch (DateTimeParseException e) {
                violations.add(START_DATE_VIOLATION);
            }
        } else if (TICKET_TYPES_WITH_MANDATORY_START_DATE.contains(ticket.getTicketType())) {
            violations.add(START_DATE_VIOLATION);
        }

        return violations;
    }
}
