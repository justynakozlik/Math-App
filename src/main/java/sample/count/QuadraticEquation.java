package sample.count;

import sample.convert.Convert;

public class QuadraticEquation {

    private Convert convert;

    public String quadraticEquation(double a, double b, double c) {

        double delta = Math.pow(b, 2) - 4 * a * c;

        double rootOfDelta = Math.sqrt(delta);

        convert = new Convert();

        if (delta > 0) {
            double k = 2 * a;
            double x1 = ((-b - rootOfDelta) / k);
            double x2 = ((-b + rootOfDelta) / k);

            String x1String = convert.customFormat("###.###", x1);
            String x2String = convert.customFormat("###.###", x2);

            return "The equation has two solutions: " + "\n" + "x1 = " + x1String + "\n" + "x2 = " + x2String;

        } else if (delta == 0) {
            double j = 2 * a;
            double x = -b / j;

            String xString = convert.customFormat("###.###", x);

            return "The equation has one solution: " + "\n" + "x = " + xString;

        } else {

            return "The equation has no solution.";
        }
    }
}


