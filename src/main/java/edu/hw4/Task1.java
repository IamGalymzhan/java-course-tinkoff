package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Task1 {
    private Task1() {
    }

    public static List<Animal> sortByHeightAsc(List<Animal> list) {
        Stream<Animal> stream = list.stream();
        stream = stream.sorted(Comparator.comparingInt(Animal::height));
        return stream.toList();
    }
}
