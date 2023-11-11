package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Common case")
    void test() {
        List<Animal> list = new ArrayList<>();
        Animal a1 = new Animal("Pattinson", Animal.Type.CAT, Animal.Sex.F, 1, 10, 90, true);
        list.add(a1);
        list.add(new Animal("short", Animal.Type.DOG, Animal.Sex.M, 2, 5, 40, true));
        list.add(new Animal("Astana", Animal.Type.CAT, Animal.Sex.F, 3, 9, 2, true));

        Animal result = Task4.longestName(list);

        assertThat(result).isEqualTo(a1);
    }
}
