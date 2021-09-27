/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alingeo.matriks.solver;

import alingeo.matriks.Matrix;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Windows 7
 */
public class InversSolverTest {
    
    public InversSolverTest() {
    }

    /**
     * Test of GaussJordanMethod method, of class InversSolver.
     */
    /*@Test
    public void testGaussJordanMethod() {
        System.out.println("GaussJordanMethod");
        Matrix m = null;
        Matrix expResult = null;
        Matrix result = InversSolver.GaussJordanMethod(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of CofactorMatrix method, of class InversSolver.
     */
    @Test
    public void testCofactorMatrix() {
        System.out.println("CofactorMatrix");
        Matrix m = null;
        Matrix expResult = null;
        Matrix result = InversSolver.CofactorMatrix(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AdjointMethod method, of class InversSolver.
     */
    @Test
    public void testAdjointMethod() {
        System.out.println("AdjointMethod");
        Matrix m = null;
        Matrix expResult = null;
        Matrix result = InversSolver.AdjointMethod(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
