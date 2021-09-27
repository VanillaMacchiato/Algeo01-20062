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
    public String generateVarString(int num) {
        int n = num / 27;
        String res = Character.toString(((int) 'a' + (num % 27)));
        if (n > 0) {
            res += Integer.toString(n);
        }
        return res;
    }

    public String generateSolution(int[] states, Matrix result) {
        if (states == null) {
            return "No solution exist. The system is inconsistent.";
        }
        int cnt, i, j;
        double el;
        String res = "";
        for (i = 0; i < states.length; i++) {
            res += "x" + (i + 1) + " = ";
            if (states[i] == -1) {
                cnt = 0;
                for (j = i + 1; j <= states.length; j++) {
                    el = result.getElmt(i, j);
                    if (el != 0) {
                        if (cnt != 0) {
                            if (el > 0) {
                                res += " + ";
                            } else {
                                res += " - ";
                                el *= -1;
                            }
                        } else if (el == -1.0) {
                            res += "-";
                            el *= -1;
                        }
                        if (el != 1.0 || j == states.length) {
                            res += el;
                        }
                        if (j < states.length) {
                            res += generateVarString(states[j]);
                        }
                        cnt++;
                    }
                }
            } else {
                res += generateVarString(states[i]);
            }
            res += "\n";
        }
        return res;
    }

    /**
     * Test of backwardSubstitution method, of class SPLSolver.
     */
    @Test
    public void testBackwardSubstitution() {
        System.out.println("backwardSubstitution");
        Matrix result = new Matrix(0, 0);
        Matrix m = new Matrix(new double[][]{
            {1, -1, 0, 0, 1, 3},
            {1, 1, 0, -3, 0, 6},
            {2, -1, 0, 1, -1, 5},
            {-1, 2, 0, -2, -1, -1}
        });
        System.out.println("==== CASE 1 ====\nORIGIN");
        System.out.println(m.toString());
        m.toEchelonForm(false);
        System.out.println("ECHELON");
        System.out.println(m.toString());
        int[] states = SPLSolver.backwardSubstitution(m, result);
        System.out.println("SOLUTION");
        System.out.println(generateSolution(states, result));
        m.setData(new double[][]{
            {0, 1, 0, 0, 1, 0, 2},
            {0, 0, 0, 1, 1, 0, -1},
            {0, 1, 0, 0, 0, 1, 1}
        });
        System.out.println("==== CASE 2 ====\nORIGIN");
        System.out.println(m.toString());
        m.toEchelonForm(false);
        System.out.println("ECHELON");
        System.out.println(m.toString());
        states = SPLSolver.backwardSubstitution(m, result);
        System.out.println("SOLUTION");
        System.out.println(generateSolution(states, result));
        m.setData(new double[][]{
            {1, 1, -1, -1, 1},
            {2, 5, -7, -5, -2},
            {2, -1, 1, 3, 4},
            {5, 2, -4, 2, 6}
        });
        System.out.println("==== CASE 3 ====\nORIGIN");
        System.out.println(m.toString());
        m.toEchelonForm(false);
        System.out.println("ECHELON");
        System.out.println(m.toString());
        states = SPLSolver.backwardSubstitution(m, result);
        System.out.println("SOLUTION");
        System.out.println(generateSolution(states, result));

        // pepega
        assertEquals(true, false);
    }

}
