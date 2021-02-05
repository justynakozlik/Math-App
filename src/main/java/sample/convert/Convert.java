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

}
