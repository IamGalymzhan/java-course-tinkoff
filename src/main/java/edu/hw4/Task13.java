package edu.hw4;

import java.util.List;

public class Task13 {
    private Task13() {
    }

    public static List<Animal> longNames(List<Animal> list) {
        List<Animal> result = list.stream()
            .filter(x -> (x.name().split(" ").length > 2))
            .toList();
        return result;
    }
}
