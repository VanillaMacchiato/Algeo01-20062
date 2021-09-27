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
 * @author vitos
 */
public class SPLSolverTest {
    
    public SPLSolverTest() {
    }

    /**
     * Test of gaussMethod method, of class SPLSolver.
     */
//    @Test
//    public void testGaussMethod() {
//        System.out.println("gaussMethod");
//        Matrix m = null;
//        Matrix expResult = null;
//        Matrix result = SPLSolver.gaussMethod(m);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of gaussJordanMethod method, of class SPLSolver.
//     */
//    @Test
//    public void testGaussJordanMethod() {
//        System.out.println("gaussJordanMethod");
//        Matrix m = null;
//        Matrix expResult = null;
//        Matrix result = SPLSolver.gaussJordanMethod(m);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of backwardSubstitution method, of class SPLSolver.
     */
    @Test
    public void testBackwardSubstitution() {
        System.out.println("backwardSubstitution");
        Matrix result = new Matrix(1, 1);
        Matrix m = new Matrix(new double[][]{
            {0, 1, 0, 0, 1, 0, 2},
            {0, 0, 0, 1, 1, 0, -1},
            {0, 1, 0, 0, 0, 1, 1}
        });
        m.toEchelonForm(false);
//        System.out.println(m.toString());
        
        SPLSolver.backwardSubstitution(m, result);

        // pepega
        assertEquals(true, false);
    }
    
}
