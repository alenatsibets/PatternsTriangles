package edu.pattern.shapes.observer;

import edu.pattern.shapes.model.Triangle;

public interface TriangleObserver {
    void update(Triangle triangle);
}
