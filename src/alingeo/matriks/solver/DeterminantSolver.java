/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alingeo.matriks.solver;

import alingeo.matriks.Matrix;

/**
 *
 * @author rifqi
 */
public class DeterminantSolver {

    public static double CofactorExpansion(Matrix M) {
        //prekondisi: M matriks persegi dan ukuran >= 2x2
        double tempsum = 0;

        if (M.getNRow() == 2 && M.getNCol() == 2) {
            return ((M.getElmt(0, 0) * M.getElmt(1, 1)) - (M.getElmt(0, 1) * M.getElmt(1, 0)));
        } else {
            for (int i = 0; i < M.getNCol(); i++) {
                if (M.getElmt(0, i) != 0) {
                    if (i % 2 == 0) {
                        tempsum += M.getElmt(0, i) * CofactorExpansion(M.getMinorMatrix(0, i));
                    } else {
                        tempsum -= M.getElmt(0, i) * CofactorExpansion(M.getMinorMatrix(0, i));
                    }
                }
            }
        }
        return tempsum;
    }

    public static double ERO(Matrix M) {
        Matrix out = null;
        return ERO(M, out);
    }

    public static double ERO(Matrix M, Matrix out) {
        //Prekondisi: M matriks persegi
        double ratio = Matrix.toEchelonFormRatio(M, out, false);
        System.out.println(M.toString());
        double res = 1;
        for (int i = 0; i < M.getNCol(); i++) {
            res *= M.getElmt(i, i);
        }
        res *= ratio;
        return res;
    }
}
