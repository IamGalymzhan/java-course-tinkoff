package edu.hw9;

import edu.hw9.Task1.Metric;
import edu.hw9.Task1.StatsCollector;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    void test() throws InterruptedException {
        StatsCollector statsCollector = new StatsCollector();
        statsCollector.push("name1", new double[] {1.0, 1.2, 0.8, 2.0, 0.0});
        statsCollector.push("name2", new double[] {0.5, 0.9, 1.3, 3.0, 0.3});

        Thread.sleep(1000);

        List<Metric> actualResult = statsCollector.stats();

        assertThat(actualResult).containsExactlyInAnyOrder(
            new Metric("name1", 1.0, 2.0, 0.0, 5.0),
            new Metric("name2", 1.2, 3.0, 0.3, 6.0)
        );
    }
}
