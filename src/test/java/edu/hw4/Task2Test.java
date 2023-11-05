package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Common case")
    void test() {
        List<Animal> list = new ArrayList<>();
        list.add(new Animal("Pattinson", Animal.Type.CAT, Animal.Sex.F, 1, 10, 90, true));
        list.add(new Animal("Barselona", Animal.Type.DOG, Animal.Sex.M, 2, 5, 40, true));
        list.add(new Animal("Astana", Animal.Type.CAT, Animal.Sex.F, 3, 9, 2, true));

        List<Animal> result = Task2.sortByWeightDesc(list, 2);

        assertThat(result).isSortedAccordingTo((o1, o2) -> o1.weight() - o2.weight());
        assertThat(result).hasSize(2);
    }
}
