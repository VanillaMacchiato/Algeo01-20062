/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alingeo.matriks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }
    /**
     * Test of getNCol method, of class Matrix.
     */
    @Test
    public void testGetNCol() {
        System.out.println("getNCol");
        Matrix instance = null;
        int expResult = 0;
        int result = instance.getNCol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNRow method, of class Matrix.
     */
    @Test
    public void testGetNRow() {
        System.out.println("getNRow");
        Matrix instance = null;
        int expResult = 0;
        int result = instance.getNRow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNCol method, of class Matrix.
     */
    @Test
    public void testSetNCol() {
        System.out.println("setNCol");
        int nCol = 0;
        Matrix instance = null;
        instance.setNCol(nCol);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNRow method, of class Matrix.
     */
    @Test
    public void testSetNRow() {
        System.out.println("setNRow");
        int nRow = 0;
        Matrix instance = null;
        instance.setNRow(nRow);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getElmt method, of class Matrix.
     */
    @Test
    public void testGetElmt() {
        System.out.println("getElmt");
        int row = 0;
        int col = 0;
        Matrix instance = null;
        float expResult = 0.0F;
        float result = instance.getElmt(row, col);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setElmt method, of class Matrix.
     */
    @Test
    public void testSetElmt() {
        System.out.println("setElmt");
        int row = 0;
        int col = 0;
        float val = 0.0F;
        Matrix instance = null;
        instance.setElmt(row, col, val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class Matrix.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        Matrix instance = null;
        float[][] expResult = null;
        float[][] result = instance.getData();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setData method, of class Matrix.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        float[][] data = null;
        Matrix instance = null;
        instance.setData(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRow method, of class Matrix.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        int row = 0;
        Matrix instance = null;
        float[] expResult = null;
        float[] result = instance.getRow(row);
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
        float[] data = null;
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
        Matrix instance = null;
        boolean expResult = false;
        boolean result = instance.isEchelon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        float k = 0.0F;
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
        float k = 0.0F;
        Matrix instance = null;
        instance.ScalarRowMultiplication(row, k);
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
        boolean expResult = false;
        boolean result = instance.isTriangular();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
