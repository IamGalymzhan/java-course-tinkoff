package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @DisplayName("True case")
    @ParameterizedTest
    @ValueSource(strings = {"Hello!", "^^^", "What*", "@vk.com", "%d", "Money$"})
    void test(String pass) {
        assertThat(Task4.isPasswordSafe(pass)).isTrue();
    }

    @DisplayName("False case")
    @ParameterizedTest
    @ValueSource(strings = {"Hello", ".", "What"})
    void test2(String pass) {
        assertThat(Task4.isPasswordSafe(pass)).isFalse();
    }
}
