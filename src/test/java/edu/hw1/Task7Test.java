package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task7Test {
    @Test
    @DisplayName("Right rotate check")
    void rightNormal() {
        int n = 8, shift = 1;
        int expectedResult = 4;

        int actualResult = Task7.rotateRight(n, shift);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Left rotate check")
    void leftNormal() {
        int n = 16, shift = 1;
        int expectedResult = 1;

        int actualResult = Task7.rotateLeft(n, shift);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Left rotate check 2")
    void leftNormal2() {
        int n = 17, shift = 2;
        int expectedResult = 6;

        int actualResult = Task7.rotateLeft(n, shift);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Zero case")
    void zeroCase() {
        int n = 0, shift = 2;
        int expectedResult = 0;

        int actualResult = Task7.rotateLeft(n, shift);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
