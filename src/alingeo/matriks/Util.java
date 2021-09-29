/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alingeo.matriks;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 */
public class Util {

    private static final DecimalFormatSymbols _sym = new DecimalFormatSymbols(Locale.ROOT);
    private static final DecimalFormat shortFormat = new DecimalFormat("0.###", _sym);
    private static final DecimalFormat longFormat = new DecimalFormat("0.#############", _sym);
    private static final DecimalFormat paddedShortFormat = new DecimalFormat("0.000", _sym);

    public static final double EPSILON_LARGE = 0.000001;
    public static final double EPSILON_SMALL = 0.001;

    public static enum Formatting {
        SHORT,
        LONG,
        PADDED_SHORT,
        DEFAULT
    }

    public static String format(double num, Formatting type) {
        if (num == 0) {
            num = 0;
        }
        switch (type) {
            case LONG:
                return longFormat.format(num);
            case SHORT:
                return shortFormat.format(num);
            case PADDED_SHORT:
                return paddedShortFormat.format(num);
            default:
                return String.valueOf(num);
        }
    }

    public static double roundDec(double x, int decPoint) {
        double p = Math.pow(10, decPoint);
        return Math.round(p * x) / p;
    }

    public static boolean isAlmostEq(double a, double b) {
        return (a == b)
            || Math.abs(a - b) < EPSILON_LARGE * Math.max(Math.abs(a), Math.abs(b));
    }

    public static boolean isAlmostEqLess(double a, double b) {
        return (a == b)
            || Math.abs(a - b) < EPSILON_SMALL * Math.max(Math.abs(a), Math.abs(b));
    }
}
