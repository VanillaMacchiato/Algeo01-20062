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

    // Standard Return Object
    // Let N = how many variables there are, then:
    // 1. Solver methods returns SolutionResult that consist of both:
    //      -> int[] states, and
    //      -> Matrix result
    // *  If constructed without states, it assumes that Matrix result is
    //    a constant matrix with size (N,1) and creates new int[] states
    //    with all values set to -1.
    // *  If constructed without params, it assumes there's no solution
    //    exists within given problem (inconsistent system).
    // 2. Solver methods may return null if given problem doesn't
    //    supported by chosen method.
    // 2. int[] states represent N variable state, it can be either:
    //      -> -1 - A constant or parametric, or
    //      -> 0..N - A variable for parametric
    // 3. Matrix result should be either:
    //      -> Dependency matrix with size (N+1, N), or
    //      -> Constant matrix with size (N, 1)
    // 4. To generate the solution as human-readable string, use toString
    //    within SolutionResult object.
    public static final class SolutionResult {

        public enum SolutionType {
            NOT_SUPPORTED,
            INCONSISTENT,
            INFINITE,
            UNIQUE
        }

        private final Matrix result;
        private final int[] states;
        private final SolutionType type;
        private final String reason;

        public SolutionResult(String reason) {
            this.result = null;
            this.states = null;
            this.reason = reason;
            this.type = SolutionType.NOT_SUPPORTED;
        }

        public SolutionResult(Matrix result) {
            this.reason = null;
            if (result == null) {
                this.result = null;
                this.states = null;
                this.type = SolutionType.INCONSISTENT;
            } else {
                this.result = result;
                this.states = new int[result.getNRow()];
                for (int i = 0; i < this.states.length; i++) {
                    this.states[i] = -1;
                }
                this.type = SolutionType.UNIQUE;
            }
        }

        public SolutionResult(int[] states, Matrix result) {
            this.reason = null;
            this.states = states;
            boolean isUnique = true;
            for (int i = 0; i < states.length; i++) {
                if (states[i] > -1) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                this.type = SolutionType.UNIQUE;
                // Compress result
                this.result = result.copy(
                    0, result.getNRow(),
                    result.getNCol() - 1, 1
                );
            } else {
                this.type = SolutionType.INFINITE;
                this.result = result;
            }
        }

        static String generateVarString(int num) {
            int n = num / 26;
            String res = Character.toString(((int) 'a' + (num % 26)));
            if (n > 0) {
                res += Integer.toString(n);
            }
            return res;
        }

        @Override
        public String toString() {
            if (this.getType() == SolutionType.INCONSISTENT) {
                return "Solusi tidak ada. SPL tidak konsisten.";
            } else if (this.getType() == SolutionType.NOT_SUPPORTED) {
                return "SPL tidak dapat diselesaikan oleh metode ini.\nAlasan: " + this.reason;
            }
            int cnt, i, j;
            double el;
            String res = "";
            for (i = 0; i < this.getStates().length; i++) {
                res += "x" + (i + 1) + " = ";
                if (this.getStates()[i] == -1) {
                    if (this.getType() == SolutionType.UNIQUE) {
                        res += this.getResult().getElmt(i, 0);
                    } else {
                        cnt = 0;
                        for (j = i + 1; j <= this.getStates().length; j++) {
                            el = this.getResult().getElmt(i, j);
                            if (el != 0) {
                                if (cnt != 0) {
                                    if (el > 0) {
                                        res += " + ";
                                    } else {
                                        res += " - ";
                                        el *= -1;
                                    }
                                } else if (el == -1.0) {
                                    res += "-";
                                    el *= -1;
                                }
                                if (el != 1.0 || j == this.getStates().length) {
                                    res += el;
                                }
                                if (j < this.getStates().length) {
                                    res += generateVarString(this.getStates()[j]);
                                }
                                cnt++;
                            }
                        }
                    }
                } else {
                    res += generateVarString(this.getStates()[i]);
                }
                res += "\n";
            }
            return res;
        }

        /**
         * @return the result
         */
        public Matrix getResult() {
            return result;
        }

        /**
         * @return the states
         */
        public int[] getStates() {
            return states;
        }

        /**
         * @return the type
         */
        public SolutionType getType() {
            return type;
        }
    }

    /* Mencari solusi pada matriks m dengan menggunakan metode Gauss  */
    public static SolutionResult gaussMethod(Matrix m) {
        return backwardSubstitution(Matrix.toEchelonForm(m, false));
    }

    public static SolutionResult gaussJordanMethod(Matrix m) {
        return backwardSubstitution(Matrix.toEchelonForm(m, true));
    }

    public static SolutionResult inverseMethod(Matrix m) {
        if (m.getNRow() != m.getNCol() - 1) {
            return new SolutionResult("Matriks koefisien bukan persegi.");
        }
        int mRow = m.getNRow();
        Matrix inv = InversSolver.GaussJordanMethod(
            m.copy(mRow, mRow)
        );
        if (inv == null) {
            return new SolutionResult("Invers/balikan tidak ditemukan.");
        }
        inv.mul(m.copy(0, mRow, m.getNCol() - 1, 1));
        return new SolutionResult(inv);
    }

    public static SolutionResult crammerMethod(Matrix m) {
        if (m.getNRow() != m.getNCol() - 1) {
            return new SolutionResult("Matriks koefisien bukan persegi.");
        }
        int mRow = m.getNRow();
        Matrix A = m.copy(mRow, mRow);
        double detA = DeterminantSolver.ERO(A);
        if (detA == 0.0) {
            return new SolutionResult("Determinan matriks koefisien = 0.");
        }
        Matrix res = new Matrix(mRow, 1);
        for (int i = 0; i < mRow; i++) {
            Matrix tt = A.copy();
            for (int j = 0; j < mRow; j++) {
                tt.setElmt(j, i, m.getElmt(j, mRow));
            }
            res.setElmt(i, 0, DeterminantSolver.ERO(tt) / detA);
        }
        return new SolutionResult(res);
    }

    /* Mendapatkan hasil X dari matriks REF atau RREF */
    public static SolutionResult backwardSubstitution(Matrix m) {
        // Dependency matrix
        Matrix depMat = m.copy();
        depMat.setNRow(m.getNCol() - 1);
        int i, j;

        // First vibe check: case where equation > variable
        // depMat only cut until m.getNCol()-1
        // so we loop the rest (m.getNCol() - 1 ~ m.getNRow())
        // precond: the row's should have 0 for j < m.getNCol()-1
        // if there's a row with j=m.getNCol()-1 that does not 0, the system
        // is inconsistent
        for (i = m.getNCol() - 1; i < m.getNRow(); i++) {
            if (m.getElmt(i, m.getNCol() - 1) != 0) {
                return new SolutionResult((Matrix) null);
            }
        }

        int nRow = depMat.getNRow();
        int nCol = depMat.getNCol();
        int[] states = new int[nRow];

        // Iterasi baris untuk mendapatkan 1 utama di kolom ke-n menjadi
        // 1 utama di baris n dan kolom n
        int col;
        for (i = (nRow - 1); i >= 0; i--) {
            for (j = i - 1; j >= 0; j--) {
                col = 0;
                while ((depMat.getElmt(j, col) != 1.0) && (col < (nCol - 1))) {
                    col++;
                }

                if (col == i) {
                    depMat.RowSwap(i, j);
                    break;
                }
            }
        }

        double el;
        for (i = (nRow - 1); i >= 0; i--) {
            if (depMat.getElmt(i, i) == 0.0) {
                // if constant does not 0, it shouldn't have a solution
                if (depMat.getElmt(i, nRow) != 0.0) {
                    return new SolutionResult((Matrix) null);
                }
            } else {
                // turn on the state
                states[i] = -1; // means it has a value (parametric or constant)
                // it's not parametric, clear the dependency up.
                // parametric or constant may not be 0, otherwise should be 0
                for (j = (nRow - 1); j > i; j--) {
                    el = depMat.getElmt(i, j);
                    if (el != 0) {
                        if (states[j] == 0) { // parametric, turn it negative
                            depMat.setElmt(i, j, el * -1);
                        } else { // value, rowsum negative them all
                            depMat.RowSum(i, j, el * -1);
                        }
                    }
                }
            }
        }
        // dependency cleared up, set as result
        Matrix result = new Matrix(0, 0);
        result.setData(depMat.getData());

        // turn states into corresponding parametric `val` if applicable
        // where x.toString() = chr(ord('a')+(x%27)) + str(x/27)
        int cnt = 0;
        for (i = 0; i < nRow; i++) {
            if (states[i] == 0) {
                states[i] = (cnt++);
            }
        }
        return new SolutionResult(states, result);
    }
}
