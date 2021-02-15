package sample.count;

public class Area {

    public double circleArea(double r){
        double power = Math.pow(r,2);
        return Math.PI*power;
    }

    public double triangleArea(double a, double h){
        return a/2 * h;
    }

    public double squareArea(double a){
        return Math.pow(a,2);
    }

    public double rectangleArea(double a, double b){
        return a * b;
    }

    public double trapeziumArea(double a, double b, double h){
        return (a + b)/2 * h;
    }

    public double rhomboidArea(double a, double h){
        return a * h;
    }

    public double rhombArea(double e, double f){
        return (e * f)/2;
    }

}
