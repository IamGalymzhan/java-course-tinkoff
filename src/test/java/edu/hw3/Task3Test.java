package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Test 1 String")
    void testString() {
        List list = Arrays.asList("aa", "bb", "aa", "bb");
        Map<Object, Integer> expectedResult = Map.ofEntries(entry("aa", 2), entry("bb", 2));

        Map<Object, Integer> actualResult = Task3.freqDict(list);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Test 2 Int")
    void intString() {
        List list = Arrays.asList(2, 3, 3, 3);
        Map<Object, Integer> expectedResult = Map.ofEntries(entry(2, 1), entry(3, 3));

        Map<Object, Integer> actualResult = Task3.freqDict(list);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Test 3 String")
    void testString2() {
        List list = Arrays.asList("код", "код", "код", "bug");
        Map<Object, Integer> expectedResult = Map.ofEntries(entry("код", 3), entry("bug", 1));

        Map<Object, Integer> actualResult = Task3.freqDict(list);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
