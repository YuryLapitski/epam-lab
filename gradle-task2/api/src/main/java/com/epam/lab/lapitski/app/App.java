package com.epam.lab.lapitski.app;

import com.epam.lab.lapitski.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

    private static final Logger LOG = LogManager.getLogger(App.class);
    private static final String FIRST_NUMBER = "12";
    private static final String SECOND_NUMBER = "79";

    public static void main(String[] args) {
        LOG.info("Start program...");
        try {
            if (Utils.isAllPositiveNumbers(FIRST_NUMBER, SECOND_NUMBER)) {
                LOG.trace("Numbers {}, {} are positive", FIRST_NUMBER, SECOND_NUMBER);
            } else {
                LOG.trace("One or more numbers {}, {} are negative", FIRST_NUMBER, SECOND_NUMBER);
            }
        } catch (NumberFormatException e) {
            LOG.warn(e.getMessage());
        }
        LOG.info("End program.");
    }
}
