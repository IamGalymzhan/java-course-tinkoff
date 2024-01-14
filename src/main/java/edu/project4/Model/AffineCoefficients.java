package edu.project4.Model;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

public record AffineCoefficients(double a, double b, double c, double d, double e, double f, Color color) {
    private final static double MIN_VAL = -1;
    private final static double MAX_VAL = 1;
    private final static int MAX_COL = 255;

    public static AffineCoefficients create() {
        while (true) {
            double a = ThreadLocalRandom.current().nextDouble(MIN_VAL, MAX_VAL);
            double b = ThreadLocalRandom.current().nextDouble(MIN_VAL, MAX_VAL);
            double c = ThreadLocalRandom.current().nextDouble(MIN_VAL, MAX_VAL);
            double d = ThreadLocalRandom.current().nextDouble(MIN_VAL, MAX_VAL);
            double e = ThreadLocalRandom.current().nextDouble(MIN_VAL, MAX_VAL);
            double f = ThreadLocalRandom.current().nextDouble(MIN_VAL, MAX_VAL);
            if (isValid(a, b, c, d, e, f)) {
                return new AffineCoefficients(a, b, c, d, e, f, randomColor());
            }
        }
    }

    static boolean isValid(double a, double b, double c, double d, double e, double f) {
        return (a * a + d * d) < 1 && (b * b + e * e) < 1
            && (a * a + b * b + d * d + e * e) < 1 + (a * e - b * d) * (a * e - b * d);
    }

    static Color randomColor() {
        return new Color(
            ThreadLocalRandom.current().nextInt(0, MAX_COL),
            ThreadLocalRandom.current().nextInt(0, MAX_COL),
            ThreadLocalRandom.current().nextInt(0, MAX_COL)
        );
    }
}
