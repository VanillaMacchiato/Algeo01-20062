package alingeo.matriks.io;

import alingeo.matriks.Matrix;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rifqi
 */
public class Parser {

    public static Matrix stringToMatrix(String inp) {
        String[] inpline = inp.split("\n");
        double[][] dataMatrix = new double[inpline.length][inpline[0].split(" ").length];
        for (int i = 0; i < inpline.length; i++) {
            String[] tempData = inpline[i].split(" ");
            for (int j = 0; j < tempData.length; j++) {
                dataMatrix[i][j] = Double.parseDouble(tempData[j]);
            }

        }
        Matrix output = new Matrix(dataMatrix.length, dataMatrix[0].length);
        output.setData(dataMatrix);
        return output;

    }

    public static Matrix fileToMatrix(File inp) {
        String txt = "";
        try {
            Scanner scanner = new Scanner(inp);
            while (scanner.hasNextLine()) {
                txt += scanner.nextLine() + "\n";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stringToMatrix(txt);
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void stringToFile(String inp, String dir) {
        try {
            PrintWriter writer = new PrintWriter(dir);
            String[] inplines = inp.split("\n");
            for (String inpline : inplines) {
                writer.println(inpline);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
