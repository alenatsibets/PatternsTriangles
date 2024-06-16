package edu.pattern.shapes.validator.impl;

import edu.pattern.shapes.model.TriangleState;
import edu.pattern.shapes.validator.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class TriangleValidatorImpl implements TriangleValidator {
    private static final Logger logger = LogManager.getLogger(TriangleValidatorImpl.class.getName());
    public boolean isValid(Double[] param){
        boolean valid = true;
        TriangleState currentState = TriangleState.detect(param[0], param[1], param[2]);
        if (currentState == TriangleState.INVALID) {
            valid = false;
            logger.error("Invalid triangle data: " + Arrays.toString(param));
        }
        return valid;
    }
}