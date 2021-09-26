/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alingeo.matriks;

import alingeo.matriks.solver.SPLSolver;
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
        Matrix ins = new Matrix(new double[][] {
            {1,2,3,1},
            {3,2,4,2},
            {4,9,1,0}
        });
        ins.setNCol(5);
        assertEquals(5, ins.getNCol());
        assertArrayEquals(new double [][] {
            {1,2,3,1,0},
            {3,2,4,2,0},
            {4,9,1,0,0}
        }, ins.getData());
        ins.setNCol(1);
        assertEquals(1, ins.getNCol());
        assertArrayEquals(new double [][] {
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
        Matrix ins = new Matrix(new double[][] {
            {1,2},
            {3,2},
            {4,2},
            {4,9},
            {1,0}
        });
        ins.setNRow(2);
        assertEquals(2, ins.getNRow());
        assertArrayEquals(new double [][] {
            {1,2},
            {3,2},
        }, ins.getData());
        ins.setNRow(5);
        assertEquals(5, ins.getNRow());
        assertArrayEquals(new double [][] {
            {1,2},
            {3,2},
            {0,0},
            {0,0},
            {0,0}
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
            {333, -123.2, 29},
        });
        assertEquals(1.23, ins.getElmt(0,0));
        assertEquals(11.25, ins.getElmt(0,1));
        assertEquals(0, ins.getElmt(0,2));
        assertEquals(333, ins.getElmt(1,0));
        assertEquals(-123.2, ins.getElmt(1,1));
        assertEquals(29, ins.getElmt(1,2));
    }

    /**
     * Test of setElmt method, of class Matrix.
     */
    @Test
    public void testSetElmt() {
        System.out.println("setElmt");
        Matrix ins = new Matrix(3,3);
        ins.setElmt(0, 0, 1.23);
        assertEquals(1.23, ins.getElmt(0,0));
        ins.setElmt(0, 1, 11.25);
        assertEquals(11.25, ins.getElmt(0,1));
        ins.setElmt(0, 2, 0);
        assertEquals(0, ins.getElmt(0,2));
        ins.setElmt(1, 0, 333);
        assertEquals(333, ins.getElmt(1,0));
        ins.setElmt(1, 1, -123.2);
        assertEquals(-123.2, ins.getElmt(1,1));
        ins.setElmt(1, 2, 29);
        assertEquals(29, ins.getElmt(1,2));
    }

    /**
     * Test of getData method, of class Matrix.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Matrix ins = new Matrix(3,3);
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
        ins.setData(new double [][]{
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
        int row = 0;
        Matrix instance = null;
        double[] expResult = null;
        double[] result = instance.getRow(row);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRow method, of class Matrix.
     */
    @Test
    public void testSetRow() {
        System.out.println("setRow");
        int row = 0;
        double[] data = null;
        Matrix instance = null;
        instance.setRow(row, data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSquare method, of class Matrix.
     */
    @Test
    public void testIsSquare() {
        System.out.println("isSquare");
        Matrix instance = null;
        boolean expResult = false;
        boolean result = instance.isSquare();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEchelon method, of class Matrix.
     */
    @Test
    public void testIsEchelon() {
        System.out.println("isEchelon");
        Matrix instance = new Matrix(3, 4);
        instance.setData(new double [][]{
            {1, 0, 3, 4},
            {0, 1, 2, 0},
            {0, 0, 1, 0}
        });
        boolean result = instance.isEchelon();
        assertEquals(true, result);
    }

    /**
     * Test of isEchelonReduced method, of class Matrix.
     */
    @Test
    public void testIsEchelonReduced() {
        System.out.println("isEchelonReduced");
        Matrix instance = null;
        boolean expResult = false;
        boolean result = instance.isEchelonReduced();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isTriangular method, of class Matrix.
     */
    @Test
    public void testIsTriangular() {
        System.out.println("isTriangular");
        Matrix instance = null;
        int expResult = 0;
        int result = instance.isTriangular();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of plus method, of class Matrix.
     */
    @Test
    public void testPlus_Matrix_Matrix() {
        System.out.println("plus");
        Matrix m1 = null;
        Matrix m2 = null;
        Matrix expResult = null;
        Matrix result = Matrix.plus(m1, m2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of plus method, of class Matrix.
     */
    @Test
    public void testPlus_Matrix() {
        System.out.println("plus");
        Matrix m = null;
        Matrix instance = null;
        instance.plus(m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of min method, of class Matrix.
     */
    @Test
    public void testMin_Matrix_Matrix() {
        System.out.println("min");
        Matrix m1 = null;
        Matrix m2 = null;
        Matrix expResult = null;
        Matrix result = Matrix.min(m1, m2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of min method, of class Matrix.
     */
    @Test
    public void testMin_Matrix() {
        System.out.println("min");
        Matrix m = null;
        Matrix instance = null;
        instance.min(m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiplication method, of class Matrix.
     */
    @Test
    public void testMultiplication_Matrix_Matrix() {
        System.out.println("multiplication");
        Matrix m1 = null;
        Matrix m2 = null;
        Matrix expResult = null;
        Matrix result = Matrix.multiplication(m1, m2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiplication method, of class Matrix.
     */
    @Test
    public void testMultiplication_Matrix() {
        System.out.println("multiplication");
        Matrix m2 = null;
        Matrix instance = null;
        instance.multiplication(m2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transpose method, of class Matrix.
     */
    @Test
    public void testTranspose() {
        System.out.println("transpose");
        Matrix instance = null;
        instance.transpose();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RowSum method, of class Matrix.
     */
    @Test
    public void testRowSum() {
        System.out.println("RowSum");
        int row1 = 0;
        int row2 = 0;
        double k = 0.0;
        Matrix instance = null;
        instance.RowSum(row1, row2, k);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RowSwap method, of class Matrix.
     */
    @Test
    public void testRowSwap() {
        System.out.println("RowSwap");
        int row1 = 0;
        int row2 = 0;
        Matrix instance = null;
        instance.RowSwap(row1, row2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ScalarRowMultiplication method, of class Matrix.
     */
    @Test
    public void testScalarRowMultiplication() {
        System.out.println("ScalarRowMultiplication");
        int row = 0;
        double k = 0.0;
        Matrix instance = null;
        instance.ScalarRowMultiplication(row, k);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of ForwardElim method, of class SPLSolver.
     */
    @Test
    public void testForwardElim() {
        System.out.println("ForwardElim");
        Matrix ins = new Matrix(3, 4);
        ins.setData(new double [][]{
            {1, 1, 1, 5},
            {2, 3, 5, 8},
            {4, 0, 5, 2}
        });
        SPLSolver.forwardElim(ins, true);
        
        for (int i = 0; i < 3; i++) { //this equals to the row in our matrix.
           for (int j = 0; j < 4; j++) { //this equals to the column in each row.
              System.out.print(ins.getElmt(i, j) + " ");
           }
           System.out.println(); //change line on console as row comes to end in the matrix.
        }
        assertArrayEquals(new double[][]{
            {1, 0, 0, 3},
            {0, 1, 0, 4},
            {0, 0, 1, -2}
        }, ins.getData());
    }
    
        /**
     * Test of GaussJordanMethod method, of class SPLSolver.
     */
    @Test
    public void testGaussJordanMethod() {
        System.out.println("GaussJordanMethod");
        Matrix ins = new Matrix(4, 7);
        ins.setData(new double [][]{
            {1, 2, 3, 2, 1, 2, 3},
            {2, 1, 2, 3, 2, 1, 2},
            {3, 2, 1, 2, 3, 2, 1},
            {0, 0, 0, 0, 0, 0, 0}
        });
        Matrix result;
        
        result = SPLSolver.gaussJordanMethod(ins);
        
        assertArrayEquals(new double[][]{
            {3},
            {4},
            {-2}
        }, result.getData());
    }
    
    /**
     * Test of GaussMethod method, of class SPLSolver.
     */
    @Test
    public void testGaussMethod() {
        System.out.println("GaussMethod");
        Matrix ins = new Matrix(2, 5);
        ins.setData(new double [][]{
            {2, 3, 4, 3, 2},
            {1, 2, 3, 4, 3},
        });
        Matrix result;
        result = SPLSolver.gaussMethod(ins);
        
        assertArrayEquals(new double[][]{
            {3},
            {4},
            {-2}
        }, result.getData());
    }
    
}
