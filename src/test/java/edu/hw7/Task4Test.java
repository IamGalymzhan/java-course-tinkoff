package edu.hw7;

import edu.hw7.Task4.MultiThreadedMonteCarlo;
import edu.hw7.Task4.SingleThreadedMonteCarlo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {

    static int iterations = 10_000_000;
    @Test
    @DisplayName("Single Thread")
    void testOneThread() {

        double pi = SingleThreadedMonteCarlo.countPi(iterations);

        assertThat(Math.abs(pi - Math.PI)).isLessThan(0.01);
    }

    @Test
    @DisplayName("Four Threads")
    void testFourThreads() {

        double pi = MultiThreadedMonteCarlo.countPi(iterations, 4);

        assertThat(Math.abs(pi - Math.PI)).isLessThan(0.01);
    }

}
