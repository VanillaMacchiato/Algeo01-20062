package alingeo.matriks.problem;

import alingeo.matriks.Matrix;
import alingeo.matriks.solver.SPLSolver;
import alingeo.matriks.solver.SPLSolver.SolutionResult;
import java.util.Locale;

/**
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
        this.points = new Matrix(0, 0);
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
            this.points.setRow(i, points.getRow(i - current + 1));
        }
        // Resize buffer
        this.buffer.resize(total, total + 1);
        // Expand for i = 0..N-2 from j = current..total
        double cnt;
        double[] crt;
        for (int i = 0; i < total - 1; i++) {
            cnt = this.buffer.getElmt(i, current - 1);
            crt = this.points.getRow(i);
            for (int j = current; j < total; j++) {
                cnt *= crt[0];
                this.buffer.setElmt(i, j, cnt);
            }
            this.buffer.setElmt(i, total, crt[1]);
        }
        // Fill for i = N-1
        cnt = 1;
        crt = this.points.getRow(total - 1);
        for (int j = 0; j < total; j++) {
            this.buffer.setElmt(total - 1, j, cnt);
            cnt *= crt[0];
        }
        this.buffer.setElmt(total - 1, total, crt[1]);

        this.count = total;
    }

    public void fit() {
        if (this.count > 1 && !this.isFit()) {
            this.result = SPLSolver.inverseMethod(this.buffer);
            this.isFit = true;
        }
    }

    public double evaluate(double x) {
        if (!this.isFit()) {
            fit();
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

    public String toString(int decPoint) {
        if (!this.isFit) {
            return "Interpolation is not fitted yet.";
        }
        Matrix r = this.result.getResult();
        int cnt = r.getNRow();
        double p = Math.pow(10, decPoint);
        String res = "f(x) = ";
        res += r.getElmt(0, 0);
        for (int i = 1; i < cnt; i++) {
            double el = r.getElmt(i, 0);
            if (el > 0) {
                res += " + ";
            } else {
                res += " - ";
                el *= -1;
            }
            res += String.format(
                Locale.ROOT,
                "%." + decPoint + "f",
                ((double) Math.round(p * el)) / p
            );
            res += "x";
            if (i > 1) {
                res += "^" + i;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return this.toString(3);
    }
}
