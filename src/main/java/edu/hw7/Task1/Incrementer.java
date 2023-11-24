package edu.hw7.Task1;

import java.util.concurrent.atomic.AtomicInteger;

public class Incrementer {
    private AtomicInteger counter = new AtomicInteger(0);

    private void increment() {
        counter.addAndGet(1);
    }

    public int getCounter() {
        return counter.get();
    }
    public void addition(int value) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < value / 2; i++) {
                increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < value - value / 2; i++) {
                increment();
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
