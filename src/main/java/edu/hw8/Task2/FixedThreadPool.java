package edu.hw8.Task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class FixedThreadPool implements ThreadPool {
    private int n;
    private Thread[] threads;
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    private AtomicBoolean active = new AtomicBoolean(false);

    private FixedThreadPool(int n) {
        this.n = n;
        this.threads = new Thread[n];
        start();
    }

    public static FixedThreadPool create(int n) {
        return new FixedThreadPool(n);
    }

    @Override
    public void start() {
        active.set(true);
        for (int i = 0; i < n; i++) {
            threads[i] = new Thread(() -> {
                while (active.get() || !queue.isEmpty()) {
                    Runnable runnable;
                    while ((runnable = queue.poll()) != null) {
                        runnable.run();
                    }
                }
            });
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        try {
            queue.put(runnable);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        active.set(false);
    }
}
