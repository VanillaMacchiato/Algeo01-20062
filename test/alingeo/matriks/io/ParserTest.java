/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alingeo.matriks.io;

import alingeo.matriks.Matrix;
import alingeo.matriks.Util;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.io.TempDir;

/**
 *
 * @author Amar Fadil
 */
@TestMethodOrder(OrderAnnotation.class)
public class ParserTest {

    @TempDir
    static Path tempDir;

    public ParserTest() {
    }

    /**
     * Test of stringToMatrix method, of class Parser.
     */
    @Test
    public void testStringToMatrix() {
        System.out.println("stringToMatrix");
        Matrix result = Parser.stringToMatrix(
            "0 1 2\n"
            + "2 -2.01 33.2\n"
            + "-0.2 0.00 1.2\n"
        );
        assertArrayEquals(new double[][]{
            {0, 1, 2},
            {2, -2.01, 33.2},
            {-0.2, 0.00, 1.2}
        }, result.getData());

        result = Parser.stringToMatrix(
            "0"
        );
        assertArrayEquals(new double[][]{
            {0}
        }, result.getData());

        result = Parser.stringToMatrix(
            "09.99 21.22"
        );
        assertArrayEquals(new double[][]{
            {9.99, 21.22}
        }, result.getData());
    }

    /**
     * Test of stringToFile method, of class Parser.
     *
     * @throws java.io.IOException
     */
    @Test
    @Order(1)
    public void testStringToFile() throws IOException {
        System.out.println("stringToFile");
        Parser.stringToFile(
            "1 -1 2 -1 -1\n"
            + "2 1 -2 -2 -2\n"
            + "-1 2 -4 1 1\n"
            + "3 0 0 -3 -3",
            tempDir.resolve("TC1.txt").toString()
        );

        Parser.stringToFile(
            "1.0000000 0.5000000 0.3333333 0.2500000 0.2000000 0.16666667 1\n"
            + "0.5000000 0.3333333 0.2500000 0.2000000 0.1666667 0.14285714 0\n"
            + "0.3333333 0.2500000 0.2000000 0.1666667 0.1428571 0.12500000 0\n"
            + "0.2500000 0.2000000 0.1666667 0.1428571 0.1250000 0.11111111 0\n"
            + "0.2000000 0.1666667 0.1428571 0.1250000 0.1111111 0.10000000 0\n"
            + "0.1666667 0.1428571 0.1250000 0.1111111 0.1000000 0.09090909 0",
            tempDir.resolve("TC2.txt").toString()
        );

        Parser.stringToFile(
            "0 1 2\n"
            + "2 -2.01 33.2\n"
            + "-0.2 0.00 1.2\n",
            tempDir.resolve("TC3.txt").toString()
        );

        Parser.stringToFile(
            "09.99 21.22",
            tempDir.resolve("TC4.txt").toString()
        );
    }

    /**
     * Test of fileToMatrix method, of class Parser.
     *
     * @throws java.io.IOException
     */
    @Test
    @Order(2)
    public void testFileToMatrix() throws IOException {
        System.out.println("fileToMatrix");

        File tc = tempDir.resolve("TC1.txt").toFile();
        assertArrayEquals(new double[][]{
            {1, -1, 2, -1, -1},
            {2, 1, -2, -2, -2},
            {-1, 2, -4, 1, 1},
            {3, 0, 0, -3, -3}
        }, Parser.fileToMatrix(tc).getData());

        tc = tempDir.resolve("TC2.txt").toFile();
        assertArrayEquals(new double[][]{
            {1.0000000, 0.5000000, 0.3333333, 0.2500000, 0.2000000, 0.16666667, 1},
            {0.5000000, 0.3333333, 0.2500000, 0.2000000, 0.1666667, 0.14285714, 0},
            {0.3333333, 0.2500000, 0.2000000, 0.1666667, 0.1428571, 0.12500000, 0},
            {0.2500000, 0.2000000, 0.1666667, 0.1428571, 0.1250000, 0.11111111, 0},
            {0.2000000, 0.1666667, 0.1428571, 0.1250000, 0.1111111, 0.10000000, 0},
            {0.1666667, 0.1428571, 0.1250000, 0.1111111, 0.1000000, 0.09090909, 0}
        }, Parser.fileToMatrix(tc).getData());

        tc = tempDir.resolve("TC3.txt").toFile();
        assertArrayEquals(new double[][]{
            {0, 1, 2},
            {2, -2.01, 33.2},
            {-0.2, 0.00, 1.2}
        }, Parser.fileToMatrix(tc).getData());

        tc = tempDir.resolve("TC4.txt").toFile();
        assertArrayEquals(new double[][]{
            {9.99, 21.22}
        }, Parser.fileToMatrix(tc).getData());

        // Cleanup
        Files.walk(tempDir)
            .sorted(Comparator.reverseOrder())
            .map(Path::toFile)
            .forEach(File::delete);

        // Assert FileNotFound
        assertThrows(NumberFormatException.class, () -> {
            Parser.fileToMatrix(tempDir.toFile());
        });
    }

    /**
     * Test of coefRegressionToString method, of class Parser.
     */
    @Test
    public void testCoefRegressionToString() {
        System.out.println("coefRegressionToString");
        assertEquals(
            "y =\n"
            + "1.0\n"
            + "+1.0 x1\n"
            + "+2.0 x2\n"
            + "+3.0 x3\n"
            + "+4.0 x4\n",
            Parser.coefRegressionToString(
                new double[]{1, 2, 3, 4},
                1.0,
                Util.Formatting.DEFAULT
            )
        );
        assertEquals(
            "y =\n"
            + "1\n"
            + "+2 x1\n"
            + "+3 x2\n",
            Parser.coefRegressionToString(
                new double[]{2, 3},
                1.0,
                Util.Formatting.SHORT
            )
        );
    }

    /**
     * Test of stringToDoubleArray method, of class Parser.
     */
    @Test
    public void testStringToDoubleArray() {
        System.out.println("stringToDoubleArray");
        assertArrayEquals(
            new double[]{1, 2, 3, 4, 5},
            Parser.stringToDoubleArray("1 2 3 4 5")
        );
        assertArrayEquals(
            new double[]{},
            Parser.stringToDoubleArray("  ")
        );
        assertThrows(
            NumberFormatException.class,
            () -> {
                Parser.stringToDoubleArray("");
            }
        );
        assertArrayEquals(
            new double[]{420.69},
            Parser.stringToDoubleArray("420.69")
        );
    }
}
