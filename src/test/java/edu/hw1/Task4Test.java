package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task4Test {
    @Test
    @DisplayName("Common case")
    void commonCase() {
        String str = "123456";
        String expectedResult = "214365";

        String actualResult = Task4.fixString(str);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Odd length case")
    void oddCase() {
        String str = "12345";
        String expectedResult = "21435";

        String actualResult = Task4.fixString(str);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Empty string case")
    void emptyCase() {
        String str = "";
        String expectedResult = "";

        String actualResult = Task4.fixString(str);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
