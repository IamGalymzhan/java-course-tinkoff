package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task6 {
    private Task6() {
    }

    public static Map<Animal.Type, Animal> heaviestByType(List<Animal> list) {
        Map<Animal.Type, Animal> result = list.stream()
            .collect(Collectors.groupingBy(Animal::type,
                Collectors.maxBy(((o1, o2) -> (int) (o1.weight() - o2.weight())))))
            .entrySet().stream().collect(Collectors.toMap(p -> p.getKey(), t -> t.getValue().get()));
        return result;
    }
}
