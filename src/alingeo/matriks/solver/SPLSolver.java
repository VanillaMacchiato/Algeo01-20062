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

        backwardSubstitution(m, result);

        return result;
    }

    public static Matrix gaussJordanMethod(Matrix m) {
        int status;
        Matrix result = new Matrix(m.getNRow(), m.getNCol());

        backwardSubstitution(m, result);

        return result;
    }

    /* Mendapatkan hasil X dari matriks REF atau RREF */
    public static void backwardSubstitution(Matrix m, Matrix result) {
        // Dependency matrix
        Matrix depMat = m.copy();
        depMat.setNRow(m.getNCol()-1);
        
        int nRow = depMat.getNRow();
        int nCol = depMat.getNCol();
        
        // Iterasi baris untuk mendapatkan 1 utama di kolom ke-n menjadi
        // 1 utama di baris n dan kolom n
        int col = 0;
        for (int i=(nRow-1);i>=0;i--){
            for (int j=i-1;j>=0;j--){
                col = 0;
                while ((depMat.getElmt(j, col) != 1.0) && (col < (nCol-1))){
                    col++;
                }
                
                if (col == i){
                    depMat.RowSwap(i, j);
                    break;
                }
            }
        }
        
        for (int i=(nRow-2);i>=0;i--){
            for (int j=(nRow-1);j>i;j--){
                if (depMat.getElmt(i, j) != 0.0){
                    depMat.RowSum(i, j, -1.0*depMat.getElmt(i, j));
                }
            }
        }
        result = depMat;
    }
}
