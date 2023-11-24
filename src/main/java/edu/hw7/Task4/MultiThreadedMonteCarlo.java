package edu.hw7.Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadedMonteCarlo {
    private static double R = 1;

    public static double countPi(int iterations, int threads) {
        AtomicInteger circleCount = new AtomicInteger();
        List<Thread> threadList = new ArrayList<>();
        for (int j = 0; j < threads; j++) {
            int threadIterations = (j + 1 != threads ? iterations / threads : iterations - j * (iterations / threads));
            threadList.add(new Thread(() -> {
                for (int i = 0; i < threadIterations; i++) {
                    double x = ThreadLocalRandom.current().nextDouble(-R, R);
                    double y = ThreadLocalRandom.current().nextDouble(-R, R);
                    if ((x * x + y * y) <= R * R) {
                        circleCount.getAndIncrement();
                    }
                }
            }));
        }
        for (var thread : threadList) {
            thread.start();
        }
        try {
            for (var thread : threadList) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        double pi = 4 * (double) circleCount.get() / iterations;
        return pi;
    }

}
