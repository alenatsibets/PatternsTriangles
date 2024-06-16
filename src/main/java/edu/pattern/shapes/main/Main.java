package edu.pattern.shapes.main;

import edu.pattern.shapes.creator.TriangleFactory;
import edu.pattern.shapes.creator.impl.TriangleFactoryImpl;
import edu.pattern.shapes.exception.TriangleException;
import edu.pattern.shapes.model.Triangle;
import edu.pattern.shapes.model.Warehouse;

import java.util.List;

import static edu.pattern.shapes.constant.FileNameConstant.FILE_NAME;

public class Main {
    public static void main(String[] args) throws TriangleException {
        TriangleFactory factory = new TriangleFactoryImpl();
        List<Triangle> result = factory.createTriangles(FILE_NAME);
        System.out.println(result);
        Warehouse warehouse = Warehouse.getInstance();
        System.out.println(warehouse);
        Triangle ob = result.get(0);
        ob.setSideA(5);
        System.out.println(warehouse);
        ob.setSideC(8);
        System.out.println(warehouse);
    }
}