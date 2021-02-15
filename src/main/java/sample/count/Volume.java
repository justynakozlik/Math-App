package sample.count;

public class Volume {

    public double cubeVolume(double a){
        return Math.pow(a,3);
    }

    public double cuboidVolume(double a, double b, double c){
        return a * b * c;
    }

    public double sphereVolume(double r){
        double power = Math.pow(r,3);
        return ((4.0/3.0) * Math.PI * power);
    }

    public double cylinderVolume(double r, double h){
        double power = Math.pow(r,2);
        return Math.PI * power * h;
    }

    public double coneVolume(double r, double h){
        double power = Math.pow(r,2);
        return (Math.PI * power * h)/3;
    }
}
