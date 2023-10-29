package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Lowercase")
    void lowercase() {
        String text = "hello";
        String expectedResult = "svool";

        String actualResult = Task1.atbash(text);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Uppercase")
    void uppercase() {
        String text = "WORLD";
        String expectedResult = "DLIOW";

        String actualResult = Task1.atbash(text);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Special characters")
    void specialCharacters() {
        String text = "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";
        String expectedResult = "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";

        String actualResult = Task1.atbash(text);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
