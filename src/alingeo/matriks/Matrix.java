package alingeo.matriks;

/**
 * @author Amar Fadil
 * @author Vito Ghifari
 * @author Rifqi Naufal Abdjul
 */
public class Matrix {

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
        resize(this.nRow, nCol);
    }

    public void setNRow(int nRow) {
        resize(nRow, this.nCol);
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
        this.nCol = this.nRow > 0 ? nData[0].length : 0;
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

    public boolean isEchelon() {
        int i, j;
        for (i = 0; i < this.nRow; i++) {
            for (j = 0; j < this.nCol; j++) {
                if (this.getElmt(i, j) != 0) {
                    if (this.getElmt(i, j) == 1) {
                        break;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isEchelonReduced() {
        int i, j, k;
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

    public int isTriangular() {
        int i, j;
        boolean lower = true, upper = true;
        if (this.isSquare()) {
            lowerloop:
            {
                for (i = 0; i < this.nRow; i++) {
                    for (j = i; j < this.nCol; j++) {
                        if (this.getElmt(i, j) != 0) {
                            return 1;
                        }
                    }
                }
            }
            upperloop:
            {
                for (i = 0; i < this.nRow; i++) {
                    for (j = i; j >= 0; j--) {
                        if (this.getElmt(i, j) != 0) {
                            return 2;
                        }
                    }
                }
            }
        }
        return 0;

    }

    // OPERASI
    public void plus(Matrix m) {
        //Prekondisi: ukuran objek dan m sama
        int i, j;
        for (i = 0; i < this.nRow; i++) {
            for (j = 0; j < this.nCol; j++) {
                this.setElmt(i, j, this.getElmt(i, j) + m.getElmt(i, j));
            }
        }
    }

    public void min(Matrix m) {
        //Prekondisi: ukuran objek dan m sama
        int i, j;
        for (i = 0; i < this.nRow; i++) {
            for (j = 0; j < this.nCol; j++) {
                this.setElmt(i, j, this.getElmt(i, j) - m.getElmt(i, j));
            }
        }
    }

    public void multiplication(Matrix m2) {
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
        this.data = m.getData();
        this.nCol = m.getNCol();
        this.nRow = m.getNRow();
    }

    public void transpose() {
        int i, j;
        Matrix m;
        m = new Matrix(this.getNCol(), this.getNRow());
        for (i = 0; i < this.getNRow(); i++) {
            for (j = 0; j < this.getNCol(); j++) {
                m.setElmt(i, j, this.getElmt(j, i));
            }
        }
        this.data = m.getData();
        this.nCol = m.getNCol();
        this.nRow = m.getNRow();
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
    public void ToEchelonForm(boolean reducedForm) {
        int nR, nC, rowMax, rowMin, rowCurrent;
        double ratio, elmtMax, elmtMin;

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
                continue;
            }

            // row swap jika elemen kolom ke-i bernilai nol
            if ((this.getElmt(rowCurrent, i) == 0.0) && (elmtMax > 0.0)) {
                this.RowSwap(rowCurrent, rowMax);
            } else if ((this.getElmt(rowCurrent, i) == 0.0) && (elmtMin < 0.0)) {
                this.RowSwap(rowCurrent, rowMin);
            }

            // Membuat satu utama pada row ke-rowCurrent
            this.ScalarRowMultiplication(rowCurrent, 1.0f / this.getElmt(rowCurrent, i));

            // Membuat Row Echelon Form
            for (int j = rowCurrent + 1; j < nR; j++) {
                if (this.getElmt(j, i) != 0.0) {
                    ratio = this.getElmt(j, i) / this.getElmt(rowCurrent, i);

                    this.RowSum(j, i, -ratio);
                }
            }

            // Membuat Reduced Row Echelon Form
            if (reducedForm) {
                for (int j = 0; j < (rowCurrent); j++) {
                    if (this.getElmt(j, i) != 0.0) {
                        ratio = this.getElmt(j, i) / this.getElmt(rowCurrent, i);
                        this.RowSum(j, i, -ratio);
                    }
                }
            }

            // Jika operasi berhasil, row count akan bertambah
            rowCurrent++;
            if (rowCurrent == nR) {
                break;
            }
        }
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

    public String toString(Matrix M) {
        String output = "";
        for (int i = 0; i < M.getNRow(); i++) {
            for (int j = 0; j < M.getNCol(); j++) {
                output += String.format("%.2f", M.getElmt(i, j));
                if (j < M.getNCol() - 1) {
                    output += " ";
                }
            }
            if (i < M.getNRow() - 1) {
                output += "\n";
            }
        }
        return output;
    }

    // Static
    public static Matrix plus(Matrix m1, Matrix m2) {
        //Prekondisi: ukuran m1 dan m2 sama
        Matrix m;
        int i, j;
        m = new Matrix(m1.getNRow(), m1.getNCol());
        for (i = 0; i < m.getNRow(); i++) {
            for (j = 0; j < m.getNCol(); j++) {
                m.setElmt(i, j, m1.getElmt(i, j) + m2.getElmt(i, j));
            }
        }
        return m;
    }

    public static Matrix min(Matrix m1, Matrix m2) {
        //Prekondisi: ukuran m1 dan m2 sama
        Matrix m;
        int i, j;
        m = new Matrix(m1.getNRow(), m1.getNCol());
        for (i = 0; i < m.getNRow(); i++) {
            for (j = 0; j < m.getNCol(); j++) {
                m.setElmt(i, j, m1.getElmt(i, j) - m2.getElmt(i, j));
            }
        }
        return m;
    }

    public static Matrix multiplication(Matrix m1, Matrix m2) {
        //Prekondisi: ukuran kolom m1 dan baris m2 sama
        Matrix m;
        int i, j, k;
        double sum;
        m = new Matrix(m1.getNRow(), m2.getNCol());
        for (i = 0; i < m.getNRow(); i++) {
            for (j = 0; j < m.getNCol(); j++) {
                sum = 0;
                for (k = 0; k < m2.getNRow(); k++) {
                    sum += m1.getElmt(i, k) * m2.getElmt(k, j);
                }
                m.setElmt(i, j, sum);
            }
        }
        return m;
    }

    public static Matrix ToEchelonForm(Matrix m, boolean reducedForm) {
        Matrix res = new Matrix(m.getData());
        res.ToEchelonForm(reducedForm);
        return res;
    }
}
