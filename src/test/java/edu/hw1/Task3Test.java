package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class Task3Test {
    @Test
    @DisplayName("Normal true case")
    void trueCase() {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {4, 0};
        boolean expectedResult = true;

        boolean actualResult = Task3.isNestable(array1, array2);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Normal false case")
    void falseCase() {
        int[] array1 = {9, 9, 8};
        int[] array2 = {8, 9};
        boolean expectedResult = false;

        boolean actualResult = Task3.isNestable(array1, array2);

        assertThat(actualResult).isEqualTo(expectedResult);
    }


}
