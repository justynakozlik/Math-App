package sample.count;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerimeterTest {

    private static Perimeter perimeter;
    private static double a;
    private static double b;
    private static double c;

    @BeforeAll
    static void init(){
        perimeter = new Perimeter();
        a = 5.5;
        b = 3;
        c = 2.5;
    }

    @Test
    void givenExemplaryParametersWhenCirclePerimeterMethodIsUsedThenSolutionIsCorrect() {
        double v = perimeter.circlePerimeter(a);
        Assertions.assertEquals(34.55751918948772,v);
    }

    @Test
    void givenExemplaryParametersWhenTrianglePerimeterMethodIsUsedThenSolutionIsCorrect() {
        double v = perimeter.trianglePerimeter(a,b,c);
        Assertions.assertEquals(11,v);
    }

    @Test
    void givenExemplaryParametersWhenSquarePerimeterMethodIsUsedThenSolutionIsCorrect() {
        double v = perimeter.squarePerimeter(a);
        Assertions.assertEquals(22,v);
    }

    @Test
    void givenExemplaryParametersWhenRectanglePerimeterMethodIsUsedThenSolutionIsCorrect() {
        double v = perimeter.rectanglePerimeter(a,b);
        Assertions.assertEquals(17,v);
    }

    @Test
    void givenExemplaryParametersWhenTrapeziumPerimeterMethodIsUsedThenSolutionIsCorrect() {
        double v = perimeter.trapeziumPerimeter(a,b,c,a);
        Assertions.assertEquals(16.5,v);
    }

    @Test
    void givenExemplaryParametersWhenRhomboidPerimeterMethodIsUsedThenSolutionIsCorrect() {
        double v = perimeter.rhomboidPerimeter(a,b);
        Assertions.assertEquals(17,v);
    }

    @Test
    void givenExemplaryParametersWhenRhombPerimeterMethodIsUsedThenSolutionIsCorrect() {
        double v = perimeter.rhombPerimeter(a);
        Assertions.assertEquals(22,v);
    }
}