package alingeo.matriks.problem;

import alingeo.matriks.Matrix;
import alingeo.matriks.Util;
import alingeo.matriks.solver.SPLSolver;
import alingeo.matriks.solver.SPLSolver.SolutionResult;
import java.util.Locale;

/**
 * Interpolation Class
 *
 * Usage:
 *
 * 1. Construct an instance of Interpolation with new Interpolation(). - Accept
 * points in Matrix N x 2 or without points
 *
 * 2. (Optional) Add more points in Matrix N x 2 with addPoints().
 *
 * 3. Fit the instance with fit().
 *
 * 4. Check if instance is actually fitted with isFit(). - Instance is not
 * fitted even after fit() if the solution is not exist OR the data points are
 * not enough to be fitted. There should be a minimum of 2 points so instance
 * can be fitted. You can check the point count by getCount()
 *
 * 5. You can evaluate any x with evaluate() OR print the polynomial equation
 * with toString().
 *
 * 6. If there are more data, you can repeat step 2.
 *
 * @author Amar Fadil
 */
public class Interpolation {

    /**
     * @return the isFit
     */
    public boolean isFit() {
        return isFit;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    private final Matrix buffer;
    private final Matrix points;
    private boolean isFit;
    private SolutionResult result;
    private int count;

    public Interpolation() {
        this.isFit = false;
        this.points = new Matrix(0, 2);
        this.buffer = new Matrix(0, 0);
        this.count = 0;
    }

    public Interpolation(Matrix points) {
        this.isFit = false;
        this.points = new Matrix(points.getData());
        this.count = points.getNRow();
        this.buffer = new Matrix(this.count, this.count + 1);
        for (int i = 0; i < this.count; i++) {
            double cnt = 1;
            double x = points.getElmt(i, 0);
            for (int j = 0; j < this.count; j++) {
                this.buffer.setElmt(i, j, cnt);
                cnt *= x;
            }
            this.buffer.setElmt(i, this.count, points.getElmt(i, 1));
        }
    }

    public void addPoints(Matrix points) {
        this.isFit = false;
        int current = this.getCount();
        int total = current + points.getNRow();
        // Adjust point
        this.points.setNRow(total);
        for (int i = current; i < total; i++) {
            this.points.setRow(i, points.getRow(i - current));
        }
        // Resize buffer
        this.buffer.resize(total, total + 1);
        // Expand for i = 0..current-1 from j = current..total
        double cnt;
        double[] crt;
        for (int i = 0; i < current; i++) {
            cnt = this.buffer.getElmt(i, current - 1);
            crt = this.points.getRow(i);
            for (int j = current; j < total; j++) {
                cnt *= crt[0];
                this.buffer.setElmt(i, j, cnt);
            }
            this.buffer.setElmt(i, total, crt[1]);
        }
        // Fill for i = current..total-1 from j = 0..total
        for (int i = current; i < total; i++) {
            cnt = 1;
            crt = this.points.getRow(i);
            for (int j = 0; j < total; j++) {
                this.buffer.setElmt(i, j, cnt);
                cnt *= crt[0];
            }
            this.buffer.setElmt(i, total, crt[1]);
        }

        this.count = total;
    }

    public void fit() {
        if (this.count > 1 && !this.isFit()) {
            this.result = SPLSolver.gaussMethod(this.buffer);
            if (this.result.getType() != SolutionResult.SolutionType.NOT_SUPPORTED) {
                this.isFit = true;
            }
        }
    }

    public double evaluate(double x) {
        if (!this.isFit()) {
            fit();
            if (!this.isFit()) {
                return Double.MIN_VALUE;
            }
        }
        double res = 0;
        double cnt = 1;
        Matrix r = this.result.getResult();
        for (int i = 0; i < r.getNRow(); i++) {
            res += cnt * r.getElmt(i, 0);
            cnt *= x;
        }
        return res;
    }

    public String toString(Util.Formatting type) {
        if (!this.isFit) {
            if (this.count > 1) {
                return "Interpolasi belum di-fit. Jalankan fit() terlebih dahulu.";
            } else {
                return "Data tidak cukup untuk diinterpolasi.";
            }
        }
        Matrix r = this.result.getResult();
        int cnt = r.getNRow();
        String res = "f(x) = \n";
        res += Util.format(r.getElmt(0, 0), type);
        for (int i = 1; i < cnt; i++) {
            double el = r.getElmt(i, 0);
            if (el > 0) {
                res += "\n+ ";
            } else {
                res += "\n- ";
                el *= -1;
            }
            res += Util.format(el, type);
            res += "x";
            if (i > 1) {
                res += "^" + i;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return this.toString(Util.Formatting.DEFAULT);
    }
}
