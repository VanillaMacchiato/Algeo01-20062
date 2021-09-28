package alingeo.matriks;

import java.util.Locale;

/**
 * @author Amar Fadil
 * @author Vito Ghifari
 * @author Rifqi Naufal Abdjul
 */
public class Matrix {

    public enum TriangularType {
        None,
        Upper,
        Lower,
        Diagonal
    }

    private int nCol, nRow;
    private double[][] data;

    // KONSTRUKTOR
    public Matrix(double[][] nData) {
        this.setData(nData);
    }

    public Matrix(int nRow, int nCol) {
        this.nCol = nCol;
        this.nRow = nRow;
        this.data = new double[nRow][nCol];
    }

    // SELEKTOR
    public int getNCol() {
        return this.nCol;
    }

    public int getNRow() {
        return this.nRow;
    }

    public void setNCol(int nCol) {
        this.resize(this.nRow, nCol);
    }

    public void setNRow(int nRow) {
        this.resize(nRow, this.nCol);
    }

    public void resize(int nRow, int nCol) {
        double[][] newData = new double[nRow][nCol];
        int imin = nRow < this.nRow ? nRow : this.nRow;
        int jmin = nCol < this.nCol ? nCol : this.nCol;
        int i, j;
        for (i = 0; i < imin; i++) {
            for (j = 0; j < jmin; j++) {
                newData[i][j] = this.data[i][j];
            }
        }
        this.nRow = nRow;
        this.nCol = nCol;
        this.data = newData;
    }

    public double getElmt(int row, int col) {
        return this.data[row][col];
    }

    public void setElmt(int row, int col, double val) {
        this.data[row][col] = val;
    }

    public double[][] getData() {
        return this.data;
    }

    public final void setData(double[][] nData) {
        this.nRow = nData.length;
        this.nCol = nData.length > 0 ? nData[0].length : 0;
        this.data = nData;
    }

    public double[] getRow(int row) {
        return this.data[row];
    }

    public void setRow(int row, double[] data) {
        this.data[row] = data;
    }

    // PREDIKAT
    public boolean isSquare() {
        return (this.nCol == this.nRow);
    }

    public boolean isIdentity() {
        int i, j;
        for (i = 0; i < this.nRow; i++) {
            for (j = 0; j < this.nCol; j++) {
                if (i == j && this.getElmt(i, j) != 1) {
                    return false;
                } else if (i != j && this.getElmt(i, j) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isEchelon() {
        System.out.println(this);
        int i, j;
        int maxcol = -1;
        for (i = 0; i < this.nRow; i++) {
            for (j = 0; j < this.nCol; j++) {
                if (this.getElmt(i, j) == 1) {
                    if (j > maxcol) {
                        maxcol = j;
                        break;
                    } else {
                        return false;
                    }
                } else if ((this.getElmt(i, j) != 0) && (this.getElmt(i, j) != 1)) {
                    return false;
                } else if ((this.getElmt(i, j) == 0) && (j == this.getNCol() - 1)) {
                    maxcol = this.getNCol() - 1;
                }
            }
        }
        return true;
    }

    public boolean isEchelonReduced() {
        int i, j, k;
        if (!this.isEchelon()) {
            return false;
        }
        for (i = 0; i < this.nRow; i++) {
            for (j = 0; j < this.nCol; j++) {
                if (this.getElmt(i, j) != 0) {
                    if (this.getElmt(i, j) == 1) {
                        for (k = 0; k < i; k++) {
                            if (this.getElmt(k, j) != 0) {
                                return false;
                            }
                        }
                        break;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public TriangularType isTriangular() {
        int i, j;
        boolean lower = false, upper = false;
        if (this.isSquare()) {
            lower = true;
            upper = true;
            lowerloop:
            {
                i = 1;
                while (i < this.nRow && lower) {
                    j = 0;
                    while (j < i && lower) {
                        if (this.getElmt(i, j) != 0) {
                            lower = false;
                        }
                        j++;
                    }
                    i++;
                }
            }
            upperloop:
            {
                i = 0;
                while (i < this.nRow && upper) {
                    j = i + 1;
                    while (j < this.nCol && upper) {
                        if (this.getElmt(i, j) != 0) {
                            upper = false;
                        }
                        j++;
                    }
                    i++;
                }
            }
        }
        if (upper && lower) {
            return TriangularType.Diagonal;
        } else if (upper) {
            return TriangularType.Upper;
        } else if (lower) {
            return TriangularType.Lower;
        } else {
            return TriangularType.None;
        }
    }

    // OPERASI
    public void add(Matrix m) {
        //Prekondisi: ukuran objek dan m sama
        int i, j;
        for (i = 0; i < this.nRow; i++) {
            for (j = 0; j < this.nCol; j++) {
                this.setElmt(i, j, this.getElmt(i, j) + m.getElmt(i, j));
            }
        }
    }

    public void sub(Matrix m) {
        //Prekondisi: ukuran objek dan m sama
        int i, j;
        for (i = 0; i < this.nRow; i++) {
            for (j = 0; j < this.nCol; j++) {
                this.setElmt(i, j, this.getElmt(i, j) - m.getElmt(i, j));
            }
        }
    }

    public void mul(Matrix m2) {
        //Prekondisi: ukuran kolom objek dan baris m2 sama
        Matrix m;
        int i, j, k;
        double sum;
        m = new Matrix(this.getNRow(), m2.getNCol());
        for (i = 0; i < m.getNRow(); i++) {
            for (j = 0; j < m.getNCol(); j++) {
                sum = 0;
                for (k = 0; k < m2.getNRow(); k++) {
                    sum += this.getElmt(i, k) * m2.getElmt(k, j);
                }
                m.setElmt(i, j, sum);
            }
        }
        this.setData(m.getData());
    }

    public void transpose() {
        int i, j;
        Matrix m;
        m = new Matrix(this.getNCol(), this.getNRow());
        for (i = 0; i < this.getNRow(); i++) {
            for (j = 0; j < this.getNCol(); j++) {
                m.setElmt(j, i, this.getElmt(i, j));
            }
        }
        this.setData(m.getData());
    }

    // OBE
    public void RowSum(int row1, int row2, double k) {
        int i;
        for (i = 0; i < this.getNCol(); i++) {
            this.setElmt(row1, i, this.getElmt(row1, i) + k * this.getElmt(row2, i));
        }
    }

    public void RowSwap(int row1, int row2) {
        double[] temp;
        temp = this.getRow(row1);
        this.setRow(row1, this.getRow(row2));
        this.setRow(row2, temp);
    }

    public void ScalarRowMultiplication(int row, double k) {
        int i;
        for (i = 0; i < this.getNCol(); i++) {
            this.setElmt(row, i, this.getElmt(row, i) * k);
        }
    }

    // Helper
    /*  Melakukan Forward Elimination dengan metode Gauss atau Gauss-Jordan.
        Metode Gauss akan menghasilkan Echelon Form,
        sedangkan Gauss-Jordan menghasilkan Reduced Echelon Form. */
    public double toEchelonFormRatio(boolean reducedForm) {
        int nR, nC, rowMax, rowMin, rowCurrent;
        double ratio, elmtMax, elmtMin;
        double totalRatio = 1;

        // coef mencari jumlah yang variabel tidak diketahui
        nR = this.getNRow();
        nC = this.getNCol();
        rowCurrent = 0;

        // Traversal terhadap kolom untuk mengubah matriks menjadi echelon form
        for (int i = 0; i < (nC - 1); i++) {
            // Cek nilai maksimum pada kolom ke-i.
            // Jika ada nilai yang lebih tinggi, baris akan di swap.
            rowMax = i;
            rowMin = i;

            elmtMax = this.getElmt(rowCurrent, i);
            elmtMin = this.getElmt(rowCurrent, i);
            for (int j = rowCurrent + 1; j < nR; j++) {
                if (this.getElmt(j, i) > elmtMax) {
                    elmtMax = this.getElmt(j, i);
                    rowMax = j;
                }
                if (this.getElmt(j, i) < elmtMin) {
                    elmtMin = this.getElmt(j, i);
                    rowMin = j;
                }
            }

            // Menghindari zero diviteion
            if ((elmtMin == 0.0) && (elmtMax == 0.0)) {
                totalRatio = 0;
                continue;
            }

            // row swap jika elemen kolom ke-i bernilai nol
            if ((this.getElmt(rowCurrent, i) == 0.0) && (elmtMax > 0.0)) {
                this.RowSwap(rowCurrent, rowMax);
                totalRatio *= -1;
            } else if ((this.getElmt(rowCurrent, i) == 0.0) && (elmtMin < 0.0)) {
                this.RowSwap(rowCurrent, rowMin);
                totalRatio *= -1;
            }

            // Membuat satu utama pada row ke-rowCurrent
            totalRatio *= this.getElmt(rowCurrent, i);
            this.ScalarRowMultiplication(rowCurrent, 1.0 / this.getElmt(rowCurrent, i));

            // Membuat Row Echelon Form
            for (int j = rowCurrent + 1; j < nR; j++) {
                if (this.getElmt(j, i) != 0.0) {
                    ratio = this.getElmt(j, i) / this.getElmt(rowCurrent, i);
                    this.RowSum(j, rowCurrent, -ratio);
                }
            }

            // Membuat Reduced Row Echelon Form
            if (reducedForm) {
                for (int j = 0; j < (rowCurrent); j++) {
                    if (this.getElmt(j, i) != 0.0) {
                        ratio = this.getElmt(j, i) / this.getElmt(rowCurrent, i);
                        this.RowSum(j, rowCurrent, -ratio);
                    }
                }
            }

            // Jika operasi berhasil, row count akan bertambah
            rowCurrent++;
            if (rowCurrent == nR) {
                break;
            }
        }
        return totalRatio;
    }

    public void toEchelonForm(boolean reducedForm) {
        this.toEchelonFormRatio(reducedForm);
    }

    public Matrix getMinorMatrix(int row, int col) {
        // Prekondisi: Matriks adalah matriks persegi
        int k, l, im, jm;
        int n = this.getNRow();
        Matrix temp = new Matrix(n - 1, n - 1);
        im = 0;
        for (k = 0; k < n - 1; k++) {
            if (im == row) {
                im++;
            }
            jm = 0;
            for (l = 0; l < n - 1; l++) {
                if (jm == col) {
                    jm++;
                }
                temp.setElmt(k, l, this.getElmt(im, jm));
                jm++;
            }
            im++;
        }
        return temp;
    }

    public Matrix copy(int sRow, int lRow, int sCol, int lCol) {
        // Prekondisi: sRow < lRow <= NRow-sRow; sCol < lCol <= NCol - sRow;
        Matrix res = new Matrix(lRow, lCol);
        int i, j;
        for (i = 0; i < lRow; i++) {
            for (j = 0; j < lCol; j++) {
                res.setElmt(i, j, this.getElmt(i + sRow, j + sCol));
            }
        }
        return res;
    }

    public Matrix copy(int lRow, int lCol) {
        // Prekondisi: row <= NRow dan col <= NCol
        return this.copy(0, lRow, 0, lCol);
    }

    public Matrix copy() {
        return this.copy(this.nRow, this.nCol);
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < this.getNRow(); i++) {
            for (int j = 0; j < this.getNCol(); j++) {
                output += String.format(Locale.ROOT, "%.2f", ((double) Math.round(100 * this.getElmt(i, j))) / 100);
                if (j < this.getNCol() - 1) {
                    output += " ";
                }
            }
            if (i < this.getNRow() - 1) {
                output += "\n";
            }
        }
        return output;
    }

    // Static
    public static Matrix plus(Matrix m1, Matrix m2) {
        //Prekondisi: ukuran m1 dan m2 sama
        Matrix m = m1.copy();
        m.add(m2);
        return m;
    }

    public static Matrix min(Matrix m1, Matrix m2) {
        //Prekondisi: ukuran m1 dan m2 sama
        Matrix m = m1.copy();
        m.mul(m2);
        return m;
    }

    public static Matrix mul(Matrix m1, Matrix m2) {
        //Prekondisi: ukuran kolom m1 dan baris m2 sama
        Matrix m = m1.copy();
        m.mul(m2);
        return m;
    }

    public static Matrix toEchelonForm(Matrix m, boolean reducedForm) {
        Matrix res = m.copy();
        res.toEchelonForm(reducedForm);
        return res;
    }

    public static double toEchelonFormRatio(Matrix m, Matrix out, boolean reducedForm) {
        Matrix res = m.copy();
        double rat = res.toEchelonFormRatio(reducedForm);
        out.setData(res.getData());
        return rat;
    }
}
