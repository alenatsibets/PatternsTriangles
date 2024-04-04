package edu.pattern.shapes.model;

public enum TriangleState {
    INVALID, REGULAR, ISOSCELES, EQUILATERAL;

    public static TriangleState detect(Triangle triangle) {
        return detect(triangle.getSideA(), triangle.getSideB(), triangle.getSideC());
    }

    public static TriangleState detect(double sideA, double sideB, double sideC) {
        boolean isValid = !(sideA + sideB <= sideC) &&
                !(sideA + sideC <= sideB) &&
                !(sideB + sideC <= sideA);

        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            isValid = false;
        }

        if (sideA == sideB && sideB == sideC && isValid) {
            return EQUILATERAL;
        }

        if ((sideA == sideB || sideB == sideC
                || sideA == sideC) && isValid) {
            return ISOSCELES;
        }

        if (!isValid) {
            return INVALID;
        }

        return REGULAR;
    }
}
