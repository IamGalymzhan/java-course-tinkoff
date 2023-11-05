package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Common case")
    void test() {
        List<Animal> list = new ArrayList<>();
        list.add(new Animal("Pattinson", Animal.Type.CAT, Animal.Sex.F, 1, 10, 90, true));
        list.add(new Animal("Barselona", Animal.Type.DOG, Animal.Sex.M, 2, 5, 40, true));
        list.add(new Animal("Astana", Animal.Type.CAT, Animal.Sex.F, 3, 9, 2, true));

        Map<Animal.Type, Long> result = Task3.typeCounter(list);

        assertThat(result.get(Animal.Type.CAT)).isEqualTo(2L);
        assertThat(result.get(Animal.Type.DOG)).isEqualTo(1L);
    }
}
