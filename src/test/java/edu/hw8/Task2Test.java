package edu.hw8;

import edu.hw8.Task2.Fibonacci;
import edu.hw8.Task2.FixedThreadPool;
import edu.hw8.Task2.ThreadPool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Multithread Fibonacci")
    void test1() throws Exception {
        ThreadPool threadPool = FixedThreadPool.create(4);
        List<Integer> actualResults = new CopyOnWriteArrayList<>();
        List<Integer> expectedResults = List.of(1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            threadPool.execute(() -> actualResults.add(Fibonacci.calculate(finalI)));
        }
        threadPool.close();
        assertThat(actualResults).containsExactlyInAnyOrderElementsOf(expectedResults);
    }
}
