import edu.pattern.shapes.creator.TriangleFactory;
import edu.pattern.shapes.creator.impl.TriangleFactoryImpl;
import edu.pattern.shapes.exception.TriangleException;
import edu.pattern.shapes.model.Triangle;
import edu.pattern.shapes.model.TriangleState;
import edu.pattern.shapes.service.TriangleService;
import edu.pattern.shapes.service.impl.TriangleServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static edu.pattern.shapes.constant.TriangleConstants.*;
import static edu.pattern.shapes.reader.impl.TriangleFileReaderImpl.parseTriangleParameters;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    //Test TriangleState
    @Test
    void testRegular() {
        Triangle triangle = new Triangle(4, 5, 6);

        assertEquals(TriangleState.REGULAR, triangle.getState());
    }

    @Test
    void testEquilateral() {
        Triangle triangle = new Triangle(6, 6, 6);

        assertEquals(TriangleState.EQUILATERAL, triangle.getState());
    }

    @Test
    void testIsosceles() {
        Triangle triangle = new Triangle(8, 9, 9);

        assertEquals(TriangleState.ISOSCELES, triangle.getState());
    }

    @Test
    void testInvalid() {
        Triangle triangle1 = new Triangle(7, 5, -4);
        Triangle triangle2 = new Triangle(7, 1, 1);

        assertEquals(TriangleState.INVALID, triangle1.getState());
        assertEquals(TriangleState.INVALID, triangle2.getState());
    }

    //Test TriangleService
    @Test
    void testPerimeter() {
        TriangleService service = new TriangleServiceImpl();
        Triangle triangle = new Triangle(4, 5, 6);

        assertEquals(15, service.perimeter(triangle));
    }

    @Test
    void testArea() {
        TriangleService service = new TriangleServiceImpl();
        Triangle triangle = new Triangle(4, 5, 6);

        assertEquals(9.921567416492215, service.area(triangle));
    }

    //Test TriangleFileReader
    @Test
    void testCorrectDataReader() throws TriangleException {
        Double[] triangle = {4.0, 5.0, 6.0};
        List<Double[]> parameters = parseTriangleParameters(TEST_DATA);

        assertEquals(Arrays.toString(triangle), Arrays.toString(parameters.get(0)));
    }

    @Test
    void testIncorrectDataReader() throws TriangleException {
        List<Double[]> parameters = parseTriangleParameters(INVALID_TEST_DATA);
        Double[] triangle = {};

        assertEquals(Arrays.toString(triangle), parameters.toString());
    }

    //Test TriangleFactory
    @Test
    void testTriangleFactory() {
        TriangleFactory factory = new TriangleFactoryImpl();
        List<Triangle> result = factory.createTriangles(FACTORY_TEST_DATA);

        assertEquals(3, result.size());
        assertEquals(TriangleState.REGULAR, result.get(0).getState());
        assertEquals(TriangleState.ISOSCELES, result.get(1).getState());
        assertEquals(TriangleState.EQUILATERAL, result.get(2).getState());
    }

    //Test TriangleObserver
    @Test
    void testTriangleObserver() {
        TriangleService service = new TriangleServiceImpl();
        Triangle triangle = new Triangle(4, 5, 6);

        assertEquals(15, service.perimeter(triangle));
        triangle.setSideA(6);
        assertEquals(17, service.perimeter(triangle));
    }

}
