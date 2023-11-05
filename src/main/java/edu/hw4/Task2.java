package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Task2 {
    private Task2() {
    }

    public static List<Animal> sortByWeightDesc(List<Animal> list, int k) {
        Stream<Animal> stream = list.stream();
        stream = stream.sorted(Comparator.comparingInt(Animal::weight)).limit(k);
        return stream.toList();
    }
}
