package edu.hw7;

import edu.hw7.Task2.Factorial;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Common case")
    void test() {

        int fact = Factorial.fact(6);

        assertThat(fact).isEqualTo(720);
    }
}
