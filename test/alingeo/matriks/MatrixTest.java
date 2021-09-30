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
        assertArrayEquals(new double[]{-2.1, -10}, ins.getRow(1));
        assertArrayEquals(new double[]{0, 5.1}, ins.getRow(2));
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
            {0, 1}
        });
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
            {0, 1}
        });
        assertEquals(false, ins.isEchelon());
    }

    /**
     * Test of isEchelonReduced method, of class Matrix.
     */
    @Test
    public void testIsEchelonReduced() {
        System.out.println("isEchelonReduced");
        Matrix ins = new Matrix(new double[][]{
            {1, 0, 3, 0},
            {0, 1, 2, 0},
            {0, 0, 0, 1}
        });
        assertEquals(true, ins.isEchelonReduced());
        ins.setData(new double[][]{
            {1, 0},
            {0, 1}
        });
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
            {0, 1}
        });
        assertEquals(false, ins.isEchelonReduced());
    }

    /**
     * Test of isTriangular method, of class Matrix.
     */
    @Test
    public void testIsTriangular() {
        System.out.println("isTriangular");
        Matrix ins = new Matrix(new double[][]{
            {9, 0, 0},
            {0, -1, 0},
            {0, 0, 1.1}
        });
        assertEquals(Matrix.TriangularType.Diagonal, ins.isTriangular());
        ins.setData(new double[1][1]);
        assertEquals(Matrix.TriangularType.Diagonal, ins.isTriangular());
        ins.setData(new double[][]{
            {0, 2},
            {9, 1}
        });
        assertEquals(Matrix.TriangularType.None, ins.isTriangular());
        ins.setData(new double[][]{
            {1, 1, 2},
            {0, 2, -0.1}
        });
        assertEquals(Matrix.TriangularType.None, ins.isTriangular());
        ins.setData(new double[][]{
            {0, 1},
            {1, 0}
        });
        assertEquals(Matrix.TriangularType.None, ins.isTriangular());
        ins.setData(new double[][]{
            {0, 0, 1},
            {0, 0, 0},
            {0, 0, 0}
        });
        assertEquals(Matrix.TriangularType.Lower, ins.isTriangular());
        ins.setData(new double[][]{
            {-1.2, 9.9},
            {0, 2.1}
        });
        assertEquals(Matrix.TriangularType.Lower, ins.isTriangular());
        ins.setData(new double[][]{
            {0, -0, 1, 21},
            {0, -4, 0.1, 2},
            {0, 0, 9, 9},
            {0, 0, 0, 0}
        });
        assertEquals(Matrix.TriangularType.Lower, ins.isTriangular());
        ins.setData(new double[][]{
            {0, 0, 0.0},
            {1, 0, -0.0},
            {0, 0, 0}
        });
        assertEquals(Matrix.TriangularType.Upper, ins.isTriangular());
        ins.setData(new double[][]{
            {-1.2, 0},
            {99, 0}
        });
        assertEquals(Matrix.TriangularType.Upper, ins.isTriangular());
        ins.setData(new double[][]{
            {9, -0, 0, -0.0},
            {2.3, 0, 0, 0.0},
            {-2, 0, -4, 0},
            {1, -3, 0, 0}
        });
        assertEquals(Matrix.TriangularType.Upper, ins.isTriangular());
    }

    /**
     * Test of resize method, of class Matrix.
     */
    @Test
    public void testResize() {
        System.out.println("resize");
        Matrix ins = new Matrix(new double[][]{
            {0, 99.99, -0.1, 44},
            {10, 2, 33, 99},
            {2, 0.1, 0, 2}
        });
        ins.resize(4, 3);
        assertEquals(4, ins.getNRow());
        assertEquals(3, ins.getNCol());
        assertArrayEquals(new double[][]{
            {0, 99.99, -0.1},
            {10, 2, 33},
            {2, 0.1, 0},
            {0, 0, 0}
        }, ins.getData());
        ins.resize(1, 4);
        assertEquals(1, ins.getNRow());
        assertEquals(4, ins.getNCol());
        assertArrayEquals(new double[][]{
            {0, 99.99, -0.1, 0}
        }, ins.getData());
        ins.resize(1, 1);
        assertEquals(1, ins.getNRow());
        assertEquals(1, ins.getNCol());
        assertArrayEquals(new double[1][1], ins.getData());
    }

    /**
     * Test of isIdentity method, of class Matrix.
     */
    @Test
    public void testIsIdentity() {
        System.out.println("isIdentity");
        Matrix ins = new Matrix(new double[][]{
            {1, 0, 0, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        });
        assertEquals(true, ins.isIdentity());
        ins.setData(new double[][]{
            {1, 0},
            {0, 1}
        });
        assertEquals(true, ins.isIdentity());
        ins.setData(new double[][]{
            {1}
        });
        assertEquals(true, ins.isIdentity());
        ins.setData(new double[][]{
            {1, 1, 1},
            {1, 1, 0},
            {0, 9, 9}
        });
        assertEquals(false, ins.isIdentity());
        ins.setData(new double[][]{
            {1, 1, 1},
            {1, 1, 0},
            {0, 9, 1}
        });
        assertEquals(false, ins.isIdentity());
        ins.setData(new double[2][2]);
        assertEquals(false, ins.isIdentity());
    }

    /**
     * Test of add method, of class Matrix.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Matrix m1 = new Matrix(new double[][]{
            {1, 2, 3, 4},
            {0, -1, 2, 3},
            {0, 0, 0, 1}
        });
        Matrix m2 = new Matrix(new double[][]{
            {-1, -2, -3, -4},
            {0, 1, -2, -3},
            {0, 0, 0, -1}
        });
        m1.add(m2);
        assertArrayEquals(new double[3][4], m1.getData());
        m2.setData(new double[][]{
            {0.12, -0.99, 2.1, 2},
            {-12, 3, 1.1, 9},
            {99, -29, 1.2, 33}
        });
        m1.add(m2);
        assertArrayEquals(new double[][]{
            {0.12, -0.99, 2.1, 2},
            {-12, 3, 1.1, 9},
            {99, -29, 1.2, 33}
        }, m1.getData());
        m1.resize(2, 2);
        m2.setData(new double[][]{
            {12.3, 99.99},
            {3, 0}
        });
        m1.add(m2);
        assertArrayEquals(new double[][]{
            {12.42, 99},
            {-9, 3}
        }, m1.getData());
    }

    /**
     * Test of sub method, of class Matrix.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        Matrix m1 = new Matrix(new double[][]{
            {1, 2, 3, 4},
            {0, -1, 2, 3},
            {0, 0, 0, 1}
        });
        Matrix m2 = new Matrix(new double[][]{
            {-1, -2, -3, -4},
            {0, 1, -2, -3},
            {0, 0, 0, -1}
        });
        m1.sub(m2);
        assertArrayEquals(new double[][]{
            {2, 4, 6, 8},
            {0, -2, 4, 6},
            {0, 0, 0, 2}
        }, m1.getData());
        m2.setData(new double[][]{
            {0.12, -0.99, 2.1, 2},
            {-12, 3, 1.1, 9},
            {99, -29, 1.2, 33}
        });
        m1.sub(m2);
        assertArrayEquals(new double[][]{
            {1.88, 4.99, 3.9, 6},
            {12, -5, 2.9, -3},
            {-99, 29, -1.2, -31}
        }, m1.getData());
        m1.resize(2, 2);
        m2.setData(new double[][]{
            {12.88, 99.99},
            {3, 0}
        });
        m1.sub(m2);
        assertArrayEquals(new double[][]{
            {-11, -95},
            {9, -5}
        }, m1.getData());
    }

    /**
     * Test of mul method, of class Matrix.
     */
    @Test
    public void testMul_Matrix() {
        System.out.println("mul");
        Matrix m1 = new Matrix(new double[][]{
            {1, 2, 3, 4},
            {0, -1, 2, 3},
            {0, 0, 0, 1}
        });
        Matrix m2 = new Matrix(new double[][]{
            {-1, -2},
            {0, 1},
            {0, 0},
            {-2, -3}
        });
        m1.mul(m2);
        assertArrayEquals(new double[][]{
            {-9, -12},
            {-6, -10},
            {-2, -3}
        }, m1.getData());
        m2.setData(new double[][]{
            {1},
            {-2}
        });
        m1.mul(m2);
        assertArrayEquals(new double[][]{
            {15},
            {14},
            {4}
        }, m1.getData());
    }

    /**
     * Test of transpose method, of class Matrix.
     */
    @Test
    public void testTranspose() {
        System.out.println("transpose");
        Matrix ins = new Matrix(new double[][]{
            {5, 0, 1, 2},
            {2, 3, 4, -1}
        });
        ins.transpose();
        assertArrayEquals(new double[][]{
            {5, 2},
            {0, 3},
            {1, 4},
            {2, -1}
        }, ins.getData());
        ins.setData(new double[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        });
        ins.transpose();
        assertArrayEquals(new double[][]{
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        }, ins.getData());
        ins.setData(new double[][]{
            {1}
        });
        ins.transpose();
        assertArrayEquals(new double[][]{
            {1}
        }, ins.getData());
    }

    /**
     * Test of RowSum method, of class Matrix.
     */
    @Test
    public void testRowSum() {
        System.out.println("RowSum");
        Matrix ins = new Matrix(new double[][]{
            {1, 2, 3},
            {-1, 1, -2},
            {0.1, 2.2, 3.2}
        });
        ins.RowSum(1, 0, 5);
        assertArrayEquals(new double[][]{
            {1, 2, 3},
            {4, 11, 13},
            {0.1, 2.2, 3.2}
        }, ins.getData());
        ins.RowSum(2, 1, 1);
        assertArrayEquals(new double[][]{
            {1, 2, 3},
            {4, 11, 13},
            {4.1, 13.2, 16.2}
        }, ins.getData());
        ins.RowSum(0, 1, 2);
        assertArrayEquals(new double[][]{
            {9, 24, 29},
            {4, 11, 13},
            {4.1, 13.2, 16.2}
        }, ins.getData());
    }

    /**
     * Test of RowSwap method, of class Matrix.
     */
    @Test
    public void testRowSwap() {
        System.out.println("RowSwap");
        Matrix ins = new Matrix(new double[][]{
            {1, 2, 3},
            {-1, 1, -2},
            {0.1, 2.2, 3.2}
        });
        ins.RowSwap(0, 1);
        ins.RowSwap(1, 2);
        assertArrayEquals(new double[][]{
            {-1, 1, -2},
            {0.1, 2.2, 3.2},
            {1, 2, 3}
        }, ins.getData());
        ins.RowSwap(0, 1);
        assertArrayEquals(new double[][]{
            {0.1, 2.2, 3.2},
            {-1, 1, -2},
            {1, 2, 3}
        }, ins.getData());
    }

    /**
     * Test of ScalarRowMultiplication method, of class Matrix.
     */
    @Test
    public void testScalarRowMultiplication() {
        System.out.println("ScalarRowMultiplication");
        int row = 0;
        double k = 2;
        Matrix instance = new Matrix(new double[][]{
            {0, 4, 2},
            {0, 0, 1},
            {3, 0, 0}
        });
        instance.ScalarRowMultiplication(row, k);
        assertArrayEquals(new double[][]{
            {0, 8, 4},
            {0, 0, 1},
            {3, 0, 0}
        }, instance.getData());
        k = 0;
        instance.ScalarRowMultiplication(row, k);
        assertArrayEquals(new double[][]{
            {0, 0, 0},
            {0, 0, 1},
            {3, 0, 0}
        }, instance.getData());

    }

    /**
     * Test of toEchelonFormRatio method, of class Matrix.
     */
    @Test
    public void testToEchelonFormRatio_boolean() {
        System.out.println("toEchelonFormRatio");
        boolean reducedForm = true;
        Matrix instance = new Matrix(new double[][]{
            {1, 3, 2, 3, 2},
            {2, 4, 3, 1, 5}
        });
        instance.toEchelonFormRatio(reducedForm);
        assertArrayEquals(new double[][]{
            {1, 0, 0.5, -4.5, 3.5},
            {-0.0, 1, 0.5, 2.5, -0.5}
        }, instance.getData());
        instance = new Matrix(new double[][]{
            {0, 2},
            {0, 5},
            {3, 6},
            {4, 2}
        });
        instance.toEchelonFormRatio(reducedForm);
        assertArrayEquals(new double[][]{
            {1, 0},
            {0, 1},
            {0, 0},
            {0, 0}
        }, instance.getData());

    }

    /**
     * Test of toEchelonForm method, of class Matrix.
     */
    @Test
    public void testToEchelonForm_boolean() {
        boolean reducedForm = true;
        Matrix instance = new Matrix(new double[][]{
            {1, 3, 2, 3, 2},
            {2, 4, 3, 1, 5}
        });
        instance.toEchelonForm(reducedForm);
        assertArrayEquals(new double[][]{
            {1, 0, 0.5, -4.5, 3.5},
            {-0.0, 1, 0.5, 2.5, -0.5}
        }, instance.getData());
        instance = new Matrix(new double[][]{
            {0, 2},
            {0, 5},
            {3, 6},
            {4, 2}
        });
        instance.toEchelonForm(reducedForm);
        assertArrayEquals(new double[][]{
            {1, 0},
            {0, 1},
            {0, 0},
            {0, 0}
        }, instance.getData());
    }

    /**
     * Test of getMinorMatrix method, of class Matrix.
     */
    @Test
    public void testGetMinorMatrix() {
        System.out.println("getMinorMatrix");
        int row = 0;
        int col = 0;
        Matrix instance = new Matrix(new double[][]{
            {5, 1, 2, 3},
            {6, 1, 2, 2},
            {0, 0, 1, 2},
            {0, 0, 2, 5}
        });
        Matrix result = instance.getMinorMatrix(2, 1);
        assertArrayEquals(new double[][]{
            {5, 2, 3},
            {6, 2, 2},
            {0, 2, 5}
        }, result.getData());
        result = instance.getMinorMatrix(3, 0);
        assertArrayEquals(new double[][]{
            {1, 2, 3},
            {1, 2, 2},
            {0, 1, 2}
        }, result.getData());
    }

    /**
     * Test of copy method, of class Matrix.
     */
    @Test
    public void testCopy_startrange() {
        System.out.println("copy start range");
        Matrix ins = new Matrix(new double[][]{
            {0, 1, 2},
            {3, -1, 2},
            {2, 3, 4},
            {5, 5, 6}
        });
        Matrix exp = ins.copy(1, 2, 1, 2);
        // Make sure it's properly copied
        assertArrayEquals(new double[][]{
            {-1, 2},
            {3, 4}
        }, exp.getData());
        exp = ins.copy(2, 1, 0, 2);
        // Make sure it's properly copied p2
        assertArrayEquals(new double[][]{
            {2, 3}
        }, exp.getData());
        exp = ins.copy(3, 1, 1, 2);
        // Make sure it's properly copied p3
        assertArrayEquals(new double[][]{
            {5, 6}
        }, exp.getData());
        exp = ins.copy(0, 0, 0, 0);
        // Make sure it's properly copied p4
        assertArrayEquals(new double[0][0], exp.getData());
        exp = ins.copy(2, 2, 0, 3);
        // Make sure it's properly copied p5
        assertArrayEquals(new double[][]{
            {2, 3, 4},
            {5, 5, 6}
        }, exp.getData());
        exp.resize(1, 2);
        // Instance should not be changed
        assertArrayEquals(new double[][]{
            {0, 1, 2},
            {3, -1, 2},
            {2, 3, 4},
            {5, 5, 6}
        }, ins.getData());
    }

    /**
     * Test of copy method, of class Matrix.
     */
    @Test
    public void testCopy_range() {
        System.out.println("copy range");
        Matrix ins = new Matrix(new double[][]{
            {0, 1, 2},
            {3, -1, 2},
            {2, 3, 4},
            {5, 5, 6}
        });
        Matrix exp = ins.copy(4, 2);
        // Make sure it's properly copied
        assertArrayEquals(new double[][]{
            {0, 1},
            {3, -1},
            {2, 3},
            {5, 5}
        }, exp.getData());
        exp = ins.copy(2, 2);
        // Make sure it's properly copied p2
        assertArrayEquals(new double[][]{
            {0, 1},
            {3, -1}
        }, exp.getData());
        exp = ins.copy(1, 1);
        // Make sure it's properly copied p3
        assertArrayEquals(new double[][]{
            {0}
        }, exp.getData());
        exp = ins.copy(0, 0);
        // Make sure it's properly copied p4
        assertArrayEquals(new double[0][0], exp.getData());
        exp = ins.copy(2, 3);
        // Make sure it's properly copied p5
        assertArrayEquals(new double[][]{
            {0, 1, 2},
            {3, -1, 2}
        }, exp.getData());
        exp.resize(1, 2);
        // Instance should not be changed
        assertArrayEquals(new double[][]{
            {0, 1, 2},
            {3, -1, 2},
            {2, 3, 4},
            {5, 5, 6}
        }, ins.getData());
    }

    /**
     * Test of copy method, of class Matrix.
     */
    @Test
    public void testCopy_itself() {
        System.out.println("copy itself");
        Matrix ins = new Matrix(new double[][]{
            {0, 1, 2},
            {3, -1, 2},
            {2, 3, 4}
        });
        Matrix exp = ins.copy();
        // Make sure it's the same
        assertArrayEquals(new double[][]{
            {0, 1, 2},
            {3, -1, 2},
            {2, 3, 4}
        }, exp.getData());
        exp.resize(2, 3);
        // Instance should not be changed
        assertArrayEquals(new double[][]{
            {0, 1, 2},
            {3, -1, 2},
            {2, 3, 4}
        }, ins.getData());
        assertArrayEquals(new double[][]{
            {0, 1, 2},
            {3, -1, 2}
        }, exp.getData());
    }

    /**
     * Test of toString method, of class Matrix.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Matrix ins = new Matrix(new double[][]{
            {1.2, 0, -1},
            {9, 10, 2}
        });
        assertEquals("1.20 0.00 -1.00\n9.00 10.00 2.00", ins.toString());
        ins.setData(new double[][]{
            {0, 0},
            {9.99, 10}
        });
        assertEquals("0.00 0.00\n9.99 10.00", ins.toString());
        ins.setData(new double[][]{
            {1.23}
        });
        assertEquals("1.23", ins.toString());
    }

    /**
     * Test of toEchelonForm method, of class Matrix.
     */
    @Test
    public void testToEchelonForm_Matrix_boolean() {
        boolean reducedForm = true;
        Matrix instance = new Matrix(new double[][]{
            {1, 3, 2, 3, 2},
            {2, 4, 3, 1, 5}
        });
        Matrix out = Matrix.toEchelonForm(instance, reducedForm);
        assertArrayEquals(new double[][]{
            {1, 0, 0.5, -4.5, 3.5},
            {-0.0, 1, 0.5, 2.5, -0.5}
        }, out.getData());
        instance = new Matrix(new double[][]{
            {0, 2},
            {0, 5},
            {3, 6},
            {4, 2}
        });
        out = Matrix.toEchelonForm(instance, reducedForm);
        assertArrayEquals(new double[][]{
            {1, 0},
            {0, 1},
            {0, 0},
            {0, 0}
        }, out.getData());
    }

    /**
     * Test of toEchelonFormRatio method, of class Matrix.
     */
    @Test
    public void testToEchelonFormRatio_3args() {
        boolean reducedForm = true;
        Matrix instance = new Matrix(new double[][]{
            {1, 3, 2, 3, 2},
            {2, 4, 3, 1, 5}
        });
        Matrix out = instance.copy();
        Matrix.toEchelonFormRatio(instance, out, reducedForm);
        assertArrayEquals(new double[][]{
            {1, 0, 0.5, -4.5, 3.5},
            {-0.0, 1, 0.5, 2.5, -0.5}
        }, out.getData());
        instance = new Matrix(new double[][]{
            {0, 2},
            {0, 5},
            {3, 6},
            {4, 2}
        });
        out = instance.copy();
        Matrix.toEchelonFormRatio(instance, out, reducedForm);
        assertArrayEquals(new double[][]{
            {1, 0},
            {0, 1},
            {0, 0},
            {0, 0}
        }, out.getData());
    }
}
