package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {
    @DisplayName("True cases")
    @ParameterizedTest
    @CsvSource({"achfdbaabgabcaabg,abc", "sxoiysdzs,xyz"})
    void test(String sequence, String subsequence) {
        assertThat(Task6.isSubsequence(sequence, subsequence)).isTrue();
    }

    @DisplayName("False cases")
    @ParameterizedTest
    @CsvSource({"achfdbaabgabcaabg,abcd", "sxoiysdzs,xyzo"})
    void test2(String sequence, String subsequence) {
        assertThat(Task6.isSubsequence(sequence, subsequence)).isFalse();
    }
}
