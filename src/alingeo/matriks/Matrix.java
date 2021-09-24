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
    static Matrix plus(Matrix m1, Matrix m2) {
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

    public void plus(Matrix m) {
        //Prekondisi: ukuran objek dan m sama
        int i, j;
        for (i = 0; i < this.nRow; i++) {
            for (j = 0; j < this.nCol; j++) {
                this.setElmt(i, j, this.getElmt(i, j) + m.getElmt(i, j));
            }
        }
    }

    static Matrix min(Matrix m1, Matrix m2) {
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

    public void min(Matrix m) {
        //Prekondisi: ukuran objek dan m sama
        int i, j;
        for (i = 0; i < this.nRow; i++) {
            for (j = 0; j < this.nCol; j++) {
                this.setElmt(i, j, this.getElmt(i, j) - m.getElmt(i, j));
            }
        }
    }

    static Matrix multiplication(Matrix m1, Matrix m2) {
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
}
