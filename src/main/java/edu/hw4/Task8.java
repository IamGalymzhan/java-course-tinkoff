package edu.hw4;

import java.util.List;
import java.util.Optional;

public class Task8 {
    private Task8() {
    }

    public static Optional<Animal> heaviestWithinShorterK(List<Animal> list, int k) {
        Optional<Animal> result = list.stream()
            .filter(x -> (x.height() < k))
            .max(((o1, o2) -> o1.weight() - o2.weight()));
        return result;
    }
}
