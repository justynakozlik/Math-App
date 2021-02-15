package sample.count;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest {

    private static Volume volume;
    private static double a;
    private static double b;
    private static double h;

    @BeforeAll
    static void init(){
        volume = new Volume();
        a = 5.5;
        b = 3;
        h = 2.5;
    }

    @Test
    void givenExemplaryParametersWhenCubeVolumeMethodIsUsedThenSolutionIsCorrect(){
        double v = volume.cubeVolume(a);
        Assertions.assertEquals(166.375, v);
    }

    @Test
    void givenExemplaryParametersWhenCuboidVolumeMethodIsUsedThenSolutionIsCorrect(){
        double v = volume.cuboidVolume(a,b,h);
        Assertions.assertEquals(41.25, v);
    }

    @Test
    void givenExemplaryParametersWhenSphereVolumeMethodIsUsedThenSolutionIsCorrect(){
        double v = volume.sphereVolume(a);
        Assertions.assertEquals(696.9099703213358, v);
    }

    @Test
    void givenExemplaryParametersWhenCylinderVolumeMethodIsUsedThenSolutionIsCorrect(){
        double v = volume.cylinderVolume(a,h);
        Assertions.assertEquals(237.5829444277281, v);
    }

    @Test
    void givenExemplaryParametersWhenConeVolumeMethodIsUsedThenSolutionIsCorrect(){
        double v = volume.coneVolume(a,h);
        Assertions.assertEquals(79.1943148092427, v);
    }
}