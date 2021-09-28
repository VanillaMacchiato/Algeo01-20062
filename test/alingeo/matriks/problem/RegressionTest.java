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
 * @author vitos
 */
public class RegressionTest {
    
    public RegressionTest() {
    }

    /**
     * Test of getIntercept method, of class Regression.
     */
//    @Test
//    public void testGetIntercept() {
//        System.out.println("getIntercept");
//        Regression instance = new Regression();
//        double expResult = 0.0;
//        double result = instance.getIntercept();
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCoef method, of class Regression.
//     */
//    @Test
//    public void testGetCoef() {
//        System.out.println("getCoef");
//        Regression instance = new Regression();
//        double[] expResult = null;
//        double[] result = instance.getCoef();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of fit method, of class Regression.
     */
    @Test
    public void testFit() {
        System.out.println("fit");
        Matrix m = new Matrix(new double[][]{
            {60, 22, 140},
            {62, 25, 155},
            {67, 24, 159},
            {70, 20, 179},
            {71, 15, 192},
            {72, 14, 200},
            {75, 14, 212},
            {78, 11, 215}
        });
        Regression instance = new Regression();
        instance.fit(m);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(false, true);
    }

    /**
     * Test of predict method, of class Regression.
     */
    @Test
    public void testPredict() {
        System.out.println("predict");
        Regression instance = new Regression();
        instance.predict();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
