package alingeo.matriks.io;

import alingeo.matriks.Matrix;

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

    public static String matrixToString(Matrix M) {
        String output = "";
        for (int i = 0; i < M.getNRow(); i++) {
            for (int j = 0; j < M.getNCol(); j++) {
                output += String.format("%.2f", M.getElmt(i, j));
                if (j < M.getNCol() - 1) {
                    output += " ";
                }
            }
            if (i < M.getNRow() - 1) {
                output += "\n";
            }
        }
        return output;
    }
}
