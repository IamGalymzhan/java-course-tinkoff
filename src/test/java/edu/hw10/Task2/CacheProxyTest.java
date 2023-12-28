package edu.hw10.Task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withinPercentage;

public class CacheProxyTest {

    Path path;

    @Test
    @DisplayName("Test persist = false cache")
    void test() {
        FibCalculator c = new DefaultFibCalculator();
        FibCalculator proxy = CacheProxy.create(c, c.getClass(), null);
        long firstResult = proxy.fib(20);
        long secondResult = proxy.fib(20);
        assertThat(secondResult).isEqualTo(firstResult);
    }

    @Test
    @DisplayName("Test persist = true cache")
    void testPersist() throws IOException {
        path = Paths.get(".").resolve("data");
        Files.createDirectories(path);
        PersistFibCalculator c = new DefaultPersistFibCalculator();
        PersistFibCalculator proxy = CacheProxy.create(c, c.getClass(), path);
        long firstResult = proxy.fib(20);
        long secondResult = proxy.fib(20);
        assertThat(secondResult).isEqualTo(firstResult);

        Path methodPath = path.resolve("fib");
        Path argsPath = methodPath.resolve("[20].txt");
        Files.delete(argsPath);
        Files.delete(methodPath);
        Files.delete(path);
    }

}
