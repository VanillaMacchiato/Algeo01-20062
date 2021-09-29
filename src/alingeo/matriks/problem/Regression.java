/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alingeo.matriks.problem;

import alingeo.matriks.Matrix;
import alingeo.matriks.solver.SPLSolver;
import alingeo.matriks.solver.SPLSolver.SolutionResult;
import alingeo.matriks.solver.SPLSolver.SolutionResult.SolutionType;

/**
 *
 * @author vitos
 */
public class Regression {
    
    private double intercept;
    private double[] coef;
    private boolean hasSolution;
    
    public Regression(){
        this.intercept = 0;
        this.coef = null;
        this.hasSolution = false;
    }
    
    public double getIntercept(){
        return this.intercept;
    }
    
    public double[] getCoef(){
        return this.coef;
    }
    
    public boolean hasSolution(){
        return this.hasSolution;
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
        Akan dihitung: ((A^T)*A)^-1) = y untuk mendapatkan b
        */
        Matrix matA, matAT, matATCpy, matY, matB;
        
        matY = new Matrix(m.getNRow(), 1);
        
        matA = m.copy();
        matAT = Matrix.transpose(matA);
        
        // matY sebagai RHS
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
        matATCpy = matAT.copy();
        matA = Matrix.transpose(matAT);
        
        // matAT dan matA sebagai LHS
        matAT.mul(matA);
        
        // matATCpy sebagai RHS
        matATCpy.mul(matY);
        
        matB = matAT.copy();
        matB.setNCol(matB.getNCol()+1);
        
        for (int i=0; i < matB.getNRow(); i++){
            matB.setElmt(i, matB.getNCol()-1, matATCpy.getElmt(i, 0));
        }
        SolutionResult result = SPLSolver.gaussJordanMethod(matB);
        if (result.getType() == SolutionType.UNIQUE){
            this.hasSolution = true;
            
            Matrix res = result.getResult();
            this.intercept = res.getElmt(0, 0);
            this.coef = new double[res.getNRow()-1];
            for (int i = 1; i < res.getNRow(); i++){
                this.coef[i-1] = res.getElmt(i, 0);
            }
        }
        
    }
    
    public double predict(double[] x){
        if ((!this.hasSolution) || (x.length != this.coef.length)){
            return Double.NaN;
        }
        double y_hat = 0;
        y_hat += this.intercept;
        
        for (int i = 0; i < x.length; i++){
            y_hat += this.coef[i] * x[i];
        }
        
        return y_hat;
    }
}
