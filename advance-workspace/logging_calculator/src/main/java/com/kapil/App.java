package com.kapil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

    private static final Logger logger =
            LogManager.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("Application started");

        Calculator c = new Calculator();

        c.divide(10, 2);

        c.divide(5, 0);

        logger.warn("This is warning");

        logger.fatal("Fatal message");

        logger.info("Application finished");
    }
}