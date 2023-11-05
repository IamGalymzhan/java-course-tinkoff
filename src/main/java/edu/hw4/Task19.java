package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Task19 {
    private Task19() {
    }

    public static Map<String, Set<ValidationError>> validateAnimals(List<Animal> list) {
        Map<String, Set<ValidationError>> result = list.stream()
            .collect(Collectors.toMap(Animal::toString, ValidationError::validateAnimal));
        return result;
    }
}
