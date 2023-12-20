package edu.hw7.Task4;

import java.util.Random;

public class SingleThreadedMonteCarlo {
    private static final int FOUR = 4;

    private SingleThreadedMonteCarlo() {
    }

    public static double countPi(int iterations) {
        Random random = new Random();
        int circleCount = 0;
        for (int i = 0; i < iterations; i++) {
            double x = random.nextDouble(-1, 1);
            double y = random.nextDouble(-1, 1);
            if ((x * x + y * y) <= 1) {
                circleCount++;
            }
        }
        double pi = FOUR * (double) circleCount / iterations;
        return pi;
    }

}
