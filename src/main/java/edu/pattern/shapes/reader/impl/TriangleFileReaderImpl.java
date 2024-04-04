package edu.pattern.shapes.reader.impl;

import edu.pattern.shapes.exception.TriangleException;
import edu.pattern.shapes.reader.TriangleFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static edu.pattern.shapes.constant.TriangleConstants.PARAMETERS_SEPARATOR;
import static edu.pattern.shapes.validator.InputValidator.hasTreeParameters;
import static edu.pattern.shapes.validator.InputValidator.validParameters;

public class TriangleFileReaderImpl implements TriangleFileReader {
    private static final Logger logger = LogManager.getLogger(TriangleFileReaderImpl.class.getName());

    public static List<Double[]> parseTriangleParameters(String file) throws TriangleException {
        List<Double[]> newTriangles = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] params = line.split(PARAMETERS_SEPARATOR);

                    if (!hasTreeParameters(params)) {
                        continue;
                    }

                    Optional<Double[]> opt = validParameters(params);
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
