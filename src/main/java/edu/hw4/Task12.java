package edu.hw4;

import java.util.List;
import java.util.stream.Collectors;

public class Task12 {
    private Task12() {
    }

    public static int weightMoreThanHeight(List<Animal> list) {
        int result = (int) (long) list.stream()
            .filter(x -> (x.weight() > x.height()))
            .collect(Collectors.counting());
        return result;
    }
}
