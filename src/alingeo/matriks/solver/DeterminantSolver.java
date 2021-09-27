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

    private Matrix EROMatrix;

    public Matrix getEROMatrix() {
        return this.EROMatrix;
    }

    public double CofactorExpansion(Matrix M) {
        //prekondisi: M matriks persegi dan ukuran >= 2x2
        double tempsum = 0;

        if (M.getNRow() == 2 && M.getNCol() == 2) {
            return ((M.getElmt(0, 0) * M.getElmt(1, 1)) - (M.getElmt(0, 1) * M.getElmt(1, 0)));
        } else {
            for (int i = 0; i < M.getNCol(); i++) {
                if (M.getElmt(0, i) != 0) {
                    if (i % 2 == 0) {
                        tempsum += M.getElmt(0, i) * this.CofactorExpansion(M.getMinorMatrix(0, i));
                    } else {
                        tempsum -= M.getElmt(0, i) * this.CofactorExpansion(M.getMinorMatrix(0, i));
                    }
                }
            }
        }
        return tempsum;
    }

    public double ERO(Matrix M) {
        //Prekondisi: M matriks persegi
        double ratio = M.toEchelonFormRatio(false);
        this.EROMatrix = M;
        System.out.println(M.toString());
        double res = 1;
        for (int i = 0; i < M.getNCol(); i++) {
            res *= M.getElmt(i, i);
        }
        res *= ratio;
        return res;
    }
}
