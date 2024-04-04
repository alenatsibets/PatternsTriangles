package edu.pattern.shapes.creator;

import edu.pattern.shapes.exception.TriangleException;
import edu.pattern.shapes.model.Triangle;

import java.util.List;

public interface TriangleFactory {
    List<Triangle> createTriangles(String file);
}
