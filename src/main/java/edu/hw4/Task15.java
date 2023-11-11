package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task15 {
    private Task15() {
    }

    public static Map<Animal.Type, Integer> weighSumByTypeWithinAge(List<Animal> list, int k, int l) {
        Map<Animal.Type, Integer> result = list.stream()
            .filter(x -> (x.age() >= k && x.age() <= l))
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
        return result;
    }
}
