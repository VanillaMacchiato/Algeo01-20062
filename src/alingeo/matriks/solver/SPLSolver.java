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

        backwardSubstitution(Matrix.toEchelonForm(m, false), result);

        return result;
    }

    public static Matrix gaussJordanMethod(Matrix m) {
        int status;
        Matrix result = new Matrix(m.getNRow(), m.getNCol());

        backwardSubstitution(Matrix.toEchelonForm(m, true), result);

        return result;
    }

    /* Mendapatkan hasil X dari matriks REF atau RREF */
    public static int[] backwardSubstitution(Matrix m, Matrix result) {
        // Dependency matrix
        Matrix depMat = m.copy();
        depMat.setNRow(m.getNCol() - 1);
        int i, j;

        int nRow = depMat.getNRow();
        int nCol = depMat.getNCol();
        int[] states = new int[nRow];

        // Iterasi baris untuk mendapatkan 1 utama di kolom ke-n menjadi
        // 1 utama di baris n dan kolom n
        int col = 0;
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
                    return null;
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
        result.setData(depMat.getData());

        // turn states into corresponding parametric `val` if applicable
        // where x.toString() = chr(ord('a')+(x%27)) + str(x/27)
        int cnt = 0;
        for (i = 0; i < nRow; i++) {
            if (states[i] == 0) {
                states[i] = (cnt++);
            }
        }
        return states;
    }

    public static String generateVarString(int num) {
        int n = num / 26;
        String res = Character.toString(((int) 'a' + (num % 26)));
        if (n > 0) {
            res += Integer.toString(n);
        }
        return res;
    }

    public static String generateSolution(int[] states, Matrix result) {
        if (states == null) {
            return "No solution exist. The system is inconsistent.";
        }
        int cnt, i, j;
        double el;
        String res = "";
        for (i = 0; i < states.length; i++) {
            res += "x" + (i + 1) + " = ";
            if (states[i] == -1) {
                cnt = 0;
                for (j = i + 1; j <= states.length; j++) {
                    el = result.getElmt(i, j);
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
                        if (el != 1.0 || j == states.length) {
                            res += el;
                        }
                        if (j < states.length) {
                            res += generateVarString(states[j]);
                        }
                        cnt++;
                    }
                }
            } else {
                res += generateVarString(states[i]);
            }
            res += "\n";
        }
        return res;
    }
}
