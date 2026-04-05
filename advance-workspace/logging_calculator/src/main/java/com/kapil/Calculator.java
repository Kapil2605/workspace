package com.kapil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {

    private static final Logger logger =
            LogManager.getLogger(Calculator.class);

    public int divide(int a, int b) {

        logger.trace("divide() called");

        logger.debug("Values: " + a + " , " + b);

        if (b == 0) {
            logger.error("Cannot divide by zero");
            return 0;
        }

        int result = a / b;

        logger.info("Result = " + result);

        return result;
    }
}
