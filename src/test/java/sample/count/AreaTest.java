package sample.count;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AreaTest {

    private static Area area;
    private static double a;
    private static double b;
    private static double h;

    @BeforeAll
    static void init(){
        area = new Area();
        a = 5.5;
        b = 3;
        h = 2.5;
    }

    @Test
    void givenExemplaryParametersWhenCircleAreaMethodIsUsedThenSolutionIsCorrect(){
        double v = area.circleArea(b);
        Assertions.assertEquals(28.274333882308138, v);
    }

    @Test
    void givenExemplaryParametersWhenTriangleAreaMethodIsUsedThenSolutionIsCorrect(){
        double v = area.triangleArea(a,h);
        Assertions.assertEquals(6.875, v);
    }

    @Test
    void givenExemplaryParametersWhenSquareAreaMethodIsUsedThenSolutionIsCorrect(){
        double v = area.squareArea(a);
        Assertions.assertEquals(30.25, v);
    }

    @Test
    void givenExemplaryParametersWhenTrapeziumAreaMethodIsUsedThenSolutionIsCorrect(){
        double v = area.trapeziumArea(a,b,h);
        Assertions.assertEquals(10.625, v);
    }

    @Test
    void givenExemplaryParametersWhenRhomboidAreaMethodIsUsedThenSolutionIsCorrect(){
        double v = area.rhomboidArea(a,h);
        Assertions.assertEquals(13.75, v);
    }

    @Test
    void givenExemplaryParametersWhenRhombAreaMethodIsUsedThenSolutionIsCorrect(){
        double v = area.rhombArea(a,h);
        Assertions.assertEquals(6.875, v);
    }
}