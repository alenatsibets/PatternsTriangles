package edu.pattern.shapes.model;

import edu.pattern.shapes.observer.TriangleObservable;
import edu.pattern.shapes.observer.TriangleObserver;
import edu.pattern.shapes.observer.impl.TriangleObserverImpl;
import edu.pattern.shapes.util.IdGenerator;

public class Triangle implements TriangleObservable {
    private int triangleId;
    private double sideA;
    private double sideB;
    private double sideC;
    private TriangleState state = TriangleState.INVALID;
    private TriangleObserver observer = new TriangleObserverImpl();

    public Triangle(double sideA, double sideB, double sideC) {
        triangleId = IdGenerator.increment();
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        TriangleState state = TriangleState.detect(this);
        this.setState(state);
    }

    public int getTriangleId() {
        return triangleId;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
        notifyObservers();
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
        notifyObservers();
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
        notifyObservers();
    }

    public TriangleState getState() {
        return state;
    }

    public void setState(TriangleState state) {
        if (state != null) {
            this.state = state;
        }
        notifyObservers();
    }

    @Override
    public void attach() {
        observer = new TriangleObserverImpl();
    }

    @Override
    public void detach() {
        observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null) {
            observer.update(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (triangleId != triangle.triangleId) return false;
        if (Double.compare(sideA, triangle.sideA) != 0) return false;
        if (Double.compare(sideB, triangle.sideB) != 0) return false;
        if (Double.compare(sideC, triangle.sideC) != 0) return false;
        return state == triangle.state;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = triangleId;
        temp = Double.doubleToLongBits(sideA);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideB);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sideC);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + state.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "id=" + triangleId +
                ", side A=" + sideA +
                ", side B=" + sideB +
                ", side C=" + sideC +
                ", state=" + state +
                '}';
    }
}
