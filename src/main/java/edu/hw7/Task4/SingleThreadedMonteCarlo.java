package edu.hw7.Task4;

import java.util.Random;

public class SingleThreadedMonteCarlo {
    private static double R = 1;

    public static double countPi(int iterations) {
        Random random = new Random();
        int circleCount = 0;
        for (int i = 0; i < iterations; i++) {
            double x = random.nextDouble(-R, R);
            double y = random.nextDouble(-R, R);
            if ((x * x + y * y) <= R * R) {
                circleCount++;
            }
        }
        double pi = 4 * (double) circleCount / iterations;
        return pi;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(countPi(100_000_000));
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / (1000000.0));
    }
}
