package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task11Test {
    @Test
    @DisplayName("Common case")
    void test() {
        List<Animal> list = new ArrayList<>();
        Animal a1 = new Animal("Abacaba", Animal.Type.DOG, Animal.Sex.F, 5, 120, 50, true);
        Animal a2 = new Animal("Babcbab", Animal.Type.DOG, Animal.Sex.F, 10, 50, 60, true);
        Animal a3 = new Animal("Onetwo", Animal.Type.CAT, Animal.Sex.F, 7, 50, 20, false);
        Animal a4 = new Animal("Twoone", Animal.Type.CAT, Animal.Sex.F, 9, 50, 40, true);
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        var result = Task11.bitingHighAnimals(list);

        assertThat(result).containsExactlyInAnyOrder(a2, a4);

    }
}
