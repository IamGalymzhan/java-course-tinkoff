package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task20Test {
    @Test
    @DisplayName("Common case")
    void test() {
        List<Animal> list = new ArrayList<>();
        Animal a1 = new Animal("", Animal.Type.DOG, Animal.Sex.F, 5, 50, 50, true);
        Animal a2 = new Animal("Babcbab", Animal.Type.DOG, Animal.Sex.F, 10, 0, 60, true);
        Animal a3 = new Animal("Onetwo", Animal.Type.CAT, Animal.Sex.F, 7, 50, -1, true);
        list.add(a1);
        list.add(a2);
        list.add(a3);
        var result = Task20.validateAnimals(list);
        Map<String, String> expected = Map.ofEntries(
            Map.entry(a1.toString(), new ValidationError("name", "Name cannot be empty").toString() + "\n"),
            Map.entry(a2.toString(), new ValidationError("height", "Height cannot be zero").toString() + "\n"),
            Map.entry(a3.toString(), new ValidationError("weight", "Weight cannot be negative").toString() + "\n")
        );
        assertThat(result).isEqualTo(expected);
    }
}
