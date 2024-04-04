package edu.pattern.shapes.validator;

import edu.pattern.shapes.model.Triangle;
import edu.pattern.shapes.model.TriangleState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class TriangleValidator {
    private static final Logger logger = LogManager.getLogger(TriangleValidator.class.getName());
    public static boolean isValid(Double[] param){
        boolean valid = true;
        TriangleState currentState = TriangleState.detect(param[0], param[1], param[2]);
        if (currentState == TriangleState.INVALID) {
            valid = false;
            logger.error("Invalid triangle data: " + Arrays.toString(param));
        }
        return valid;
    }
}
