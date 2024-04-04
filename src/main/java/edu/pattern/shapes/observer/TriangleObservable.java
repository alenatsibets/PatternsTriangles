package edu.pattern.shapes.observer;

public interface TriangleObservable {
    void attach();

    void detach();

    void notifyObservers();
}
