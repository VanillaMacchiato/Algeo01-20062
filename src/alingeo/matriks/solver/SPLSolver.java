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
    public static Matrix gaussMethod(Matrix m){
        int status;
        Matrix result = new Matrix(m.getNCol(), m.getNCol());
        
        forwardElim(m, false);
        status = backwardSubstitution(m, result, false);
        
        return result;
    }
    
    public static Matrix gaussJordanMethod(Matrix m){
        int status;
        Matrix result = new Matrix(m.getNCol(), m.getNCol());
        
        forwardElim(m, true); 
        status = backwardSubstitution(m, result, true);
        
        return result;
    }
    
    /*  Melakukan Forward Elimination dengan metode Gauss atau Gauss-Jordan.
        Metode Gauss akan menghasilkan Echelon Form,
        sedangkan Gauss-Jordan menghasilkan Reduced Echelon Form. */
    public static void forwardElim(Matrix m, boolean useGaussJordan){
        int nRow, nCol, rowMax, rowMin, rowCurrent;
        double ratio, elmtMax, elmtMin;
        
        // coef mencari jumlah yang variabel tidak diketahui
        nRow = m.getNRow();
        nCol = m.getNCol();
        rowCurrent = 0;
        
        // Traversal terhadap kolom untuk mengubah matriks menjadi echelon form
        for (int i=0;i<(nCol-1);i++){
            // Cek nilai maksimum pada kolom ke-i.
            // Jika ada nilai yang lebih tinggi, baris akan di swap.
            rowMax = i;
            rowMin = i;
            
            elmtMax = m.getElmt(rowCurrent, i);
            elmtMin = m.getElmt(rowCurrent, i);
            for (int j=rowCurrent+1;j<nRow;j++){
                if (m.getElmt(j, i) > elmtMax){
                    elmtMax = m.getElmt(j, i);
                    rowMax = j;
                }
                if (m.getElmt(j, i) < elmtMin){
                    elmtMin = m.getElmt(j, i);
                    rowMin = j;
                }
            }
            
            // Menghindari zero diviteion
            if ((elmtMin == 0.0) && (elmtMax == 0.0)){
                continue;
            }
            
            // row swap jika elemen kolom ke-i bernilai nol
            if ((m.getElmt(rowCurrent, i) == 0.0) && (elmtMax > 0.0)){
                m.RowSwap(rowCurrent, rowMax);
            } else if ((m.getElmt(rowCurrent, i) == 0.0) && (elmtMin < 0.0)) {
                m.RowSwap(rowCurrent, rowMin);
            }
            
            // Membuat satu utama pada row ke-rowCurrent
            m.ScalarRowMultiplication(rowCurrent, 1.0f/m.getElmt(rowCurrent, i));
            
            // Membuat Row Echelon Form
            for (int j=rowCurrent+1;j<nRow;j++){
                if (m.getElmt(j, i) != 0.0){
                    ratio = m.getElmt(j, i) / m.getElmt(rowCurrent, i);

                    m.RowSum(j, i, -ratio);
                }
            }
            
            
            // Membuat Reduced Row Echelon Form
            if (useGaussJordan){
                for (int j=0;j<(rowCurrent);j++){
                    if (m.getElmt(j, i) != 0.0){
                        ratio = m.getElmt(j, i) / m.getElmt(rowCurrent, i);

                        m.RowSum(j, i, -ratio);
                }
            }
            }
            
            // Jika operasi berhasil, row count akan bertambah
            rowCurrent++;
            if (rowCurrent == nRow) break;
        }
    }
    
    /* Mendapatkan hasil X dari matriks REF atau RREF */
    public static int backwardSubstitution(Matrix m, Matrix result, boolean useGaussJordan){
//        Matrix solution = new Matrix();
        int nRow = m.getNRow();
        int nCol = m.getNCol();
        int nonZeroCoef = 0;
        boolean zeroRightmost = false;
        
        // Traversal baris terakhir
        for (int j=0; j<(nCol-1); j++){
            if (m.getElmt(nRow-1,j) != 0.0){
                nonZeroCoef += 1;
            }
        }
        
        // Cek konstanta pada baris dan kolom terakhir
        if ((m.getElmt(nRow-1, nCol-1)) == 0.0){
            zeroRightmost = true;
        }
        
        // Status -1: Matriks tidak ada solusi
        if ((nonZeroCoef == 0) && (!zeroRightmost)){
            return -1;
        }
        
        // Status -2: Matriks mempunyai banyak solusi
        if ((nonZeroCoef == 0) && (zeroRightmost)){
//            isParameter
            if (useGaussJordan){
                for (int i=(nRow-2);i>0;i--){
//                    x[i] 
                    for (int j=0;j<nCol;j++){
//                        if ()
                    }
                }
            }
            
            return -2;
        }
        
        // Cek baris terakhir apakah mempunyai lebih dari 1 variabel x
        if (nonZeroCoef > 1){
            // Jika ada, solusi bersifat parametrik
            for (int j=0;j<(nCol-1);j++){
                if (m.getElmt(nRow-1, j) != 0.0){
                    // X ke-j adalah parametrik
                }
            }
            
            // Iterasi baris
            for (int i=nRow-2;i>0;i--){
                //
                if (m.getElmt(i, i) == 0.0){
                    
                }
            }
        } else {
            // Solusi unik dan tidak berparameter
            result.setNCol(1);
            result.setNRow(m.getNRow());

            for (int i=nRow-1;i>=0;i--){
                double tmp_sum = m.getElmt(i, nCol-1);
                for (int j=i+1;j<(nCol-1);j++){
                    tmp_sum -= m.getElmt(i, j) * result.getElmt(j, 0);
                }
                result.setElmt(i, 0, tmp_sum);
            }
            
            return 0;
        }
        
    return -3;
    }
}

