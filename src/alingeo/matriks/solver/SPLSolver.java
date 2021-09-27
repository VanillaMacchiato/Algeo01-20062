/*
 * Copyright (C) 2021 vitos
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alingeo.matriks.solver;

import alingeo.matriks.Matrix;

/**
 *
 * @author Amar Fadil
 * @author Vito Ghifari
 * @author Rifqi Naufal Abdjul
 *
 */
public class SPLSolver {

    /* Mencari solusi pada matriks m dengan menggunakan metode Gauss  */
    public static Matrix gaussMethod(Matrix m) {
        int status;
        Matrix result = new Matrix(m.getNCol(), m.getNCol());

        status = backwardSubstitution(
            Matrix.toEchelonForm(m, false),
            result,
            false
        );

        return result;
    }

    public static Matrix gaussJordanMethod(Matrix m) {
        int status;
        Matrix result = new Matrix(m.getNRow(), m.getNCol());

        status = backwardSubstitution(
            Matrix.toEchelonForm(m, true),
            result,
            true
        );

        return result;
    }

    /* Mendapatkan hasil X dari matriks REF atau RREF */
    public static int backwardSubstitution(Matrix m, Matrix result, boolean useGaussJordan) {
        int nRow = m.getNRow();
        int nCol = m.getNCol();
        int nonZeroCoef = 0;
        boolean zeroRightmost = false;

        // Traversal baris terakhir
        for (int j = 0; j < (nCol - 1); j++) {
            if (m.getElmt(nRow - 1, j) != 0.0) {
                nonZeroCoef += 1;
            }
        }

        // Cek konstanta pada baris dan kolom terakhir
        if ((m.getElmt(nRow - 1, nCol - 1)) == 0.0) {
            zeroRightmost = true;
        }

        // Status -1: Matriks tidak ada solusi
        if ((nonZeroCoef == 0) && (!zeroRightmost)) {
            return -1;
        }

        // Status -2: Matriks mempunyai banyak solusi
        if ((nonZeroCoef == 0) && (zeroRightmost)) {
            // e.g.
            // [ 1 ... ... ... ... ]
            // [ 0  1  ... ... ... ]
            // [ 0  0   0   0   0  ]
            int noOfParam = nCol - nRow;

            result.setNCol(noOfParam + 1);
            result.setNRow(nCol - 1);

            for (int i = 0; i < result.getNRow(); i++) {
                for (int j = 0; j < result.getNCol(); j++) {
                    result.setElmt(i, j, 0);
                }
            }

            // X yang parametrik
            int count = noOfParam;
            for (int j = (nCol - 2); j >= (nCol - noOfParam - 1); j--) {
                result.setElmt(j, count, 1.0);
                count--;
            }
            // X yang tidak parametrik
            result.setElmt(nCol - noOfParam - 2, 0, m.getElmt(nRow - 2, nCol - 1));
            for (int j = 1; j < result.getNCol(); j++) {
                result.setElmt(nCol - noOfParam - 2, j, -1 * m.getElmt(nRow - 2, j + nCol - noOfParam - 2));
            }

            for (int i = nRow - 3; i >= 0; i--) {
                for (int j = 1; j < (result.getNCol()); j++) {
                    result.setElmt(i, j, -m.getElmt(i, nCol - noOfParam - 2 + j));
                }

                result.setElmt(i, 0, m.getElmt(i, nCol - 1));
                for (int j = i + 1; j < (nCol - noOfParam - 1); j++) {
                    result.RowSum(i, j, -m.getElmt(i, j));
                }
            }

            return -2;
        }

        // Cek baris terakhir apakah mempunyai lebih dari 1 variabel x
        if (nonZeroCoef > 1) {
            // e.g.
            // [ 1 ... ... ... ...  ... ]
            // [ 0  1  ... ... ...  ... ]
            // [ 0  0   1  ... ...  ... ]
            int noOfParam = nCol - nRow - 1;

            result.setNCol(noOfParam + 1);
            result.setNRow(nCol - 1);

            for (int i = 0; i < result.getNRow(); i++) {
                for (int j = 0; j < result.getNCol(); j++) {
                    result.setElmt(i, j, 0);
                }
            }

            // X yang parametrik
            int count = noOfParam;
            for (int j = (nCol - 2); j >= (nCol - noOfParam - 1); j--) {
                result.setElmt(j, count, 1.0);
                count--;
            }
            // X yang tidak parametrik
            result.setElmt(nCol - noOfParam - 2, 0, m.getElmt(nRow - 1, nCol - 1));
            for (int j = 1; j < result.getNCol(); j++) {
                result.setElmt(nCol - noOfParam - 2, j, -1 * m.getElmt(nRow - 1, j + nCol - noOfParam - 2));
            }

            for (int i = nRow - 2; i >= 0; i--) {
                for (int j = 1; j < (result.getNCol()); j++) {
                    result.setElmt(i, j, -m.getElmt(i, nCol - noOfParam - 2 + j));
                }

                result.setElmt(i, 0, m.getElmt(i, nCol - 1));
                for (int j = i + 1; j < (nCol - noOfParam - 1); j++) {
                    result.RowSum(i, j, -m.getElmt(i, j));
                }
            }
        } else {
            // Solusi unik dan tidak berparameter
            result.setNCol(1);
            result.setNRow(m.getNRow());

            for (int i = nRow - 1; i >= 0; i--) {
                double tmp_sum = m.getElmt(i, nCol - 1);
                for (int j = i + 1; j < (nCol - 1); j++) {
                    tmp_sum -= m.getElmt(i, j) * result.getElmt(j, 0);
                }
                result.setElmt(i, 0, tmp_sum);
            }

            return 0;
        }

        return -3;
    }
}
