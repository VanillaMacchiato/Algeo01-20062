/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alingeo.matriks.solver;

import alingeo.matriks.Matrix;
//import alingeo.matriks.Util;
import alingeo.matriks.solver.SPLSolver.SolutionResult;
import alingeo.matriks.solver.SPLSolver.SolutionResult.SolutionType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author vitos
 */
public class SPLSolverTest {

    public SPLSolverTest() {
    }

    // 1.b
    double[][] tc1 = new double[][]{
        {1, -1, 0, 0, 1, 3},
        {1, 1, 0, -3, 0, 6},
        {2, -1, 0, 1, -1, 5},
        {-1, 2, 0, -2, -1, -1}
    };
    SolutionResult expectTC1 = new SolutionResult(
        new int[]{-1, -1, 0, -1, 1},
        new Matrix(
            new double[][]{
                {1, 0, 0, 0, 1, 3},
                {0, 1, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, -1},
                {0, 0, 0, 0, 0, 0}
            }
        )
    );

    // 1.c
    double[][] tc2 = new double[][]{
        {0, 1, 0, 0, 1, 0, 2},
        {0, 0, 0, 1, 1, 0, -1},
        {0, 1, 0, 0, 0, 1, 1}
    };
    SolutionResult expectTC2 = new SolutionResult(
        new int[]{0, -1, 1, -1, -1, 2},
        new Matrix(
            new double[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, -1, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, -1, -2},
                {-0.0, -0.0, -0.0, -0.0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0}
            }
        )
    );

    // 1.a
    double[][] tc3 = new double[][]{
        {1, 1, -1, -1, 1},
        {2, 5, -7, -5, -2},
        {2, -1, 1, 3, 4},
        {5, 2, -4, 2, 6}
    };

    double[][] tc4 = new double[][]{
        {2, 4, 6, 18},
        {4, 5, 6, 24},
        {3, 1, -2, 4}
    };
    SolutionResult expectTC4 = new SolutionResult(
        new Matrix(
            new double[][]{
                {4},
                {-2},
                {3}
            }
        )
    );

    // 3.b
    double[][] tc5 = new double[][]{
        {0, 0, 0, 0, 0, 0, 1, 1, 1, 13},
        {0, 0, 0, 1, 1, 1, 0, 0, 0, 15},
        {1, 1, 1, 0, 0, 0, 0, 0, 0, 8},
        {0, 0, 0.04289, 0, 0.04289, 0.75, 0.04289, 0.75, 0.61396, 14.79},
        {0, 0.25, 0.91421, 0.25, 0.91421, 0.25, 0.91421, 0.25, 0, 14.31},
        {0.61396, 0.75, 0.04289, 0.75, 0.04289, 0, 0.04289, 0, 0, 3.81},
        {0, 0, 1, 0, 0, 1, 0, 0, 1, 18},
        {0, 1, 0, 0, 1, 0, 0, 1, 0, 12},
        {1, 0, 0, 1, 0, 0, 1, 0, 0, 6},
        {0.04289, 0.75, 0.61396, 0, 0.04289, 0.75, 0, 0, 0.04289, 10.51},
        {0.91421, 0.25, 0, 0.25, 0.91421, 0.25, 0, 0.25, 0.91421, 16.13},
        {0.04289, 0, 0, 0.75, 0.04289, 0, 0.61396, 0.75, 0.04289, 7.04}
    };

    double[][] tc6 = new double[][]{
        {1, 1, 3},
        {1, 0, 5},
        {0, 1, 7},
        {2, 2, 6},
        {0.2, 0, 1},
        {0, 3, 21}
    };

    double[][] tc7 = new double[][]{
        {1, 1, 5},
        {5, 5, 25},
        {7, 7, 35},
        {1, 0, 3}
    };
    SolutionResult expectTC7 = new SolutionResult(
        new Matrix(
            new double[][]{
                {3},
                {2}
            }
        )
    );

    // 1.d Hilbert matrix, n = 6
    double[][] tc8 = {
        {1.0, 0.5, 0.3333333333333333, 0.25, 0.2, 0.16666666666666666, 1},
        {0.5, 0.3333333333333333, 0.25, 0.2, 0.16666666666666666, 0.14285714285714285, 0},
        {0.3333333333333333, 0.25, 0.2, 0.16666666666666666, 0.14285714285714285, 0.125, 0},
        {0.25, 0.2, 0.16666666666666666, 0.14285714285714285, 0.125, 0.1111111111111111, 0},
        {0.2, 0.16666666666666666, 0.14285714285714285, 0.125, 0.1111111111111111, 0.1, 0},
        {0.16666666666666666, 0.14285714285714285, 0.125, 0.1111111111111111, 0.1, 0.09090909090909091, 0}
    };
    SolutionResult expectTC8 = new SolutionResult(
        new Matrix(
            new double[][]{
                {36},
                {-630},
                {3360},
                {-7560},
                {7560},
                {-2772}
            }
        )
    );

    // 1.d Hilbert matrix, n = 10
    double[][] tc9 = {
        {1.0, 0.5, 0.3333333333333333, 0.25, 0.2, 0.16666666666666666, 0.14285714285714285, 0.125, 0.1111111111111111, 0.1, 1},
        {0.5, 0.3333333333333333, 0.25, 0.2, 0.16666666666666666, 0.14285714285714285, 0.125, 0.1111111111111111, 0.1, 0.09090909090909091, 0},
        {0.3333333333333333, 0.25, 0.2, 0.16666666666666666, 0.14285714285714285, 0.125, 0.1111111111111111, 0.1, 0.09090909090909091, 0.08333333333333333, 0},
        {0.25, 0.2, 0.16666666666666666, 0.14285714285714285, 0.125, 0.1111111111111111, 0.1, 0.09090909090909091, 0.08333333333333333, 0.07692307692307693, 0},
        {0.2, 0.16666666666666666, 0.14285714285714285, 0.125, 0.1111111111111111, 0.1, 0.09090909090909091, 0.08333333333333333, 0.07692307692307693, 0.07142857142857142, 0},
        {0.16666666666666666, 0.14285714285714285, 0.125, 0.1111111111111111, 0.1, 0.09090909090909091, 0.08333333333333333, 0.07692307692307693, 0.07142857142857142, 0.06666666666666667, 0},
        {0.14285714285714285, 0.125, 0.1111111111111111, 0.1, 0.09090909090909091, 0.08333333333333333, 0.07692307692307693, 0.07142857142857142, 0.06666666666666667, 0.0625, 0},
        {0.125, 0.1111111111111111, 0.1, 0.09090909090909091, 0.08333333333333333, 0.07692307692307693, 0.07142857142857142, 0.06666666666666667, 0.0625, 0.058823529411764705, 0},
        {0.1111111111111111, 0.1, 0.09090909090909091, 0.08333333333333333, 0.07692307692307693, 0.07142857142857142, 0.06666666666666667, 0.0625, 0.058823529411764705, 0.05555555555555555, 0},
        {0.1, 0.09090909090909091, 0.08333333333333333, 0.07692307692307693, 0.07142857142857142, 0.06666666666666667, 0.0625, 0.058823529411764705, 0.05555555555555555, 0.05263157894736842, 0}
    };
    SolutionResult expectTC9 = new SolutionResult(
        new Matrix(
            new double[][]{
                {100},
                {-4950},
                {79200},
                {-600600},
                {2522520},
                {-6306300},
                {9609600},
                {-8751600},
                {4375800},
                {-923780}
            }
        )
    );

    // 2.a Augmented
    double[][] tc10 = {
        {1, -1, 2, -1, -1},
        {2, 1, -2, -2, -2},
        {-1, 2, -4, 1, 1},
        {3, 0, 0, -3, -3}
    };
    SolutionResult expectTC10 = new SolutionResult(
        new int[]{-1, -1, 0, 1},
        new Matrix(
            new double[][]{
                {1, 0, 0, 1, -1},
                {0, 1, 2, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
            }
        )
    );

    // 2.b. Augmented
    double[][] tc11 = {
        {2, 0, 8, 0, 8},
        {0, 1, 0, 4, 6},
        {-4, 0, 6, 0, 6},
        {0, -2, 0, 3, -1},
        {2, 0, -4, 0, -4},
        {0, 1, 0, -2, 0}
    };
    SolutionResult expectTC11 = new SolutionResult(
        new Matrix(
            new double[][]{
                {0},
                {2},
                {1},
                {1}
            }
        )
    );

    // 3.a. SPL
    double[][] tc12 = {
        {8, 1, 3, 2, 0},
        {2, 9, -1, -2, 1},
        {1, 3, 2, -1, 2},
        {1, 0, 6, 4, 3}
    };
    SolutionResult expectTC12 = new SolutionResult(
        new Matrix(
            new double[][]{
                {-0.224324324324324325},
                {0.1824324324324324326},
                {0.7094594594594594596},
                {-0.25810810810810810809}
            }
        )
    );

    // 5. Sistem Reaktor
    double[][] tc13 = {
        {-120, 60, 0, -1300},
        {40, -80, 0, 0},
        {80, 20, -150, -200}
    };
    SolutionResult expectTC13 = new SolutionResult(
        new Matrix(
            new double[][]{
                {14.444444444444444444},
                {7.222222222222222222},
                {10}
            }
        )
    );

    // 4. Arus listrik
    double[][] tc14 = {
        {40, 0, 0, -20, 0, 0, 10},
        {-20, 0, 0, 40, -20, 0, 0},
        {0, 0, 0, -20, 40, 0, 10},
        {-1, 1, 0, 1, 0, 0, 0},
        {0, 0, 1, -1, 1, 0, 0},
        {0, 0, 0, -1, 0, 1, 0}
    };
    SolutionResult expectTC14 = new SolutionResult(
        new Matrix(
            new double[][]{
                {0.5},
                {0},
                {0},
                {0.5},
                {0.5},
                {0.5}
            }
        )
    );

    public void printTestSPLCase(int caseNo, Matrix m, SolutionResult res) {
        System.out.println("==== CASE " + caseNo + " ====");
        /*System.out.println("ORIGIN");
        System.out.println(m);
        Matrix r = res.getIntermediate();
        if (r != null) {
            System.out.println("INTERMEDIATE");
            System.out.println(r.toString(Util.Formatting.LONG));
        }
        System.out.println("SOLUTION");
        System.out.println(res);*/
    }

    /**
     * Test of backwardSubstitution method, of class SPLSolver.
     */
    @Test
    public void testBackwardSubstitution() {
        System.out.println("backwardSubstitution");
        Matrix m = new Matrix(tc1);
        m.toEchelonForm(false);
        SolutionResult result = SPLSolver.backwardSubstitution(m);
        printTestSPLCase(1, m, result);
        assertArrayEquals(expectTC1.getStates(), result.getStates());
        assertArrayEquals(expectTC1.getResult().getData(), result.getResult().getData());

        m.setData(tc2);
        m.toEchelonForm(false);
        result = SPLSolver.backwardSubstitution(m);
        printTestSPLCase(2, m, result);
        assertArrayEquals(expectTC2.getStates(), result.getStates());
        assertArrayEquals(expectTC2.getResult().getData(), result.getResult().getData());

        m.setData(tc3);
        m.toEchelonForm(false);
        result = SPLSolver.backwardSubstitution(m);
        printTestSPLCase(3, m, result);
        assertEquals(SolutionType.INCONSISTENT, result.getType());

        m.setData(tc4);
        m.toEchelonForm(false);
        result = SPLSolver.backwardSubstitution(m);
        printTestSPLCase(4, m, result);
        assertArrayEquals(expectTC4.getStates(), result.getStates());
        assertArrayEquals(expectTC4.getResult().getData(), result.getResult().getData());

        m.setData(tc5);
        m.toEchelonForm(false);
        result = SPLSolver.backwardSubstitution(m);
        printTestSPLCase(5, m, result);
        assertEquals(SolutionType.INCONSISTENT, result.getType());

        m.setData(tc6);
        m.toEchelonForm(false);
        result = SPLSolver.backwardSubstitution(m);
        printTestSPLCase(6, m, result);
        assertEquals(SolutionType.INCONSISTENT, result.getType());

        m.setData(tc7);
        m.toEchelonForm(false);
        result = SPLSolver.backwardSubstitution(m);
        printTestSPLCase(7, m, result);
        assertArrayEquals(expectTC7.getStates(), result.getStates());
        assertArrayEquals(expectTC7.getResult().getData(), result.getResult().getData());

        m.setData(tc8);
        m.toEchelonForm(false);
        result = SPLSolver.backwardSubstitution(m);
        printTestSPLCase(8, m, result);
        assertArrayEquals(expectTC8.getStates(), result.getStates());
        assertArrayEquals(expectTC8.getResult().getData(4), result.getResult().getData(4));

        m.setData(tc9);
        m.toEchelonForm(false);
        result = SPLSolver.backwardSubstitution(m);
        printTestSPLCase(9, m, result);
        assertArrayEquals(expectTC9.getStates(), result.getStates());
        assertArrayEquals(
            Matrix.transpose(expectTC9.getResult()).getRow(0),
            Matrix.transpose(result.getResult()).getRow(0),
            1000
        );

        m.setData(tc10);
        m.toEchelonForm(false);
        result = SPLSolver.backwardSubstitution(m);
        printTestSPLCase(10, m, result);
        assertArrayEquals(expectTC10.getStates(), result.getStates());
        assertArrayEquals(expectTC10.getResult().getData(), result.getResult().getData());

        m.setData(tc11);
        m.toEchelonForm(false);
        result = SPLSolver.backwardSubstitution(m);
        printTestSPLCase(11, m, result);
        assertArrayEquals(expectTC11.getStates(), result.getStates());
        assertArrayEquals(expectTC11.getResult().getData(), result.getResult().getData());

        m.setData(tc12);
        m.toEchelonForm(false);
        result = SPLSolver.backwardSubstitution(m);
        printTestSPLCase(12, m, result);
        assertArrayEquals(expectTC12.getStates(), result.getStates());
        assertArrayEquals(expectTC12.getResult().getData(8), result.getResult().getData(8));

        m.setData(tc13);
        m.toEchelonForm(false);
        result = SPLSolver.backwardSubstitution(m);
        printTestSPLCase(13, m, result);
        assertArrayEquals(expectTC13.getStates(), result.getStates());
        assertArrayEquals(expectTC13.getResult().getData(8), result.getResult().getData(8));

        m.setData(tc14);
        m.toEchelonForm(false);
        result = SPLSolver.backwardSubstitution(m);
        printTestSPLCase(12, m, result);
        assertArrayEquals(expectTC14.getStates(), result.getStates());
        assertArrayEquals(expectTC14.getResult().getData(8), result.getResult().getData(8));
    }

    /**
     * Test of gaussMethod method, of class SPLSolver.
     */
    @Test
    public void testGaussMethod() {
        System.out.println("gaussMethod");
        Matrix m = new Matrix(tc1);
        SolutionResult result = SPLSolver.gaussMethod(m);
        printTestSPLCase(1, m, result);
        assertArrayEquals(expectTC1.getStates(), result.getStates());
        assertArrayEquals(expectTC1.getResult().getData(), result.getResult().getData());

        m.setData(tc2);
        result = SPLSolver.gaussMethod(m);
        printTestSPLCase(2, m, result);
        assertArrayEquals(expectTC2.getStates(), result.getStates());
        assertArrayEquals(expectTC2.getResult().getData(), result.getResult().getData());

        m.setData(tc3);
        result = SPLSolver.gaussMethod(m);
        printTestSPLCase(3, m, result);
        assertEquals(SolutionType.INCONSISTENT, result.getType());

        m.setData(tc4);
        result = SPLSolver.gaussMethod(m);
        printTestSPLCase(4, m, result);
        assertArrayEquals(expectTC4.getStates(), result.getStates());
        assertArrayEquals(expectTC4.getResult().getData(), result.getResult().getData());

        m.setData(tc5);
        result = SPLSolver.gaussMethod(m);
        printTestSPLCase(5, m, result);
        assertEquals(SolutionType.INCONSISTENT, result.getType());

        m.setData(tc6);
        result = SPLSolver.gaussMethod(m);
        printTestSPLCase(6, m, result);
        assertEquals(SolutionType.INCONSISTENT, result.getType());

        m.setData(tc7);
        result = SPLSolver.gaussMethod(m);
        printTestSPLCase(7, m, result);
        assertArrayEquals(expectTC7.getStates(), result.getStates());
        assertArrayEquals(expectTC7.getResult().getData(), result.getResult().getData());

        m.setData(tc8);
        result = SPLSolver.gaussMethod(m);
        printTestSPLCase(8, m, result);
        assertArrayEquals(expectTC8.getStates(), result.getStates());
        assertArrayEquals(expectTC8.getResult().getData(4), result.getResult().getData(4));

        m.setData(tc9);
        result = SPLSolver.gaussMethod(m);
        printTestSPLCase(9, m, result);
        assertArrayEquals(expectTC9.getStates(), result.getStates());
        assertArrayEquals(
            Matrix.transpose(expectTC9.getResult()).getRow(0),
            Matrix.transpose(result.getResult()).getRow(0),
            1000
        );

        m.setData(tc10);
        result = SPLSolver.gaussMethod(m);
        printTestSPLCase(10, m, result);
        assertArrayEquals(expectTC10.getStates(), result.getStates());
        assertArrayEquals(expectTC10.getResult().getData(), result.getResult().getData());

        m.setData(tc11);
        result = SPLSolver.gaussMethod(m);
        printTestSPLCase(11, m, result);
        assertArrayEquals(expectTC11.getStates(), result.getStates());
        assertArrayEquals(expectTC11.getResult().getData(), result.getResult().getData());

        m.setData(tc12);
        result = SPLSolver.gaussMethod(m);
        printTestSPLCase(12, m, result);
        assertArrayEquals(expectTC12.getStates(), result.getStates());
        assertArrayEquals(expectTC12.getResult().getData(8), result.getResult().getData(8));

        m.setData(tc13);
        result = SPLSolver.gaussMethod(m);
        printTestSPLCase(13, m, result);
        assertArrayEquals(expectTC13.getStates(), result.getStates());
        assertArrayEquals(expectTC13.getResult().getData(8), result.getResult().getData(8));

        m.setData(tc14);
        result = SPLSolver.gaussMethod(m);
        printTestSPLCase(14, m, result);
        assertArrayEquals(expectTC14.getStates(), result.getStates());
        assertArrayEquals(expectTC14.getResult().getData(8), result.getResult().getData(8));
    }

    /**
     * Test of gaussJordanMethod method, of class SPLSolver.
     */
    @Test
    public void testGaussJordanMethod() {
        System.out.println("gaussJordanMethod");
        Matrix m = new Matrix(tc1);
        SolutionResult result = SPLSolver.gaussJordanMethod(m);
        printTestSPLCase(1, m, result);
        assertArrayEquals(expectTC1.getStates(), result.getStates());
        assertArrayEquals(expectTC1.getResult().getData(), result.getResult().getData());

        m.setData(tc2);
        result = SPLSolver.gaussJordanMethod(m);
        printTestSPLCase(2, m, result);
        assertArrayEquals(expectTC2.getStates(), result.getStates());
        assertArrayEquals(expectTC2.getResult().getData(), result.getResult().getData());

        m.setData(tc3);
        result = SPLSolver.gaussJordanMethod(m);
        printTestSPLCase(3, m, result);
        assertEquals(SolutionType.INCONSISTENT, result.getType());

        m.setData(tc4);
        result = SPLSolver.gaussJordanMethod(m);
        printTestSPLCase(4, m, result);
        assertArrayEquals(expectTC4.getStates(), result.getStates());
        assertArrayEquals(expectTC4.getResult().getData(), result.getResult().getData());

        m.setData(tc5);
        result = SPLSolver.gaussJordanMethod(m);
        printTestSPLCase(5, m, result);
        assertEquals(SolutionType.INCONSISTENT, result.getType());

        m.setData(tc6);
        result = SPLSolver.gaussJordanMethod(m);
        printTestSPLCase(6, m, result);
        assertEquals(SolutionType.INCONSISTENT, result.getType());

        m.setData(tc7);
        result = SPLSolver.gaussJordanMethod(m);
        printTestSPLCase(7, m, result);
        assertArrayEquals(expectTC7.getStates(), result.getStates());
        assertArrayEquals(expectTC7.getResult().getData(), result.getResult().getData());

        m.setData(tc8);
        result = SPLSolver.gaussJordanMethod(m);
        printTestSPLCase(8, m, result);
        assertArrayEquals(expectTC8.getStates(), result.getStates());
        assertArrayEquals(expectTC8.getResult().getData(4), result.getResult().getData(4));

        m.setData(tc9);
        result = SPLSolver.gaussJordanMethod(m);
        printTestSPLCase(9, m, result);
        assertArrayEquals(expectTC9.getStates(), result.getStates());
        assertArrayEquals(
            Matrix.transpose(expectTC9.getResult()).getRow(0),
            Matrix.transpose(result.getResult()).getRow(0),
            1000
        );

        m.setData(tc10);
        result = SPLSolver.gaussJordanMethod(m);
        printTestSPLCase(10, m, result);
        assertArrayEquals(expectTC10.getStates(), result.getStates());
        assertArrayEquals(expectTC10.getResult().getData(), result.getResult().getData());

        m.setData(tc11);
        result = SPLSolver.gaussJordanMethod(m);
        printTestSPLCase(11, m, result);
        assertArrayEquals(expectTC11.getStates(), result.getStates());
        assertArrayEquals(expectTC11.getResult().getData(), result.getResult().getData());

        m.setData(tc12);
        result = SPLSolver.gaussJordanMethod(m);
        printTestSPLCase(12, m, result);
        assertArrayEquals(expectTC12.getStates(), result.getStates());
        assertArrayEquals(expectTC12.getResult().getData(8), result.getResult().getData(8));

        m.setData(tc13);
        result = SPLSolver.gaussJordanMethod(m);
        printTestSPLCase(13, m, result);
        assertArrayEquals(expectTC13.getStates(), result.getStates());
        assertArrayEquals(expectTC13.getResult().getData(8), result.getResult().getData(8));

        m.setData(tc14);
        result = SPLSolver.gaussJordanMethod(m);
        printTestSPLCase(14, m, result);
        assertArrayEquals(expectTC14.getStates(), result.getStates());
        assertArrayEquals(expectTC14.getResult().getData(8), result.getResult().getData(8));
    }

    /**
     * Test of SolutionResult.generateVarString method, of class SPLSolver.
     */
    @Test
    public void testGenerateVarString() {
        System.out.println("SolutionResult.generateVarString");
        assertEquals("a", SolutionResult.generateVarString(0));
        assertEquals("b", SolutionResult.generateVarString(1));
        assertEquals("z", SolutionResult.generateVarString(25));
        assertEquals("a1", SolutionResult.generateVarString(26));
        assertEquals("b1", SolutionResult.generateVarString(27));
        assertEquals("z1", SolutionResult.generateVarString(51));
        assertEquals("a2", SolutionResult.generateVarString(52));
        assertEquals("b2", SolutionResult.generateVarString(53));
        assertEquals("z2", SolutionResult.generateVarString(77));
        assertEquals("a3", SolutionResult.generateVarString(78));
        assertEquals("b3", SolutionResult.generateVarString(79));
    }

    /**
     * Test of generateSolution method, of class SPLSolver.
     */
    @Test
    public void testGenerateSolution() {
        System.out.println("generateSolution");
        assertEquals(
            "SPL tidak dapat diselesaikan oleh metode ini.\nAlasan: ",
            (new SolutionResult("")).toString()
        );
        assertEquals(
            "Solusi tidak ada. SPL tidak konsisten.",
            (new SolutionResult()).toString()
        );
        assertEquals(
            "x1 = b + 3\n"
            + "x2 = 2b\n"
            + "x3 = a\n"
            + "x4 = b - 1\n"
            + "x5 = b\n",
            expectTC1.toString()
        );
        assertEquals(
            "x1 = a\n"
            + "x2 = -c + 1\n"
            + "x3 = b\n"
            + "x4 = -c - 2\n"
            + "x5 = c + 1\n"
            + "x6 = c\n",
            expectTC2.toString()
        );
        assertEquals(
            "x1 = 4\n"
            + "x2 = -2\n"
            + "x3 = 3\n",
            expectTC4.toString()
        );
        assertEquals(
            "x1 = 3\n"
            + "x2 = 2\n",
            expectTC7.toString()
        );
        assertEquals(
            "x1 = 5\n"
            + "x2 = -10\n"
            + "x3 = 1.71\n",
            new SolutionResult(new Matrix(
                new double[][]{
                    {5},
                    {-10},
                    {1.71}
                }
            )).toString()
        );
    }

    String notSquareReason
        = "SPL tidak dapat diselesaikan oleh metode ini.\n"
        + "Alasan: Matriks koefisien bukan persegi.";

    String doesNotHaveInverseReason
        = "SPL tidak dapat diselesaikan oleh metode ini.\n"
        + "Alasan: Invers/balikan tidak ditemukan.";

    String detZeroReason
        = "SPL tidak dapat diselesaikan oleh metode ini.\n"
        + "Alasan: Determinan matriks koefisien = 0.";

    /**
     * Test of inverseMethod method, of class SPLSolver.
     */
    @Test
    public void testInverseMethod() {
        System.out.println("inverseMethod");
        Matrix m = new Matrix(tc1);
        SolutionResult result = SPLSolver.inverseMethod(m);
        assertEquals(
            SolutionType.NOT_SUPPORTED,
            result.getType()
        );
        assertEquals(
            notSquareReason,
            result.toString()
        );

        m.setData(tc2);
        result = SPLSolver.inverseMethod(m);
        assertEquals(
            SolutionType.NOT_SUPPORTED,
            result.getType()
        );
        assertEquals(
            notSquareReason,
            result.toString()
        );

        m.setData(tc3);
        result = SPLSolver.inverseMethod(m);
        assertEquals(
            SolutionType.NOT_SUPPORTED,
            result.getType()
        );
        assertEquals(
            doesNotHaveInverseReason,
            result.toString()
        );

        m.setData(tc4);
        result = SPLSolver.inverseMethod(m);
        assertArrayEquals(expectTC4.getStates(), result.getStates());
        assertArrayEquals(expectTC4.getResult().getData(), result.getResult().getData(4));

        m.setData(tc5);
        result = SPLSolver.inverseMethod(m);
        assertEquals(
            SolutionType.NOT_SUPPORTED,
            result.getType()
        );
        assertEquals(
            notSquareReason,
            result.toString()
        );

        m.setData(tc6);
        result = SPLSolver.inverseMethod(m);
        assertEquals(
            SolutionType.NOT_SUPPORTED,
            result.getType()
        );
        assertEquals(
            notSquareReason,
            result.toString()
        );

        m.setData(tc7);
        result = SPLSolver.inverseMethod(m);
        assertEquals(
            SolutionType.NOT_SUPPORTED,
            result.getType()
        );
        assertEquals(
            notSquareReason,
            result.toString()
        );

        m.setData(tc8);
        result = SPLSolver.inverseMethod(m);
        assertArrayEquals(expectTC8.getStates(), result.getStates());
        assertArrayEquals(expectTC8.getResult().getData(4), result.getResult().getData(4));

        // Hilbert n=10 loss accuracy up to 4
        m.setData(tc9);
        result = SPLSolver.inverseMethod(m);
        assertArrayEquals(expectTC9.getStates(), result.getStates());
        assertArrayEquals(
            Matrix.transpose(expectTC9.getResult()).getRow(0),
            Matrix.transpose(result.getResult()).getRow(0),
            1000
        );

        m.setData(tc10);
        result = SPLSolver.inverseMethod(m);
        assertEquals(
            SolutionType.NOT_SUPPORTED,
            result.getType()
        );
        assertEquals(
            doesNotHaveInverseReason,
            result.toString()
        );

        m.setData(tc11);
        result = SPLSolver.inverseMethod(m);
        assertEquals(
            SolutionType.NOT_SUPPORTED,
            result.getType()
        );
        assertEquals(
            notSquareReason,
            result.toString()
        );

        m.setData(tc12);
        result = SPLSolver.inverseMethod(m);
        assertArrayEquals(expectTC12.getStates(), result.getStates());
        assertArrayEquals(expectTC12.getResult().getData(7), result.getResult().getData(7));

        m.setData(tc13);
        result = SPLSolver.inverseMethod(m);
        assertArrayEquals(expectTC13.getStates(), result.getStates());
        assertArrayEquals(expectTC13.getResult().getData(7), result.getResult().getData(7));

        m.setData(tc14);
        result = SPLSolver.inverseMethod(m);
        assertArrayEquals(expectTC14.getStates(), result.getStates());
        assertArrayEquals(expectTC14.getResult().getData(7), result.getResult().getData(7));
    }

    /**
     * Test of crammerMethod method, of class SPLSolver.
     */
    @Test
    public void testCrammerMethod() {
        System.out.println("crammerMethod");
        Matrix m = new Matrix(tc1);
        SolutionResult result = SPLSolver.crammerMethod(m);
        assertEquals(
            SolutionType.NOT_SUPPORTED,
            result.getType()
        );
        assertEquals(
            notSquareReason,
            result.toString()
        );

        m.setData(tc2);
        result = SPLSolver.crammerMethod(m);
        assertEquals(
            SolutionType.NOT_SUPPORTED,
            result.getType()
        );
        assertEquals(
            notSquareReason,
            result.toString()
        );

        m.setData(tc3);
        result = SPLSolver.crammerMethod(m);
        assertEquals(
            SolutionType.NOT_SUPPORTED,
            result.getType()
        );
        assertEquals(
            detZeroReason,
            result.toString()
        );

        m.setData(tc4);
        result = SPLSolver.crammerMethod(m);
        assertArrayEquals(expectTC4.getStates(), result.getStates());
        assertArrayEquals(expectTC4.getResult().getData(), result.getResult().getData(4));

        m.setData(tc5);
        result = SPLSolver.crammerMethod(m);
        assertEquals(
            SolutionType.NOT_SUPPORTED,
            result.getType()
        );
        assertEquals(
            notSquareReason,
            result.toString()
        );

        m.setData(tc6);
        result = SPLSolver.crammerMethod(m);
        assertEquals(
            SolutionType.NOT_SUPPORTED,
            result.getType()
        );
        assertEquals(
            notSquareReason,
            result.toString()
        );

        m.setData(tc7);
        result = SPLSolver.crammerMethod(m);
        assertEquals(
            SolutionType.NOT_SUPPORTED,
            result.getType()
        );
        assertEquals(
            notSquareReason,
            result.toString()
        );

        m.setData(tc8);
        result = SPLSolver.crammerMethod(m);
        assertArrayEquals(expectTC8.getStates(), result.getStates());
        assertArrayEquals(expectTC8.getResult().getData(4), result.getResult().getData(4));

        // Hilbert n=10 loss accuracy up to 4
        m.setData(tc9);
        result = SPLSolver.crammerMethod(m);
        assertArrayEquals(expectTC9.getStates(), result.getStates());
        assertArrayEquals(
            Matrix.transpose(expectTC9.getResult()).getRow(0),
            Matrix.transpose(result.getResult()).getRow(0),
            1000
        );

        m.setData(tc10);
        result = SPLSolver.crammerMethod(m);
        assertEquals(
            SolutionType.NOT_SUPPORTED,
            result.getType()
        );
        assertEquals(
            detZeroReason,
            result.toString()
        );

        m.setData(tc11);
        result = SPLSolver.crammerMethod(m);
        assertEquals(
            SolutionType.NOT_SUPPORTED,
            result.getType()
        );
        assertEquals(
            notSquareReason,
            result.toString()
        );

        m.setData(tc12);
        result = SPLSolver.crammerMethod(m);
        assertArrayEquals(expectTC12.getStates(), result.getStates());
        assertArrayEquals(expectTC12.getResult().getData(7), result.getResult().getData(7));

        m.setData(tc13);
        result = SPLSolver.crammerMethod(m);
        assertArrayEquals(expectTC13.getStates(), result.getStates());
        assertArrayEquals(expectTC13.getResult().getData(7), result.getResult().getData(7));

        m.setData(tc14);
        result = SPLSolver.crammerMethod(m);
        assertArrayEquals(expectTC14.getStates(), result.getStates());
        assertArrayEquals(expectTC14.getResult().getData(7), result.getResult().getData(7));
    }
}
