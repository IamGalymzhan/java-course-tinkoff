package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    @DisplayName("All Friday 13 in a year")
    void test() {
        int year = 2023;
        var actualResult = Task2.allFriday13(year);
        assertThat(actualResult).containsExactlyInAnyOrder(
            LocalDate.of(2023, 01, 13),
            LocalDate.of(2023, 10, 13)
        );
    }

    @Test
    @DisplayName("Next Friday 13")
    void test2() {
        var date = LocalDate.of(2023, 12, 11);
        var actualResult = Task2.nextFriday13(date);
        assertThat(actualResult).isEqualTo(
            LocalDate.of(2024, 9, 13)
        );
    }
}
