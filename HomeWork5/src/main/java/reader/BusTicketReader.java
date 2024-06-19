package reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import entity.BusTicket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.stream.Collectors.toList;
import static util.Constants.*;

public class BusTicketReader {

    private static final Logger logger = Logger.getLogger(BusTicketReader.class.getName());

    public static List<BusTicket> readTicketsFromFile(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try (InputStream inputStream = BusTicketReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                logger.log(Level.SEVERE, FILE_NOT_FOUND + fileName);
                return null;
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                return reader.lines()
                        .map(line -> {
                            try {
                                return objectMapper.readValue(line, BusTicket.class);
                            } catch (IOException e) {
                                logger.log(Level.SEVERE, FAILED_TO_PARSE_LINE + line, e);
                                return null;
                            }
                        })
                        .filter(Objects::nonNull)
                        .collect(toList());
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, FAILED_TO_READ_FILE + fileName, e);
            return null;
        }
    }
}