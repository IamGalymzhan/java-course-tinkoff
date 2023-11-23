package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {
    @Test
    @DisplayName("Check 1 Test")
    void test1() {
        assertThat(Task8.check1("00000")).isTrue();
        assertThat(Task8.check1("0111")).isFalse();
    }

    @Test
    @DisplayName("Check 2 Test")
    void test2() {
        assertThat(Task8.check2("00000")).isTrue();
        assertThat(Task8.check2("0111")).isFalse();
        assertThat(Task8.check2("1010")).isTrue();
        assertThat(Task8.check2("11111")).isFalse();
    }

    @Test
    @DisplayName("Check 3 Test")
    void test3() {
        assertThat(Task8.check3("000000")).isTrue();
        assertThat(Task8.check3("011100")).isTrue();
        assertThat(Task8.check3("1010")).isFalse();
        assertThat(Task8.check3("11111")).isTrue();
    }

    @Test
    @DisplayName("Check 4 Test")
    void test4() {
        assertThat(Task8.check4("11")).isFalse();
        assertThat(Task8.check4("111")).isFalse();
        assertThat(Task8.check4("1010")).isTrue();
        assertThat(Task8.check4("11111")).isTrue();
    }

    @Test
    @DisplayName("Check 5 Test")
    void test5() {
        assertThat(Task8.check5("010101")).isTrue();
        assertThat(Task8.check5("11111")).isTrue();
        assertThat(Task8.check5("00101")).isFalse();
        assertThat(Task8.check5("00000")).isFalse();
    }

    @Test
    @DisplayName("Check 6 Test")
    void test6() {
        assertThat(Task8.check6("001")).isTrue();
        assertThat(Task8.check6("0001")).isTrue();
        assertThat(Task8.check6("00101")).isFalse();
        assertThat(Task8.check6("10")).isFalse();
    }

    @Test
    @DisplayName("Check 7 Test")
    void test7() {
        assertThat(Task8.check7("010101")).isTrue();
        assertThat(Task8.check7("001001")).isTrue();
        assertThat(Task8.check7("001100")).isFalse();
        assertThat(Task8.check7("110000")).isFalse();
    }
}
