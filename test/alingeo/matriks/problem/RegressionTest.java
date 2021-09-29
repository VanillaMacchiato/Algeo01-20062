/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alingeo.matriks.problem;

import alingeo.matriks.Matrix;
import alingeo.matriks.solver.SPLSolver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author vitos
 */
public class RegressionTest {
    
    public RegressionTest() {
    }
    
    // Data source: https://www.statology.org/multiple-linear-regression-by-hand/
    Matrix tc1 = new Matrix(new double[][]{
        {60, 22, 140},
        {62, 25, 155},
        {67, 24, 159},
        {70, 20, 179},
        {71, 15, 192},
        {72, 14, 200},
        {75, 14, 212},
        {78, 11, 215}
    });
    
    // Subsample pada "studi kasus regresi linier berganda"
    Matrix tc2 = new Matrix(new double[][]{
        {72.4, 76.3, 29.18, 0.90},
        {41.6, 70.3, 29.35, 0.91},
        {34.3, 77.1, 29.24, 0.96},
        {35.1, 68.0, 29.27, 0.89},
        {10.7, 79.0, 29.78, 1.00},
        {12.9, 67.4, 29.39, 1.10},
        {8.30, 66.8, 29.69, 1.15},
        {20.1, 76.9, 29.48, 1.03},
        {72.2, 77.7, 29.09, 0.77},
        {24.0, 67.7, 29.60, 1.07},
        {23.2, 76.8, 29.38, 1.07},
        {47.4, 86.6, 29.35, 0.94},
        {31.5, 76.9, 29.63, 1.10},
        {10.6, 86.3, 29.56, 1.10},
        {11.2, 86.0, 29.48, 1.10},
        {73.3, 76.3, 29.40, 0.91},
        {75.4, 77.9, 29.28, 0.87},
        {96.6, 78.7, 29.29, 0.78},
        {107.4,86.8, 29.03, 0.82},
        {54.9, 70.9, 29.37, 0.95}
    });

    /**
     * Test of getIntercept method, of class Regression.
     */
    @Test
    public void testGetIntercept() {
        System.out.println("getIntercept");
        Regression instance = new Regression();

        double result = instance.getIntercept();
        assertEquals(0.0, result);
        
        instance.fit(tc1);
        assertEquals(-6.867487247726643, instance.getIntercept());
    }

    /**
     * Test of getCoef method, of class Regression.
     */
    @Test
    public void testGetCoef() {
        System.out.println("getCoef");
        Regression instance = new Regression();
        double[] expResult = null;
        double[] result = instance.getCoef();
        assertArrayEquals(expResult, result);
        
        instance.fit(tc1);
        expResult = new double[]{3.1478931026835206, -1.6561432690175215};
        assertArrayEquals(expResult, instance.getCoef());
    }

    /**
     * Test of fit method, of class Regression.
     */
    @Test
    public void testFit() {
        System.out.println("fit");
        
        Regression ins = new Regression();
        ins.fit(tc1);
        ins.fit(tc2);
    }

    /**
     * Test of predict method, of class Regression.
     */
    @Test
    public void testPredict() {
        System.out.println("predict");
        Regression ins = new Regression();
        double[] x = new double[]{68, 18};
        
        assertEquals(true, Double.isNaN(ins.predict(x)));
        
        ins.fit(tc1);
        assertEquals(177.37866489243737, ins.predict(x));
        
        ins.fit(tc2);
        x = new double[]{50, 76, 29.30};
        assertEquals(0.938434226221665, ins.predict(x));
    }

    /**
     * Test of hasSolution method, of class Regression.
     */
    @Test
    public void testHasSolution() {
        System.out.println("hasSolution");
        Regression instance = new Regression();
        boolean result = instance.hasSolution();
        
        assertEquals(false, result);
        
        instance.fit(tc1);
        assertEquals(true, instance.hasSolution());
    }
    
}
