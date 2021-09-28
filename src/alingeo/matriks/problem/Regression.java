/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alingeo.matriks.problem;

import alingeo.matriks.Matrix;

/**
 *
 * @author vitos
 */
public class Regression {
    
    private double intercept;
    private double[] coef;
    private int noCoef;
    
    public Regression(){
        this.intercept = 0;
        this.coef = null;
    }
    
    public double getIntercept(){
        return this.intercept;
    }
    
    public double[] getCoef(){
        return this.coef;
    }
    
    public void fit(Matrix m){
        /* 
        Prekondisi: m > n
        Contoh matriks: 
        [ x11 x21 x31 ... xn1 y1 ]
        [ x12 x22 x32 ... xn2 y2 ]
        [ ... ... ... ... ... .. ]
        [ x1m x2m x3m ... xnm ym ]
        
        A merupakan matriks koefisien dengan kolom 1 diisi dengan angka 1. Contoh:
        [ 1  x11 x21 x31 ... xn1 ]
        [ 1  x12 x22 x32 ... xn2 ]
        [ ... ... ... ... ... .. ]
        [ 1  x1m x2m x3m ... xnm ]
        
        Persamaan Normal: y = A*b
        Akan dihitung: ((A^T)*A)^-1 *(A^T)*y untuk mendapatkan b
        */
        Matrix matA, matAT, matY;
        
        matY = new Matrix(m.getNRow(), 1);
        
        matA = m.copy();
        matAT = Matrix.transpose(matA);
        
        for (int i=0; i < matY.getNRow(); i++){
            matY.setElmt(i, 0, matA.getElmt(i, matA.getNCol()-1));
        }
        
        // set baris terakhir dengan 1 pada transpose
        int nRow = matAT.getNRow();
        for (int j = 0; j < matAT.getNCol(); j++){
            matAT.setElmt(nRow-1, j, 1);
        }
        
        // Swap row
        for (int i = (nRow-1); i > 0; i--){
            matAT.RowSwap(i, i-1);
        }
        
        matA = Matrix.transpose(matAT);
        
//        matAT.mul(matA);
        System.out.println(matA.toString());
        System.out.println();
        System.out.println(matAT.toString());
    }
    
    public void predict(){
        
    }
}
