package edu.hw4;

import java.util.List;
import java.util.stream.Collectors;

public class Task9 {
    private Task9() {
    }

    public static int pawsCounter(List<Animal> list) {
        int result = list.stream()
            .collect(Collectors.summingInt(Animal::paws));
        return result;
    }
}
