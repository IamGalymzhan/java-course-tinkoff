package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Common case")
    void test() {
        List<Animal> list = new ArrayList<>();
        list.add(new Animal("Pattinson", Animal.Type.CAT, Animal.Sex.F, 1, 10, 40, true));
        list.add(new Animal("Barselona", Animal.Type.DOG, Animal.Sex.M, 2, 5, 40, true));
        list.add(new Animal("Astana", Animal.Type.CAT, Animal.Sex.F, 3, 9, 40, true));

        List<Animal> result = Task1.sortByHeightAsc(list);

        assertThat(result).isSortedAccordingTo((o1, o2) -> o1.height() - o2.height());
    }
}
