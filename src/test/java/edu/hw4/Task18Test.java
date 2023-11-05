package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task18Test {
    @Test
    @DisplayName("Common case")
    void test() {
        List<Animal> list1 = new ArrayList<>();
        List<Animal> list2 = new ArrayList<>();
        Animal a1 = new Animal("Abacaba", Animal.Type.DOG, Animal.Sex.F, 5, 50, 50, true);
        Animal a2 = new Animal("Babcbab", Animal.Type.FISH, Animal.Sex.F, 10, 50, 60, true);
        Animal a3 = new Animal("Onetwo", Animal.Type.CAT, Animal.Sex.F, 7, 50, 20, true);
        Animal a4 = new Animal("Twoone", Animal.Type.FISH, Animal.Sex.F, 9, 50, 40, true);
        Animal a5 = new Animal("Twoone", Animal.Type.FISH, Animal.Sex.F, 6, 50, 5, true);
        Animal a6 = new Animal("Twoone", Animal.Type.FISH, Animal.Sex.M, 6, 50, 4, true);
        list1.add(a1);
        list1.add(a2);
        list1.add(a3);
        list2.add(a4);
        list2.add(a5);
        list2.add(a6);
        var result = Task18.heaviestFish(list1, list2);

        assertThat(result).isEqualTo(a2);

    }
}
