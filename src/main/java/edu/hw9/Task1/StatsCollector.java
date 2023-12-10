package edu.hw9.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StatsCollector {

    private static final int THREADS = 4;
    ExecutorService executorService;
    Queue<Metric> queue = new ConcurrentLinkedDeque<>();

    public StatsCollector() {
        executorService = Executors.newFixedThreadPool(THREADS);
    }

    public void push(String metricName, double[] values) {
        executorService.submit(execute(metricName, values));
    }

    public List<Metric> stats() {
        return new ArrayList<>(queue);
    }

    private Runnable execute(String metricName, double[] values) {
        return () -> {
            double sum = 0.0;
            double min = Double.POSITIVE_INFINITY;
            double max = Double.NEGATIVE_INFINITY;
            double average;

            for (var value : values) {
                sum += value;
                min = Double.min(min, value);
                max = Double.max(max, value);
            }

            average = sum / (values.length);

            queue.add(new Metric(metricName, average, max, min, sum));
        };
    }
}
