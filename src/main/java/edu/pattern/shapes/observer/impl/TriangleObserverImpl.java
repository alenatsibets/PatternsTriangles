package edu.pattern.shapes.observer.impl;

import edu.pattern.shapes.model.Triangle;
import edu.pattern.shapes.model.Warehouse;
import edu.pattern.shapes.observer.TriangleObserver;
import edu.pattern.shapes.service.TriangleService;
import edu.pattern.shapes.service.impl.TriangleServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleObserverImpl implements TriangleObserver {
    private static final Logger logger = LogManager.getLogger(TriangleObserverImpl.class.getName());

    @Override
    public void update(Triangle triangle) {
        TriangleService service = new TriangleServiceImpl();
        double perimeter = service.perimeter(triangle);
        double area = service.area(triangle);
        int key = triangle.getTriangleId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(key, perimeter, area);
        logger.info("Warehouse updated");
    }
}