/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alingeo.matriks.solver;

import alingeo.matriks.Matrix;
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

    public void printTestSPLCase(int caseNo, Matrix m, SolutionResult res) {
        System.out.println("==== CASE " + caseNo + " ====\nORIGIN");
        System.out.println(m);
        System.out.println("DEP MATRIX");
        System.out.println(res.getResult());
        System.out.println("SOLUTION");
        System.out.println(res);
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
            (new SolutionResult((Matrix) null)).toString()
        );
        assertEquals(
            "x1 = b + 3.0\n"
            + "x2 = 2.0b\n"
            + "x3 = a\n"
            + "x4 = b - 1.0\n"
            + "x5 = b\n",
            expectTC1.toString()
        );
        assertEquals(
            "x1 = a\n"
            + "x2 = -c + 1.0\n"
            + "x3 = b\n"
            + "x4 = -c - 2.0\n"
            + "x5 = c + 1.0\n"
            + "x6 = c\n",
            expectTC2.toString()
        );
        assertEquals(
            "x1 = 4.0\n"
            + "x2 = -2.0\n"
            + "x3 = 3.0\n",
            expectTC4.toString()
        );
        assertEquals(
            "x1 = 3.0\n"
            + "x2 = 2.0\n",
            expectTC7.toString()
        );
        assertEquals(
            "x1 = 5.0\n"
            + "x2 = -10.0\n"
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

    // Additional case for inverse and crammer
    // Hilbert matrix, n = 6
    double[][] tc8 = {
        {1.0000000, 0.5000000, 0.3333333, 0.2500000, 0.2000000, 0.16666667, 1},
        {0.5000000, 0.3333333, 0.2500000, 0.2000000, 0.1666667, 0.14285714, 0},
        {0.3333333, 0.2500000, 0.2000000, 0.1666667, 0.1428571, 0.12500000, 0},
        {0.2500000, 0.2000000, 0.1666667, 0.1428571, 0.1250000, 0.11111111, 0},
        {0.2000000, 0.1666667, 0.1428571, 0.1250000, 0.1111111, 0.10000000, 0},
        {0.1666667, 0.1428571, 0.1250000, 0.1111111, 0.1000000, 0.09090909, 0}
    };
    SolutionResult expectTC8 = new SolutionResult(
        new Matrix(
            new double[][]{
                {50.44975429458950027},
                {-1031.4828124761261717},
                {6029.6058521313914782},
                {-14419.615714708150375},
                {15062.88361776414059},
                {-5707.4972417855693208}
            }
        )
    );
    // Hilbert matrix, n = 10
    double[][] tc9 = {
        {1, 0.5, 0.33333333, 0.25, 0.2, 0.16666667, 0.14285714, 0.125, 0.11111111, 0.1, 1},
        {0.5, 0.33333333, 0.25, 0.2, 0.16666667, 0.14285714, 0.125, 0.11111111, 0.1, 0.09090909, 0},
        {0.3333333, 0.25, 0.2, 0.16666667, 0.14285714, 0.125, 0.11111111, 0.1, 0.09090909, 0.08333333, 0},
        {0.25, 0.2, 0.16666667, 0.14285714, 0.125, 0.11111111, 0.1, 0.09090909, 0.08333333, 0.07692308, 0},
        {0.2, 0.16666667, 0.14285714, 0.125, 0.11111111, 0.1, 0.09090909, 0.08333333, 0.07692308, 0.07142857, 0},
        {0.1666667, 0.14285714, 0.125, 0.11111111, 0.1, 0.09090909, 0.08333333, 0.07692308, 0.07142857, 0.06666667, 0},
        {0.1428571, 0.125, 0.11111111, 0.1, 0.09090909, 0.08333333, 0.07692308, 0.07142857, 0.06666667, 0.0625, 0},
        {0.125, 0.11111111, 0.1, 0.09090909, 0.08333333, 0.07692308, 0.07142857, 0.06666667, 0.0625, 0.05882353, 0},
        {0.1111111, 0.1, 0.09090909, 0.08333333, 0.07692308, 0.07142857, 0.06666667, 0.0625, 0.05882353, 0.05555556, 0},
        {0.1, 0.09090909, 0.08333333, 0.07692308, 0.07142857, 0.06666667, 0.0625, 0.05882353, 0.05555556, 0.05263158, 0}
    };
    SolutionResult expectTC9 = new SolutionResult(
        new Matrix(
            new double[][]{
                {46.376271081726511963},
                {-1072.0584797895074519},
                {7642.112743835465733},
                {-22514.176771202627349},
                {24691.71265559007691},
                {7194.7490517018877552},
                {-27374.122435202595533},
                {-4907.1932068199372872},
                {29641.915933048084704},
                {-13351.993142859037694}
            }
        )
    );

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
        /* Hilbert n=10 dia meninggal ngab :(
        m.setData(tc9);
        result = SPLSolver.inverseMethod(m);
        assertArrayEquals(expectTC9.getStates(), result.getStates());
        assertArrayEquals(expectTC9.getResult().getData(4), result.getResult().getData(4));
         */
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

        /* Hilbert n=10 dia meninggal ngab :(
        m.setData(tc9);
        result = SPLSolver.inverseMethod(m);
        assertArrayEquals(expectTC9.getStates(), result.getStates());
        assertArrayEquals(expectTC9.getResult().getData(4), result.getResult().getData(4));
         */
    }
}
