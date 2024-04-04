package edu.pattern.shapes.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Warehouse {
    private static final Warehouse instance = new Warehouse();
    private HashMap<Integer, List<Double>> map = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public List<Double> get(Integer key) {
        return map.get(key);
    }

    public Double getPerimeter(Integer key) {
        return map.get(key).get(0);
    }

    public Double getArea(Integer key) {
        return map.get(key).get(1);
    }

    public List<Double> put(Integer key, Double perimeter, Double area) {
        List<Double> parameters = new ArrayList<>();
        parameters.add(perimeter);
        parameters.add(area);
        return map.put(key, parameters);
    }

    public List<Double> put(Integer key, List<Double> parameters) {
        return map.put(key, parameters);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "map=" + map +
                '}';
    }
}
