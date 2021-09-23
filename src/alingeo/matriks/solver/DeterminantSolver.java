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

    public static float CofactorExpansion(Matrix M) {
        //prekondisi: M matriks persegi dan ukuran >= 2x2
        int i, j, k, x, y;
        float tempsum;
        Matrix tempm = new Matrix(M.getNRow() - 1, M.getNCol() - 1);
        if (M.getNCol() == 2 && M.getNRow() == 2) {
            return (M.getElmt(0, 0) * M.getElmt(1, 1) - M.getElmt(0, 1) * M.getElmt(1, 0));
        } else {
            tempsum = 0;
            for (i = 0; i < M.getNCol(); i++) {
                if (M.getElmt(0, i) != 0) {
                    y = 0;
                    for (j = 0; j < M.getNRow(); j++) {
                        x = 0;
                        for (k = 0; k < M.getNCol(); k++) {
                            if (k != i) {
                                tempm.setElmt(y, x, M.getElmt(j, k));
                                x++;
                            }
                        }
                        if (j != 0) {
                            y++;
                        }
                    }
                    if (i % 2 == 0) {
                        tempsum += M.getElmt(0, 1) * CofactorExpansion(tempm);
                    } else {
                        tempsum -= M.getElmt(0, 1) * CofactorExpansion(tempm);
                    }
                }
            }
            return tempsum;
        }
    }

    public static float ERO(Matrix M) {
        //Prekondisi: M matriks persegi
        for (int i = 0; i < M.getNRow(); i++) {
            for (int j = i; j < M.getNRow(); j++) {
                M.RowSum(j, i, (-1) * M.getElmt(j, j) / M.getElmt(i, i));
            }
        }
        float sum = 0;
        for (int i = 0; i < M.getNRow(); i++) {
            sum += M.getElmt(i, i);
        }
        return sum;
    }
}
