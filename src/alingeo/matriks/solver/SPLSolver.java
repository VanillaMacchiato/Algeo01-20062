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
    public static void GaussMethod(Matrix m){
        // Belum diimplementasikan:
        // 3 jenis solusi: 
        double x[] = new double[m.getNCol() - 1];
        
        ForwardElimGauss(m);
        BackwardSubstitution(m, x);
        
        for (int i=0; i<m.getNCol()-1; i++){
            System.out.print(x[i] + " ");
        }
        
        
    }
    
    /* Melakukan Forward Elimination dengan metode Gauss */
    public static void ForwardElimGauss(Matrix m){
        int i, j, n_coef, rowMax;
        double ratio, pivotElmt;
        
        // coef mencari jumlah yang variabel tidak diketahui
        n_coef = m.getNRow() - 1;
        
        // Traversal terhadap kolom untuk mengubah matriks menjadi echelon form
        for (i=0;i<n_coef;i++){
            // Cek nilai maksimum pada kolom ke-i.
            // Jika ada nilai yang lebih tinggi, baris akan di swap.
            rowMax = i;
            pivotElmt = m.getElmt(i, i);
            for (j=i+1;j<n_coef;j++){
                if (m.getElmt(j, i) > pivotElmt){
                    pivotElmt = m.getElmt(j, i);
                    rowMax = j;
                }
            }
            
            // Menghindari zero division
            if (pivotElmt == 0.0f){
                continue;
            }
            
            // row swap
            if (i != rowMax){
                m.RowSwap(i, rowMax);
            }
            
            // Pengurang nilai baris di bawahnya dengan rasio
            for (j=i+1;j<n_coef;j++){
                ratio = m.getElmt(j, i) / m.getElmt(i, i);
                
                m.RowSum(j, i, -ratio);
            }
        }
        
        // Membagi row 1 dengan baris paling kiri
        m.ScalarRowMultiplication(0, 1.0f / m.getElmt(0, 0));
    }
    
    /* Mendapatkan hasil X dari matriks REF atau RREF */
    public static double[] BackwardSubstitution(Matrix m, double[] x){
        int N = m.getNCol() - 1;
        boolean zero_coef, zero_rightmost;
        
        zero_rightmost = false;
        zero_coef = true;
        if (m.getElmt(m.getNRow()-1, m.getNCol()-1) == 0){
            zero_rightmost = true;
        }
        // Jika baris paling bawah berisi nol kecuali paling kanan, matriks tidak ada solusi
//        for (int i=0; i<N; i++){
//            if 
//        }
        
        for (int i=N; i>=0; i--){
            // Mendapatkan elemen paling kanan matriks
            x[i] = m.getElmt(i, N+1);
            
            for (int j=i+1; j<N; j++){
                x[i] -= x[j] * m.getElmt(i, j);
            }
            
            x[i] /= m.getElmt(i, N);
        }
        
        return x;
    }
}

