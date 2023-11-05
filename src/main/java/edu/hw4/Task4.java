package edu.hw4;

import java.util.List;
import java.util.stream.Stream;

public class Task4 {
    private Task4() {
    }

    public static Animal longestName(List<Animal> list) {
        Stream<Animal> stream = list.stream();
        Animal result = stream.max((o1, o2) -> o1.name().length() - o2.name().length()).get();
        return result;
    }
}
