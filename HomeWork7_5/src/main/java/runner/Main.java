package runner;

import custom_implementation.CustomArrayList;
import custom_implementation.CustomHashSet;

import java.util.logging.*;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        logger.info("CUSTOM ARRAY LIST DEMONSTRATION");

        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();

        logger.info("INITIAL CAPACITY: " + customArrayList.getCapacity());

        logger.info("ADDING 10 ELEMENTS...");
        for (int i = 0; i < 10; i++) {
            customArrayList.put(i);
        }

        logger.info("CURRENT ELEMENTS IN THE LIST:");
        for (int i = 0; i < customArrayList.size(); i++) {
            logger.info(customArrayList.getByIndex(i).toString());
        }

        logger.info("ADDING 11TH ELEMENT...");
        customArrayList.put(10);

        logger.info("ELEMENTS' LIST AFTER ADDING A NEW ELEMENT:");
        for (int i = 0; i < customArrayList.size(); i++) {
            logger.info(customArrayList.getByIndex(i).toString());
        }

        logger.info("RESIZED CAPACITY AFTER ADDING A NEW ELEMENT: " + customArrayList.getCapacity());

        logger.info("ELEMENT AT INDEX 5: " + customArrayList.getByIndex(5));

        logger.info("DELETING ELEMENTS BY INDEX 4 AND 5...");
        customArrayList.deleteByIndex(5);
        customArrayList.deleteByIndex(4);
        logger.info("ELEMENTS' LIST AFTER DELETING BY INDEX 4 AND 5:");
        for (int i = 0; i < customArrayList.size(); i++) {
            logger.info(customArrayList.getByIndex(i).toString());
        }
        logger.info("ELEMENT AT INDEX 5 AFTER DELETION: " + customArrayList.getByIndex(5));

        logger.info("RESIZED CAPACITY AFTER DELETION: " + customArrayList.getCapacity()
                    + ", NEW SIZE: " + customArrayList.size());


        logger.info("CUSTOM HASH SET DEMONSTRATION");

        CustomHashSet<Integer> customHashSet = new CustomHashSet<>();

        logger.info("INITIAL CAPACITY: " + customHashSet.getCapacity() + ", INITIAL SIZE: " + customHashSet.size());

        logger.info("ADDING ELEMENTS 1 - 10 ...");
        for (int i = 1; i <= 10; i++) {
            customHashSet.put(i);
        }

        logger.info("CAPACITY AFTER ADDING 10 ELEMENTS: " + customHashSet.getCapacity());
        logger.info("SIZE AFTER ADDING 10 ELEMENTS: " + customHashSet.size());

        logger.info("ADDING ELEMENTS 11 - 15 ...");
        for (int i = 11; i <= 15; i++) {
            customHashSet.put(i);
        }

        logger.info("NEW CAPACITY AFTER ADDING NEW 5 ELEMENTS: " + customHashSet.getCapacity());
        logger.info("NEW SIZE AFTER ADDING NEW 5 ELEMENTS: " + customHashSet.size());

        logger.info("DELETING ELEMENTS 13, 14, AND 15 ...");
        customHashSet.delete(15);
        customHashSet.delete(14);
        customHashSet.delete(13);

        logger.info("NEW CAPACITY AFTER ELEMENTS' DELETION: " + customHashSet.getCapacity());
        logger.info("NEW SIZE AFTER ELEMENTS' DELETION: " + customHashSet.size());

        logger.info("CURRENT ELEMENTS IN THE LIST:");
        customHashSet.iterate();
    }
}
