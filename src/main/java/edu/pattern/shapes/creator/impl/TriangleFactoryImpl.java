package edu.pattern.shapes.creator.impl;

import edu.pattern.shapes.creator.TriangleFactory;
import edu.pattern.shapes.exception.TriangleException;
import edu.pattern.shapes.model.Triangle;
import edu.pattern.shapes.model.TriangleState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static edu.pattern.shapes.reader.impl.TriangleFileReaderImpl.parseTriangleParameters;
import static edu.pattern.shapes.validator.TriangleValidator.isValid;

public class TriangleFactoryImpl implements TriangleFactory {
    private static final Logger logger = LogManager.getLogger(TriangleFactoryImpl.class.getName());
    @Override
    public List<Triangle> createTriangles(String file){
        List<Double[]> parameters;
        try {
            parameters = parseTriangleParameters(file);
        } catch (TriangleException e) {
            logger.info("Don't have parameters");
            throw new RuntimeException(e);
        }
        List<Triangle> newTriangles = new ArrayList<>();
        for (Double[] tr : parameters) {
            if (isValid(tr)) {
                Triangle triangle = new Triangle(tr[0], tr[1], tr[2]);
                newTriangles.add(triangle);
                logger.info("A new triangle: " + triangle);
            }
        }
        return newTriangles;
    }
}
