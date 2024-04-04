package edu.pattern.shapes.util;

public class IdGenerator {
    private static int currentId;

    public static int increment() {
        return ++currentId;
    }
}
