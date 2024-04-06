package edu.pattern.shapes.reader.impl;

import edu.pattern.shapes.exception.TriangleException;
import edu.pattern.shapes.reader.TriangleFileReader;
import edu.pattern.shapes.validator.InputValidator;
import edu.pattern.shapes.validator.impl.InputValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static edu.pattern.shapes.constant.TriangleConstants.PARAMETERS_SEPARATOR;

public class TriangleFileReaderImpl implements TriangleFileReader {
    private static final Logger logger = LogManager.getLogger(TriangleFileReaderImpl.class.getName());

    public List<Double[]> parseTriangleParameters(String file) throws TriangleException {
        InputValidator inputValidator = new InputValidatorImpl();
        List<Double[]> newTriangles = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] params = line.split(PARAMETERS_SEPARATOR);

                    if (!inputValidator.hasTreeParameters(params)) {
                        continue;
                    }

                    Optional<Double[]> opt = inputValidator.validParameters(params);
                    if (opt.isEmpty()) {
                        continue;
                    }

                    Double[] triangle = opt.get();
                    newTriangles.add(triangle);

                } catch (IllegalArgumentException e) {
                    logger.error("Cannot split the data " + line);
                }
            }
        } catch (IOException e) {
            logger.error("Error with reader creating");
            throw new TriangleException("Error with reader creating", e);
        }
        return newTriangles;
    }

}