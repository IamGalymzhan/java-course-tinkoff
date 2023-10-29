package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        String sequence = "()()()";
        List expectedResult = Arrays.asList("()", "()", "()");

        List actualResult = Task2.clusterize(sequence);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        String sequence = "((()))";
        List expectedResult = Arrays.asList("((()))");

        List actualResult = Task2.clusterize(sequence);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Test 3")
    void test3() {
        String sequence = "((())())(()(()()))";
        List expectedResult = Arrays.asList("((())())", "(()(()()))");

        List actualResult = Task2.clusterize(sequence);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
