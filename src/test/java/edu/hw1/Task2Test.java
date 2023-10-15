package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Common case")
    void anyNumber() {
        int number = 532;
        int expectedResult = 3;

        int actualResult = Task2.countDigits(number);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Negative number case")
    void negativeNumber() {
        int number = -989;
        int expectedResult = 3;

        int actualResult = Task2.countDigits(number);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Zero case")
    void zeroNumber() {
        int expectedResult = 1;

        int actualResult = Task2.countDigits(0);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Long number case")
    void longNumber() {
        int number = 2015698423;
        int expectedResult = 10;

        int actualResult = Task2.countDigits(number);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("One digit case")
    void oneDigit() {
        int number = 3;
        int expectedResult = 1;

        int actualResult = Task2.countDigits(number);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
