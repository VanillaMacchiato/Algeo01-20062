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
    @Test
    public void testGaussJordanMethod() {
        System.out.println("GaussJordanMethod");
        Matrix m = new Matrix(new double[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        });
        assertEquals(null, InversSolver.GaussJordanMethod(m));
        m.setData(new double[][]{
            {1, 2, 3},
            {4, 1, 2},
            {6, 6, 2}
        });
        assertArrayEquals(new double[][]{
            {-0.19230769230769237, 0.26923076923076916, 0.019230769230769277},
            {0.07692307692307704, -0.3076923076923076, 0.19230769230769224},
            {0.3461538461538461, 0.11538461538461535, -0.13461538461538458}
        }, InversSolver.GaussJordanMethod(m).getData());
        m.setData(new double[][]{
            {1, 1, -1, -1},
            {2, 5, -7, -5},
            {2, -1, 1, 3},
            {5, 2, -4, 2}
        });
        assertEquals(null, InversSolver.GaussJordanMethod(m));
    }

    /**
     * Test of CofactorMatrix method, of class InversSolver.
     */
    @Test
    public void testCofactorMatrix() {
        System.out.println("CofactorMatrix");
        Matrix m = new Matrix(new double[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        });
        assertArrayEquals(new double[][]{
            {-3, 6, -3},
            {6, -12, 6},
            {-3, 6, -3}
        }, InversSolver.CofactorMatrix(m).getData());
        m.setData(new double[][]{
            {1, 2, 3},
            {4, 1, 2},
            {6, 6, 2}
        });
        assertArrayEquals(new double[][]{
            {-10, 4, 18},
            {14, -16, 6},
            {1, 10, -7}
        }, InversSolver.CofactorMatrix(m).getData());
        m.setData(new double[][]{
            {1, 1, -1, -1},
            {2, 5, -7, -5},
            {2, -1, 1, 3},
            {5, 2, -4, 2}
        });
        assertArrayEquals(new double[][]{
            {4, -16, -6, -6},
            {-4, 16, 6, 6},
            {-8, 32, 12, 12},
            {4, -16, -6, -6}
        }, InversSolver.CofactorMatrix(m).getData());
    }

    /**
     * Test of AdjointMethod method, of class InversSolver.
     */
    @Test
    public void testAdjointMethod() {
        System.out.println("AdjointMethod");
        Matrix m = new Matrix(new double[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        });
        assertEquals(null, InversSolver.AdjointMethod(m));
        m.setData(new double[][]{
            {1, 2, 3},
            {4, 1, 2},
            {6, 6, 2}
        });
        assertArrayEquals(new double[][]{
            {-0.19230769230769226, 0.26923076923076916, 0.019230769230769225},
            {0.0769230769230769, -0.3076923076923076, 0.19230769230769226},
            {0.34615384615384603, 0.11538461538461535, -0.13461538461538458}
        }, InversSolver.AdjointMethod(m).getData());
        m.setData(new double[][]{
            {1, 1, -1, -1},
            {2, 5, -7, -5},
            {2, -1, 1, 3},
            {5, 2, -4, 2}
        });
        assertEquals(null, InversSolver.AdjointMethod(m));
    }

}
