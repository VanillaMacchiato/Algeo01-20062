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
 * @author rifqi
 */
public class DeterminantSolverTest {

    public DeterminantSolverTest() {
    }

//    /**
//     * Test of getEROMatrix method, of class DeterminantSolver.
//     */
//    @Test
//    public void testGetEROMatrix() {
//        System.out.println("getEROMatrix");
//        DeterminantSolver instance = new DeterminantSolver();
//        Matrix expResult = null;
//        Matrix result = instance.getEROMatrix();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of CofactorExpansion method, of class DeterminantSolver.
     */
    @Test
    public void testCofactorExpansion() {
        System.out.println("CofactorExpansion");
        DeterminantSolver instance = new DeterminantSolver();
        Matrix M = new Matrix(new double[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        });
        double expResult = 0.0;
        double result = instance.CofactorExpansion(M);
        assertEquals(expResult, result, 0.01);
        M = new Matrix(new double[][]{
            {0, 0, 1},
            {0, 2, 3},
            {2, 5, 6}
        });
        expResult = -4.0;
        result = instance.CofactorExpansion(M);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of ERO method, of class DeterminantSolver.
     */
    @Test
    public void testERO() {
        System.out.println("ERO");
        DeterminantSolver instance = new DeterminantSolver();
        Matrix M = new Matrix(new double[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        });
        double expResult = 0.0;
        double result = instance.ERO(M);
        assertEquals(expResult, result, 0.01);
        M = new Matrix(new double[][]{
            {0, 0, 1},
            {0, 2, 3},
            {2, 5, 6}
        });
        expResult = -4.0;
        result = instance.ERO(M);
        assertEquals(expResult, result, 0.01);
        // TODO review the generated test code and remove the default call to fail.
    }

}
