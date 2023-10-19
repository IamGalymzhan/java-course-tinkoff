package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Common case")
    void commonCase() {
        int num = 11211230;
        boolean expectedResult = true;

        boolean actualResult = Task5.isPalindromeDescendant(num);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Common case 2")
    void commonCase2() {
        int num = 13001120;
        boolean expectedResult = true;

        boolean actualResult = Task5.isPalindromeDescendant(num);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Odd length")
    void oddLength() {
        int num = 236;
        boolean expectedResult = true;

        boolean actualResult = Task5.isPalindromeDescendant(num);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

}
