package edu.pattern.shapes.reader.impl;

import edu.pattern.shapes.exception.TriangleException;
import edu.pattern.shapes.main.Main;
import edu.pattern.shapes.reader.TriangleFileReader;
import edu.pattern.shapes.validator.InputValidator;
import edu.pattern.shapes.validator.impl.InputValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class TriangleFileReaderImpl implements TriangleFileReader {
    private static final Logger logger = LogManager.getLogger(TriangleFileReaderImpl.class.getName());
    public static final String PARAMETERS_SEPARATOR = " ";

    public List<Double[]> parseTriangleParameters(String file) throws TriangleException {
        InputValidator inputValidator = new InputValidatorImpl();
        List<Double[]> newTriangles = new ArrayList<>();
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(file);
        if (inputStream == null) {
            logger.error("Sorry, unable to find data.txt");
            throw new TriangleException("Sorry, unable to find data.txt");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
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
                    logger.error("Cannot split the data " + line + e);
                }
            }
        } catch (IOException e) {
            logger.error("Error with reader creating " + e);
            throw new TriangleException("Error with reader creating", e);
        }
        return newTriangles;
    }

}