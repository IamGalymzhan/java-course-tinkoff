package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Common case")
    void test() {
        List<String> sessions = new ArrayList<>();
        sessions.add("2022-03-12, 20:20 - 2022-03-12, 23:50");
        sessions.add("2022-04-01, 21:30 - 2022-04-02, 01:20");

        var actualResult = Task1.averageSessionDuration(sessions);

        assertThat(actualResult).isEqualTo(Duration.of(220, ChronoUnit.MINUTES));
    }
}
