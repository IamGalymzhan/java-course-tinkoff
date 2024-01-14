package edu.hw10.Task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomObjectGeneratorTest {
    @Test
    @DisplayName("Class test")
    void testClass() {
        RandomObjectGenerator rog = new RandomObjectGenerator();

        var myClass = (MyClass) rog.nextObject(MyClass.class, "create");
        assertThat(myClass).isNotNull();
        assertThat(myClass.getString1()).isNotNull();
        assertThat(myClass.getInt1()).isBetween(1, 10);
    }

    @Test
    @DisplayName("Record test")
    void testRecord() {
        RandomObjectGenerator rog = new RandomObjectGenerator();

        var myRecord = (MyRecord) rog.nextObject(MyRecord.class);
        assertThat(myRecord).isNotNull();
    }
}
