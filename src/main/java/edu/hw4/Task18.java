package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Stream.builder;

public class Task18 {
    private Task18() {
    }

    public static Animal heaviestFish(List<Animal>... lists) {
        Stream.Builder<Animal> builder = Stream.builder();
        for (var list : lists) {
            for (Animal x : list) {
                builder.add(x);
            }
        }
        Animal result = builder.build()
            .map(x -> (Animal) x)
            .filter(x -> x.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .get();
        return result;
    }
}
