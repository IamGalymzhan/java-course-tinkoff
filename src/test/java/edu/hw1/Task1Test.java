package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Common case")
    void commonCase() {
        int minutes = 15, seconds = 39;
        String formattedTime = minutes + ":" + seconds / 10 + seconds % 10;
        int expectedResult = (minutes * 60) + seconds;

        int actualResult = Task1.minutesToSeconds(formattedTime);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Long minutes case")
    void longMinutes() {
        int minutes = 889, seconds = 45;
        String formattedTime = minutes + ":" + seconds / 10 + seconds % 10;
        int expectedResult = (minutes * 60) + seconds;

        int actualResult = Task1.minutesToSeconds(formattedTime);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Seconds are 60")
    void incorrectSeconds() {
        int minutes = 45, seconds = 60;
        String formattedTime = minutes + ":" + seconds / 10 + seconds % 10;
        int expectedResult = -1;

        int actualResult = Task1.minutesToSeconds(formattedTime);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Incorrect seconds format case")
    void incorrectStringFormat() {
        int minutes = 22, seconds = 5;
        String formattedTime = minutes + ":" + seconds;
        int expectedResult = -1;

        int actualResult = Task1.minutesToSeconds(formattedTime);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

}
