package edu.hw4;

import java.util.List;

public class Task11 {
    private Task11() {
    }

    private static final int MIN_HEIGHT = 100;

    public static List<Animal> bitingHighAnimals(List<Animal> list) {
        List<Animal> result = list.stream()
            .filter(x -> (x.height() > MIN_HEIGHT && x.bites()))
            .toList();
        return result;
    }
}
