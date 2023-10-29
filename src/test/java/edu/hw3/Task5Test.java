package edu.hw3;

import edu.hw3.Task5.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task5.Main.parseContacts;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    void test() {
        Contact[] expectedResult = new Contact[4];
        expectedResult[0] = new Contact("Thomas Aquinas");
        expectedResult[1] = new Contact("Rene Descartes");
        expectedResult[2] = new Contact("David Hume");
        expectedResult[3] = new Contact("John Locke");

        Contact[] actualResult = parseContacts(new String[]{"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"}, "ASC");

        assertThat(actualResult).containsExactly(expectedResult);
    }

    @Test
    void test2() {
        Contact[] expectedResult = new Contact[3];
        expectedResult[0] = new Contact("Carl Gauss");
        expectedResult[1] = new Contact("Leonhard Euler");
        expectedResult[2] = new Contact("Paul Erdos");

        Contact[] actualResult = parseContacts(new String[]{"Paul Erdos", "Leonhard Euler", "Carl Gauss"}, "DESC");

        assertThat(actualResult).containsExactly(expectedResult);
    }
}
