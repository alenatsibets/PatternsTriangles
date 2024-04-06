package edu.pattern.shapes.reader;

import edu.pattern.shapes.exception.TriangleException;

import java.util.List;


public interface TriangleFileReader {
    List<Double[]> parseTriangleParameters(String file) throws TriangleException;
}