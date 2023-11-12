package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Check 1 Test")
    void test1() {
        assertThat(Task7.check1("001")).isFalse();
        assertThat(Task7.check1("000")).isTrue();
        assertThat(Task7.check1("10")).isFalse();
        assertThat(Task7.check1("0000")).isTrue();
    }

    @Test
    @DisplayName("Check 2 Test")
    void test2() {
        assertThat(Task7.check2("01010")).isTrue();
        assertThat(Task7.check2("101010")).isFalse();
    }

    @Test
    @DisplayName("Check 3 Test")
    void test3() {
        assertThat(Task7.check3("")).isFalse();
        assertThat(Task7.check3("0101")).isFalse();
        assertThat(Task7.check3("100")).isTrue();
    }
}
