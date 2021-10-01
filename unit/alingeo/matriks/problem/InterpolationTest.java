/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alingeo.matriks.problem;

import alingeo.matriks.Matrix;
import alingeo.matriks.Util;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Windows 7
 */
public class InterpolationTest {

    public static final double[][] DATA_TABLE_TC1 = new double[][]{
        {0.1, 0.003},
        {0.3, 0.067},
        {0.5, 0.148},
        {0.7, 0.248},
        {0.9, 0.370},
        {1.1, 0.518},
        {1.3, 0.697}
    };

    public static final double[][] DATA_COVID_TC2 = new double[][]{
        {6.567, 12624},
        {7, 21807},
        {7.258, 38391},
        {7.451, 54517},
        {7.548, 51952},
        {7.839, 28228},
        {8.161, 35764},
        {8.484, 20813},
        {8.709, 12408},
        {9, 10534}
    };

    public static final double dateToDouble(String s) {
        // Assumption: year was 2021. Format: DD/MM/YYYY
        // 31 28 31 30 31 30 31
        // 31 30 31 30 31
        int d = Integer.valueOf(s.substring(0, 2));
        int m = Integer.valueOf(s.substring(3, 5));
        int daysOfMonth = (m == 2 ? 28
            : (30 + ((m + (m > 7 ? 1 : 0)) % 2)));
        return m + ((double) d / daysOfMonth);
    }

    public static final Matrix generateFunTC(int n) {
        double h = 2.0 / n;
        Matrix points = new Matrix(n + 1, 2);
        double x = 0;
        for (int i = 0; i <= n; i++) {
            points.setElmt(i, 0, x);
            points.setElmt(i, 1,
                (x * x + Math.sqrt(x))
                / (Math.pow(Math.E, x) + x)
            );
            x += h;
        }
        return points;
    }

    public InterpolationTest() {
    }

    /**
     * Test of evaluate method, of class Interpolation.
     */
    @Test
    public void testEvaluate() {
        System.out.println("evaluate");
        // Table
        Matrix points = new Matrix(DATA_TABLE_TC1);
        Interpolation ins = new Interpolation(points);
        ins.fit();
        assertEquals(0.003, ins.evaluate(0.1), Util.EPSILON_LARGE);
        assertEquals(0.032961, ins.evaluate(0.2), Util.EPSILON_LARGE);
        assertEquals(0.171119, ins.evaluate(0.55), Util.EPSILON_LARGE);
        assertEquals(0.337236, ins.evaluate(0.85), Util.EPSILON_LARGE);
        assertEquals(0.677542, ins.evaluate(1.28), Util.EPSILON_LARGE);
        assertEquals(0.697, ins.evaluate(1.3), Util.EPSILON_LARGE);

        // Covid
        points.setData(DATA_COVID_TC2);
        ins = new Interpolation(points);
        ins.fit();
        assertEquals(12624, ins.evaluate(6.567), 0.1);
        assertEquals(21807, ins.evaluate(7), 0.1);
        assertEquals(53537.7109375, ins.evaluate(7.516), Util.EPSILON_LARGE);
        assertEquals(36295.25390625, ins.evaluate(8.323), Util.EPSILON_LARGE);
        assertEquals(-667814.1640625, ins.evaluate(9.167), Util.EPSILON_LARGE);
        assertEquals(-2819858.65625, ins.evaluate(dateToDouble("09/09/2021")), Util.EPSILON_LARGE);

        // Func
        ins = new Interpolation(generateFunTC(5));
        ins.fit();
        assertEquals(0, ins.evaluate(0), Util.EPSILON_LARGE);
        assertEquals(0.386531595659, ins.evaluate(0.3), 0.1);
        assertEquals(0.457294851048, ins.evaluate(0.55), 0.1);
        assertEquals(0.584593146846, ins.evaluate(1.7), 0.1);
    }

    /**
     * Test of isFit method, of class Interpolation.
     */
    @Test
    public void testIsFit() {
        System.out.println("isFit");
        Matrix points = new Matrix(DATA_TABLE_TC1);
        Interpolation ins = new Interpolation(points);
        assertFalse(ins.isFit());
        ins.fit();
        assertTrue(ins.isFit());
    }

    /**
     * Test of getCount method, of class Interpolation.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        Matrix points = new Matrix(DATA_TABLE_TC1);
        Interpolation ins = new Interpolation(points);
        assertEquals(7, ins.getCount());
        ins = new Interpolation(generateFunTC(1));
        assertEquals(2, ins.getCount());
        ins = new Interpolation();
        assertEquals(0, ins.getCount());
    }

    /**
     * Test of addPoints method, of class Interpolation.
     */
    @Test
    public void testAddPoints() {
        System.out.println("addPoints");
        Matrix points = generateFunTC(5);
        Interpolation ins = new Interpolation(); // add first row
        assertEquals(0, ins.getCount());
        ins.addPoints(points.copy(1, 2));
        assertEquals(1, ins.getCount());
        ins.addPoints(points.copy(1, 2, 0, 2)); // add 2 more
        assertEquals(3, ins.getCount());
        ins.addPoints(points.copy(3, 3, 0, 2)); // add 3 more
        assertEquals(6, ins.getCount());
        // Make sure they are the same (from original Evaluate)
        ins.fit();
        assertEquals(0, ins.evaluate(0), Util.EPSILON_LARGE);
        assertEquals(0.386531595659, ins.evaluate(0.3), 0.1);
        assertEquals(0.457294851048, ins.evaluate(0.55), 0.1);
        assertEquals(0.584593146846, ins.evaluate(1.7), 0.1);
    }

    /**
     * Test of fit method, of class Interpolation.
     */
    @Test
    public void testFit() {
        System.out.println("fit");
        Matrix points = generateFunTC(5);
        Interpolation ins = new Interpolation(points.copy(1, 2)); // add first row
        ins.fit();
        assertFalse(ins.isFit()); // data with 1 point can't be fitted
        ins.addPoints(points.copy(1, 5, 0, 2)); // add 2 more
        ins.fit();
        assertTrue(ins.isFit()); // should fitted now.
    }

    /**
     * Test of toString method, of class Interpolation.
     */
    @Test
    public void testToString_UtilFormatting() {
        System.out.println("toString");
        Matrix points = generateFunTC(2);
        Interpolation ins = new Interpolation(points);
        ins.fit();
        assertEquals("f(x) = \n"
            + "0.7874399206041194x\n"
            + "- 0.24955707786412917x^2", ins.toString(Util.Formatting.DEFAULT));
        assertEquals("f(x) = \n"
            + "0.787x\n"
            + "- 0.25x^2", ins.toString(Util.Formatting.SHORT));
        assertEquals("f(x) = \n"
            + "0.787x\n"
            + "- 0.250x^2", ins.toString(Util.Formatting.PADDED_SHORT));
        assertEquals("f(x) = \n"
            + "0.7874399206041x\n"
            + "- 0.2495570778641x^2", ins.toString(Util.Formatting.LONG));
    }

    /**
     * Test of toString method, of class Interpolation.
     */
    @Test
    public void testToString_0args() {
        System.out.println("toString");
        Matrix points = generateFunTC(2);
        Interpolation ins = new Interpolation(points.copy(1, 2));
        assertEquals("Data tidak cukup untuk diinterpolasi.", ins.toString());
        ins.addPoints(points.copy(1, 2, 0, 2));
        assertEquals("Interpolasi belum di-fit. Jalankan fit() terlebih dahulu.", ins.toString());
        ins.fit();
        assertEquals("f(x) = \n"
            + "0.7874399206041194x\n"
            + "- 0.24955707786412917x^2", ins.toString());
        ins = new Interpolation(new Matrix(new double[][]{
            {2, 3},
            {4, 5}
        }));
        ins.fit();
        assertEquals("f(x) = \n"
            + "1.0\n"
            + "+ x", ins.toString());
        ins = new Interpolation(new Matrix(new double[][]{
            {-1, 1},
            {0, 0},
            {1, 1}
        }));
        ins.fit();
        assertEquals("f(x) = \n"
            + "x^2", ins.toString());
        ins = new Interpolation(new Matrix(new double[][]{
            {2, -3},
            {-4, 6}
        }));
        ins.fit();
        assertEquals("f(x) = \n"
            + "-1.5x", ins.toString());
        ins = new Interpolation(new Matrix(new double[][]{
            {0, 0},
            {1, 0}
        }));
        ins.fit();
        assertEquals("f(x) = \n"
            + "0.0", ins.toString());
        ins = new Interpolation(new Matrix(new double[][]{
            {0, 0},
            {1, -1}
        }));
        ins.fit();
        assertEquals("f(x) = \n"
            + "-x", ins.toString());
    }
}
