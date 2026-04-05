package com.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App{

    private static final Logger logger = LogManager.getLogger(App.class);
    public static void main(String[] args) {

        logger.info("Program started");
        int a = 10;
        int b = 0;

        try {
            int c = a / b;
        } catch (Exception e) {
            logger.error("Exception occurred", e);
        }
        logger.debug("Debug message");
        logger.warn("Warning message");
        logger.fatal("Fatal message");

        logger.info("Program finished");
    }
}