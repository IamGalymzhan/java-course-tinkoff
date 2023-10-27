package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @ParameterizedTest
    @CsvSource({
        "15, XV",
        "4, IV",
        "1994, MCMXCIV",
        "58, LVIII",
        "3, III",
    })
    void test(int value, String romanValue) {
        String actualValue = Task4.convertToRoman(value);
        assertThat(actualValue).isEqualTo(romanValue);
    }
}
