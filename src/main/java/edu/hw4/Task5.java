package edu.hw4;

import java.util.List;
import java.util.stream.Collectors;

public class Task5 {
    private Task5() {
    }

    public static Animal.Sex mostPopularSex(List<Animal> list) {
        Animal.Sex result = list.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()))
            .entrySet().stream()
            .max((o1, o2) -> (int) (o1.getValue() - o2.getValue()))
            .get().getKey();
        return result;
    }
}
