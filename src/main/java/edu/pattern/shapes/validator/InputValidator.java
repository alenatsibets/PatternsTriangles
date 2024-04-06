package edu.pattern.shapes.validator;

import java.util.Optional;

public interface InputValidator {
    boolean hasTreeParameters(String[] param);

    Optional<Double[]> validParameters(String[] params);
}
