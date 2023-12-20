package edu.hw7;

import edu.hw7.Task1.Incrementer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Check correct value")
    void test() {
        Incrementer incrementer = new Incrementer();

        incrementer.addition(1000);

        assertThat(incrementer.getCounter()).isEqualTo(1000);
    }
}
