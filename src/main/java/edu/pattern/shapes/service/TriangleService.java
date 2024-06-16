package edu.pattern.shapes.service;

import edu.pattern.shapes.model.Triangle;

public interface TriangleService {
    double perimeter(Triangle triangle);

    double area(Triangle triangle);
}