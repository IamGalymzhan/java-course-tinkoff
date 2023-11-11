package edu.hw4;

import java.util.List;

public class Task10 {
    private Task10() {
    }

    public static List<Animal> agePawsDifferent(List<Animal> list) {
        List<Animal> result = list.stream()
            .filter(x -> (x.paws() != x.age()))
            .toList();
        return result;
    }
}
