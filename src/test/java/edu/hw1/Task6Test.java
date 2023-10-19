package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Common value")
    void commonValue() {
        int num = 6621;
        int expectedResult = 5;

        int actualResult = Task6.kaprekarSteps(num);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Common value 2")
    void commonValue2() {
        int num = 6554;
        int expectedResult = 4;

        int actualResult = Task6.kaprekarSteps(num);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Too small number")
    void smallNumber() {
        int num = 1000;
        int expectedResult = -1;

        int actualResult = Task6.kaprekarSteps(num);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Too big number")
    void bigNumber() {
        int num = 10000;
        int expectedResult = -1;

        int actualResult = Task6.kaprekarSteps(num);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
