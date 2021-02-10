package sample.convert;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertTest {

    static Convert convert;
    static double exemplaryTemperature;

    @BeforeAll
    static void init(){
        convert = new Convert();
        exemplaryTemperature = 30;
    }


    @Test
    void givenExemplaryValueWhenCustomFormatMethodIsUsedThenOutputFormatIsCorrect(){
        String output = convert.customFormat("###.###", 7.1236);
        Assertions.assertEquals("7,124", output);
    }

    @Test
    void givenExemplaryTemperatureWhenCToKConvertMethodIsUsedThenConversionIsCorrect(){
        double solution = convert.cToKConvert(exemplaryTemperature);
        Assertions.assertEquals(303.15, solution);
    }

    @Test
    void givenExemplaryTemperatureWhenCToFConvertMethodIsUsedThenConversionIsCorrect(){
        double solution = convert.cToFConvert(exemplaryTemperature);
        Assertions.assertEquals(86, solution);
    }

    @Test
    void givenExemplaryTemperatureWhenFToKConvertMethodIsUsedThenConversionIsCorrect() {
        double solution = convert.fToKConvert(exemplaryTemperature);
        Assertions.assertEquals(272.0388888888889, solution);
    }

    @Test
    void givenExemplaryTemperatureWhenFToCConvertMethodIsUsedThenConversionIsCorrect(){
        double solution = convert.fToCConvert(exemplaryTemperature);
        Assertions.assertEquals(-1.1111111111111112, solution);
    }

    @Test
    void givenExemplaryTemperatureWhenKToCConvertMethodIsUsedThenConversionIsCorrect(){
        double solution = convert.kToCConvert(exemplaryTemperature);
        Assertions.assertEquals(-243.14999999999998, solution);
    }

    @Test
    void givenExemplaryTemperatureWhenKToFConvertMethodIsUsedThenConversionIsCorrect(){
        double solution = convert.kToFConvert(exemplaryTemperature);
        Assertions.assertEquals(-405.66999999999996, solution);
    }
}