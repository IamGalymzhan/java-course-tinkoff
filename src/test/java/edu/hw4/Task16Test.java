package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task16Test {
    @Test
    @DisplayName("Common case")
    void test() {
        List<Animal> list = new ArrayList<>();
        Animal a1 = new Animal("Abacaba", Animal.Type.DOG, Animal.Sex.F, 5, 50, 50, true);
        Animal a2 = new Animal("Babcbab", Animal.Type.DOG, Animal.Sex.F, 10, 50, 60, true);
        Animal a3 = new Animal("Onetwo", Animal.Type.CAT, Animal.Sex.F, 7, 50, 20, true);
        Animal a4 = new Animal("Twoone", Animal.Type.CAT, Animal.Sex.F, 9, 50, 40, true);
        Animal a5 = new Animal("Twoone", Animal.Type.SPIDER, Animal.Sex.F, 6, 50, 5, true);
        Animal a6 = new Animal("Twoone", Animal.Type.SPIDER, Animal.Sex.M, 6, 50, 4, true);
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        list.add(a6);

        List<Animal> result = Task16.sortByTypeSexName(list);

        assertThat(result).isSortedAccordingTo((o1, o2) -> {
            if (o1.type() != o2.type())
                return o1.type().toString().compareTo(o2.type().toString());
            if (o1.sex() != o2.sex())
                return o1.sex().toString().compareTo(o2.sex().toString());
            return o1.name().compareTo(o2.name());
        });
    }
}
