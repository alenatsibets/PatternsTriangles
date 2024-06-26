package edu.pattern.shapes.creator.impl;

import edu.pattern.shapes.creator.TriangleFactory;
import edu.pattern.shapes.exception.TriangleException;
import edu.pattern.shapes.model.Triangle;
import edu.pattern.shapes.reader.TriangleFileReader;
import edu.pattern.shapes.reader.impl.TriangleFileReaderImpl;
import edu.pattern.shapes.validator.TriangleValidator;
import edu.pattern.shapes.validator.impl.TriangleValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class TriangleFactoryImpl implements TriangleFactory {
    private static final Logger logger = LogManager.getLogger(TriangleFactoryImpl.class.getName());

    @Override
    public List<Triangle> createTriangles(String file) throws TriangleException {
        List<Double[]> parameters;
        try {
            TriangleFileReader reader = new TriangleFileReaderImpl();
            parameters = reader.parseTriangleParameters(file);
        } catch (TriangleException e) {
            logger.info("Don't have parameters " + e);
            throw new TriangleException(e);
        }
        return createTriangles(parameters);
    }

    public List<Triangle> createTriangles(List<Double[]> parameters) {
        TriangleValidator triangleValidator = new TriangleValidatorImpl();
        List<Triangle> newTriangles = new ArrayList<>();
        for (Double[] tr : parameters) {
            if (triangleValidator.isValid(tr)) {
                Triangle triangle = new Triangle(tr[0], tr[1], tr[2]);
                newTriangles.add(triangle);
                logger.info("A new triangle: " + triangle);
            }
        }
        return newTriangles;
    }
}