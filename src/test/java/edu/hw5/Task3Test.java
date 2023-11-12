package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Common case")
    void test() {
        assertThat(Task3.parseDate("2020-10-10").get()).isEqualTo(LocalDate.of(2020, 10, 10));
        assertThat(Task3.parseDate("2020-12-2").get()).isEqualTo(LocalDate.of(2020, 12, 2));
        assertThat(Task3.parseDate("1/3/1976").get()).isEqualTo(LocalDate.of(1976, 3, 1));
        assertThat(Task3.parseDate("1/2/20").get()).isEqualTo(LocalDate.of(2020, 2, 1));
        assertThat(Task3.parseDate("tomorrow").get()).isEqualTo(LocalDate.now().plus(1, ChronoUnit.DAYS));
        assertThat(Task3.parseDate("today").get()).isEqualTo(LocalDate.now());
        assertThat(Task3.parseDate("yesterday").get()).isEqualTo(LocalDate.now().minus(1, ChronoUnit.DAYS));
        assertThat(Task3.parseDate("1 day ago").get()).isEqualTo(LocalDate.now().minus(1, ChronoUnit.DAYS));
        assertThat(Task3.parseDate("2234 days ago").get()).isEqualTo(LocalDate.now().minus(2234, ChronoUnit.DAYS));
    }
}
