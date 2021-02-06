package sample.convert;

import java.text.DecimalFormat;

public class Convert {

    public String customFormat(String pattern, double value){
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        return output;
    }

    public double cToKConvert(double c){
        double solution = c + 273.15;
        return solution;
    }

    public double cToFConvert(double c){
        double solution = c * 1.8000 + 32.00;
        return  solution;
    }

    public double fToKConvert(double f){
        double solution = (f - 32.00)/1.8000 + 273.15;
        return solution;
    }

    public double fToCConvert(double f){
        double solution = (f - 32.00)/1.8000;
        return solution;
    }

    public double kToCConvert(double k){
        double solution = k - 273.15;
        return solution;
    }

    public double kToFConvert(double k){
        double solution = (k - 273.15) * 1.8000 + 32.00;
        return solution;
    }
}
