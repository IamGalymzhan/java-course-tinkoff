package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @DisplayName("True cases")
    @ParameterizedTest
    @ValueSource(strings = {"А123ВЕ777", "О777ОО177"})
    void test(String plate) {
        assertThat(Task5.isCorrectLicensePlate(plate)).isTrue();
    }

    @DisplayName("False cases")
    @ParameterizedTest
    @ValueSource(strings = {"123АВЕ777", "А123ВГ77", "А123ВЕ7777"})
    void test2(String plate) {
        assertThat(Task5.isCorrectLicensePlate(plate)).isFalse();
    }
}
