package sample.count;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class QuadraticEquationTest {

    private static QuadraticEquation quadraticEquation;
    private static double a;
    private static double b;
    private static double c;

    @BeforeAll
    static void init(){
        quadraticEquation = new QuadraticEquation();
    }

    @Test
    void givenExemplaryParametersWhenQuadraticEquationMethodIsUsedThenEquationHasTwoSolutions(){

        a = 1;
        b = 2;
        c = -3;

        String solution = quadraticEquation.quadraticEquation(a, b, c);

        Assertions.assertEquals("The equation has two solutions: " + "\n" + "x1 = " + "-3" + "\n" + "x2 = " + "1", solution);
    }


    @Test
    void givenExemplaryParametersWhenQuadraticEquationMethodIsUsedThenEquationHasOneSolution(){

        a = 1;
        b = 2;
        c = 1;

        String solution = quadraticEquation.quadraticEquation(a, b, c);

        Assertions.assertEquals("The equation has one solution: " + "\n" + "x = " + "-1", solution);
    }

    @Test
    void givenExemplaryParametersWhenQuadraticEquationMethodIsUsedThenEquationHasNoSolution(){

        a = 2;
        b = 0;
        c = 5;

        String solution = quadraticEquation.quadraticEquation(a, b, c);

        Assertions.assertEquals("The equation has no solution.", solution);
    }
}