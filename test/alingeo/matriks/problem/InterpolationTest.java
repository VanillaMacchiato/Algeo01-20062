/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alingeo.matriks.problem;

import alingeo.matriks.Matrix;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Windows 7
 */
public class InterpolationTest {

    double EPSILON = 0.000001;

    public InterpolationTest() {
    }

    /**
     * Test of isFit method, of class Interpolation.
     */
    @Test
    public void testIsFit() {
        System.out.println("isFit");
        Interpolation instance = new Interpolation();
        boolean expResult = false;
        boolean result = instance.isFit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCount method, of class Interpolation.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        Interpolation instance = new Interpolation();
        int expResult = 0;
        int result = instance.getCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPoints method, of class Interpolation.
     */
    @Test
    public void testAddPoints() {
        System.out.println("addPoints");
        Matrix points = null;
        Interpolation instance = new Interpolation();
        instance.addPoints(points);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fit method, of class Interpolation.
     */
    @Test
    public void testFit() {
        System.out.println("fit");

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of evaluate method, of class Interpolation.
     */
    @Test
    public void testEvaluate() {
        System.out.println("evaluate");
        Matrix points = new Matrix(new double[][]{
            {0.1, 0.003},
            {0.3, 0.067},
            {0.5, 0.148},
            {0.7, 0.248},
            {0.9, 0.370},
            {1.1, 0.518},
            {1.3, 0.697}
        });
        Interpolation ins = new Interpolation(points);
        ins.fit();
        assertEquals(0.003, ins.evaluate(0.1), EPSILON);
        assertEquals(0.032961, ins.evaluate(0.2), EPSILON);
        assertEquals(0.171119, ins.evaluate(0.55), EPSILON);
        assertEquals(0.337236, ins.evaluate(0.85), EPSILON);
        assertEquals(0.677542, ins.evaluate(1.28), EPSILON);
        assertEquals(0.697, ins.evaluate(1.3), EPSILON);
        points.setData(new double[][]{
            {6.567, 12.624},
            {7, 21.807},
            {7.258, 38.391},
            {7.451, 54.517},
            {7.548, 51.952},
            {7.839, 28.228},
            {8.161, 35.764},
            {8.484, 20.813},
            {8.709, 12.408},
            {9, 10.534}
        });
        ins = new Interpolation(points);
        ins.fit();
    }

    /**
     * Test of toString method, of class Interpolation.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Interpolation instance = new Interpolation();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
