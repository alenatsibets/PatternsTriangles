package edu.pattern.shapes.validator.impl;

import edu.pattern.shapes.validator.InputValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Optional;

public class InputValidatorImpl implements InputValidator {
    private static final Logger logger = LogManager.getLogger(InputValidatorImpl.class.getName());
    public boolean hasTreeParameters(String[] param){
        boolean valid = true;
        if (param.length != 3) {
            logger.error("Number of parameters doesn't equals 3: " + Arrays.toString(param));
            valid = false;
        }
        return valid;
    }
    public Optional<Double[]> validParameters(String[] params){
        double sideA;
        double sideB;
        double sideC;
        try {
            sideA = Double.parseDouble(params[0]);
            sideB = Double.parseDouble(params[1]);
            sideC = Double.parseDouble(params[2]);
        } catch (NumberFormatException e) {
            logger.error("Invalid data: " + Arrays.toString(params) + e);
            return Optional.empty();
        }
        Double[] triangle = new Double[]{sideA, sideB, sideC};
        return Optional.of(triangle);
    }
}