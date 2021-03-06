/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alingeo.matriks.solver;

import alingeo.matriks.Matrix;
import alingeo.matriks.Util;

/**
 * Inverse Solver
 *
 * @author Amar Fadil
 */
public class InversSolver {

    // Helper
    public static Matrix CofactorMatrix(Matrix m) {
        // Prekondisi: m merupakan matriks persegi
        int i, j;
        int n = m.getNRow();
        Matrix res = new Matrix(n, n);
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                // Set elemen minor entri ij
                // Set elemen jadi nilai kofaktor ij
                res.setElmt(i, j,
                    ((i + j) % 2 == 1 ? -1 : 1)
                    * DeterminantSolver.CofactorExpansion(
                        m.getMinorMatrix(i, j)
                    )
                );
            }
        }
        return res;
    }

    public static Matrix GaussJordanMethod(Matrix m) {
        return GaussJordanMethod(m, null);
    }

    public static Matrix GaussJordanMethod(Matrix m, Matrix echelonOut) {
        // Prekondisi: m merupakan matriks persegi
        int i;
        int n = m.getNCol();
        Matrix temp = m.copy();
        // Resize and fill up the diagonals with 1
        temp.setNCol(n * 2);
        for (i = n; i < n * 2; i++) {
            temp.setElmt(i - n, i, 1);
        }
        // Get the reduced echelon form
        temp.toEchelonForm(true);
        if (echelonOut != null) {
            echelonOut.setData(temp.getData());
        }
        // Make sure that the 1nd col matrix ([0..n][0..n]) is identity
        if (!temp.copy(n, n).isIdentity()) {
            return null;
        }
        // Result by the 2nd col matrix ([0..n][n..n*2])
        // copy at first row with length n and at n col with length n
        return temp.copy(0, n, n, n);
    }

    public static Matrix AdjointMethod(Matrix m) {
        return AdjointMethod(m, null);
    }

    public static Matrix AdjointMethod(Matrix m, Matrix cofactorOut) {
        // Prekondisi: m adalah matriks persegi
        int i, j;
        double det = DeterminantSolver.ERO(m);
        if (Util.isAlmostEq(det, 0)) {
            return null; // Invers tidak terdefinisi.
        }
        Matrix res = CofactorMatrix(m);
        if (cofactorOut != null) {
            cofactorOut.setData(res.getData());
        }
        int len = m.getNRow();
        res.transpose(); // adj = cfc^T
        for (i = 0; i < len; i++) {
            for (j = 0; j < len; j++) {
                res.setElmt(i, j, res.getElmt(i, j) / det);
            }
        }
        return res;
    }
}
