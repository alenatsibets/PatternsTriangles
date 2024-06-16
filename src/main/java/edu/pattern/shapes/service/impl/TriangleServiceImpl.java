package edu.pattern.shapes.service.impl;

import edu.pattern.shapes.model.Triangle;
import edu.pattern.shapes.model.TriangleState;
import edu.pattern.shapes.service.TriangleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleServiceImpl implements TriangleService {
    private static final Logger logger = LogManager.getLogger(TriangleServiceImpl.class.getName());

    @Override
    public double perimeter(Triangle triangle) {
        double perimeter = -1;
        if (triangle.getState() != TriangleState.INVALID) {
            perimeter = triangle.getSideA() + triangle.getSideC() + triangle.getSideB();
        }
        logger.info("Perimeter calculated: " + perimeter);
        return perimeter;
    }

    @Override
    public double area(Triangle triangle) {
        double area = -1;
        if (triangle.getState() != TriangleState.INVALID) {
            double semiPerimeter = (triangle.getSideA() + triangle.getSideB() + triangle.getSideC()) / 2.0;
            area = Math.sqrt(semiPerimeter * (semiPerimeter - triangle.getSideA()) * (semiPerimeter - triangle.getSideB()) * (semiPerimeter - triangle.getSideC()));
        }
        logger.info("Area calculated: " + area);
        return area;
    }
}