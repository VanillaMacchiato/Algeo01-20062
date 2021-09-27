/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alingeo.matriks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Windows 7
 */
public class MatrixTest {

    public MatrixTest() {
    }

    /**
     * Test of getNCol method, of class Matrix.
     */
    @Test
    public void testGetNCol() {
        System.out.println("getNCol");
        assertEquals(2, new Matrix(1, 2).getNCol());
        assertEquals(10, new Matrix(3, 10).getNCol());
        assertEquals(5, new Matrix(5, 5).getNCol());
    }

    /**
     * Test of getNRow method, of class Matrix.
     */
    @Test
    public void testGetNRow() {
        System.out.println("getNRow");
        assertEquals(1, new Matrix(1, 2).getNRow());
        assertEquals(3, new Matrix(3, 10).getNRow());
        assertEquals(5, new Matrix(5, 5).getNRow());
    }

    /**
     * Test of setNCol method, of class Matrix.
     */
    @Test
    public void testSetNCol() {
        System.out.println("setNCol");
        Matrix ins = new Matrix(new double[][]{
            {1, 2, 3, 1},
            {3, 2, 4, 2},
            {4, 9, 1, 0}
        });
        ins.setNCol(5);
        assertEquals(5, ins.getNCol());
        assertArrayEquals(new double[][]{
            {1, 2, 3, 1, 0},
            {3, 2, 4, 2, 0},
            {4, 9, 1, 0, 0}
        }, ins.getData());
        ins.setNCol(1);
        assertEquals(1, ins.getNCol());
        assertArrayEquals(new double[][]{
            {1},
            {3},
            {4}
        }, ins.getData());
        ins.setNCol(0);
        ins.setNCol(10);
        assertEquals(10, ins.getNCol());
        assertArrayEquals(new double[3][10], ins.getData());
    }

    /**
     * Test of setNRow method, of class Matrix.
     */
    @Test
    public void testSetNRow() {
        System.out.println("setNRow");
        Matrix ins = new Matrix(new double[][]{
            {1, 2},
            {3, 2},
            {4, 2},
            {4, 9},
            {1, 0}
        });
        ins.setNRow(2);
        assertEquals(2, ins.getNRow());
        assertArrayEquals(new double[][]{
            {1, 2},
            {3, 2},}, ins.getData());
        ins.setNRow(5);
        assertEquals(5, ins.getNRow());
        assertArrayEquals(new double[][]{
            {1, 2},
            {3, 2},
            {0, 0},
            {0, 0},
            {0, 0}
        }, ins.getData());
        ins.setNRow(0);
        ins.setNRow(10);
        assertEquals(10, ins.getNRow());
        assertArrayEquals(new double[10][2], ins.getData());
    }

    /**
     * Test of getElmt method, of class Matrix.
     */
    @Test
    public void testGetElmt() {
        System.out.println("getElmt");
        Matrix ins = new Matrix(new double[][]{
            {1.23, 11.25, 0},
            {333, -123.2, 29},});
        assertEquals(1.23, ins.getElmt(0, 0));
        assertEquals(11.25, ins.getElmt(0, 1));
        assertEquals(0, ins.getElmt(0, 2));
        assertEquals(333, ins.getElmt(1, 0));
        assertEquals(-123.2, ins.getElmt(1, 1));
        assertEquals(29, ins.getElmt(1, 2));
    }

    /**
     * Test of setElmt method, of class Matrix.
     */
    @Test
    public void testSetElmt() {
        System.out.println("setElmt");
        Matrix ins = new Matrix(3, 3);
        ins.setElmt(0, 0, 1.23);
        assertEquals(1.23, ins.getElmt(0, 0));
        ins.setElmt(0, 1, 11.25);
        assertEquals(11.25, ins.getElmt(0, 1));
        ins.setElmt(0, 2, 0);
        assertEquals(0, ins.getElmt(0, 2));
        ins.setElmt(1, 0, 333);
        assertEquals(333, ins.getElmt(1, 0));
        ins.setElmt(1, 1, -123.2);
        assertEquals(-123.2, ins.getElmt(1, 1));
        ins.setElmt(1, 2, 29);
        assertEquals(29, ins.getElmt(1, 2));
    }

    /**
     * Test of getData method, of class Matrix.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Matrix ins = new Matrix(3, 3);
        assertEquals(3, ins.getNRow());
        assertEquals(3, ins.getNCol());
        assertArrayEquals(new double[3][3], ins.getData());
        ins = new Matrix(new double[][]{
            {1, 2, 3},
            {99.91, -12, 23.2},
            {0, 0, 0},
            {-12, 22, 1.2}
        });
        assertEquals(4, ins.getNRow());
        assertEquals(3, ins.getNCol());
        assertArrayEquals(new double[][]{
            {1, 2, 3},
            {99.91, -12, 23.2},
            {0, 0, 0},
            {-12, 22, 1.2}
        }, ins.getData());
    }

    /**
     * Test of setData method, of class Matrix.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        Matrix ins = new Matrix(2, 2);
        ins.setData(new double[][]{
            {99, 12, 31},
            {20, 20, 99}
        });
        assertEquals(2, ins.getNRow());
        assertEquals(3, ins.getNCol());
        assertArrayEquals(new double[][]{
            {99, 12, 31},
            {20, 20, 99}
        }, ins.getData());
    }

    /**
     * Test of getRow method, of class Matrix.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        Matrix ins = new Matrix(new double[][]{
            {0.2, 99},
            {-2.1, -10},
            {0, 5.1}
        });
        assertArrayEquals(new double[]{0.2, 99}, ins.getRow(0));
        assertArrayEquals(new double[]{-2.1, -10}, ins.getRow(0));
        assertArrayEquals(new double[]{0, 5.1}, ins.getRow(0));
        ins = new Matrix(new double[1][0]);
        assertArrayEquals(new double[0], ins.getRow(0));
    }

    /**
     * Test of setRow method, of class Matrix.
     */
    @Test
    public void testSetRow() {
        System.out.println("setRow");
        Matrix ins = new Matrix(2, 3);
        ins.setRow(1, new double[]{1, 2, 3});
        assertArrayEquals(new double[]{1, 2, 3}, ins.getRow(1));
        ins.setRow(0, new double[]{99.99, 1.23, 0});
        assertArrayEquals(new double[]{99.99, 1.23, 0}, ins.getRow(0));
    }

    /**
     * Test of isSquare method, of class Matrix.
     */
    @Test
    public void testIsSquare() {
        System.out.println("isSquare");
        Matrix ins = new Matrix(new double[][]{
            {1, 2, 3},
            {2, 2, 0}
        });
        assertEquals(false, ins.isSquare());
        ins.resize(3, 3);
        assertEquals(true, ins.isSquare());
        ins.resize(0, 0);
        assertEquals(true, ins.isSquare());
        ins.resize(3, 1);
        assertEquals(false, ins.isSquare());
    }

    /**
     * Test of isEchelon method, of class Matrix.
     */
    @Test
    public void testIsEchelon() {
        System.out.println("isEchelon");
        Matrix ins = new Matrix(new double[][]{
            {1, 0, 3, 4},
            {0, 1, 2, 0},
            {0, 0, 1, 0}
        });
        assertEquals(true, ins.isEchelon());
        ins.setData(new double[][]{
            {1, 9},
            {0, 1},});
        assertEquals(true, ins.isEchelon());
        ins.setData(new double[][]{
            {0, 1, 0.9, 1},
            {0, 0, 1, 1}
        });
        assertEquals(true, ins.isEchelon());
        ins.setData(new double[][]{
            {0, 0, 1},
            {0, 0, 0}
        });
        assertEquals(true, ins.isEchelon());
        ins.setData(new double[][]{
            {0, 0, 1, 2},
            {0, 1, 1, 9},
            {1, 1, 1, 1}
        });
        assertEquals(false, ins.isEchelon());
        ins.setData(new double[][]{
            {9, 1, 1},
            {0, 0, 1}
        });
        assertEquals(false, ins.isEchelon());
        ins.setData(new double[][]{
            {1, 1},
            {0, 0},
            {0, 1},});
        assertEquals(false, ins.isEchelon());
    }

    /**
     * Test of isEchelonReduced method, of class Matrix.
     */
    @Test
    public void testIsEchelonReduced() {
        System.out.println("isEchelonReduced");
        Matrix ins = new Matrix(new double[][]{
            {1, 0, 3, 4},
            {0, 1, 2, 9},
            {0, 0, 0, 1}
        });
        assertEquals(true, ins.isEchelonReduced());
        ins.setData(new double[][]{
            {1, 0},
            {0, 1},});
        assertEquals(true, ins.isEchelonReduced());
        ins.setData(new double[][]{
            {1, 0, 9, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 1},
            {0, 0, 0, 0}
        });
        assertEquals(true, ins.isEchelonReduced());
        ins.setData(new double[][]{
            {0, 0, 1, 2},
            {0, 1, 1, 9},
            {1, 1, 1, 1}
        });
        assertEquals(false, ins.isEchelonReduced());
        ins.setData(new double[][]{
            {1, 1, 1},
            {0, 1, 0}
        });
        assertEquals(false, ins.isEchelonReduced());
        ins.setData(new double[][]{
            {1, 1},
            {9, 1},
            {0, 1},});
        assertEquals(false, ins.isEchelonReduced());
    }

    /**
     * Test of isTriangular method, of class Matrix.
     */
    @Test
    public void testIsTriangular() {
        System.out.println("isTriangular");
        Matrix ins = new Matrix(new double[][]{
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        });
        assertEquals(0, ins.isTriangular());
    }
}
