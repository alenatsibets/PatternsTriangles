package edu.pattern.shapes.model;

public enum TriangleState {
    INVALID, REGULAR, ISOSCELES, EQUILATERAL, RIGHT;

    public static TriangleState detect(Triangle triangle) {
        return detect(triangle.getSideA(), triangle.getSideB(), triangle.getSideC());
    }

    public static TriangleState detect(double sideA, double sideB, double sideC) {
        TriangleState state = REGULAR;
        boolean isValid = !(sideA + sideB <= sideC) &&
                !(sideA + sideC <= sideB) &&
                !(sideB + sideC <= sideA);

        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            isValid = false;
        }

        if ((sideA == sideB || sideB == sideC
                || sideA == sideC) && isValid) {
            state = ISOSCELES;
        }

        if (sideA == sideB && sideB == sideC && isValid) {
            state = EQUILATERAL;
        }

        if ((sideA * sideA + sideB * sideB == sideC * sideC
                || sideB * sideB + sideC * sideC == sideA * sideA
                || sideA * sideA + sideC * sideC == sideB * sideB)
                && isValid) {
            state = RIGHT;
        }

        if (!isValid) {
            state = INVALID;
        }

        return state;
    }
}
