package sample.count;

public class Perimeter {

    public double circlePerimeter(double r){
        return 2*Math.PI*r;
    }

    public double trianglePerimeter(double a, double b, double c){
        return a + b + c;
    }

    public double squarePerimeter(double a){
        return 4 * a;
    }

    public double rectanglePerimeter(double a, double b){
        return 2 * (a + b);
    }

    public double trapeziumPerimeter(double a, double b, double c, double d){
        return a + b + c + d;
    }

    public double rhomboidPerimeter(double a, double b){
        return 2 * (a + b);
    }

    public double rhombPerimeter(double a){
        return 4 * a;
    }
}
