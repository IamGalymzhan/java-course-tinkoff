package edu.hw4;

import java.util.List;
import java.util.stream.Collectors;

public class Task17 {
    private Task17() {
    }

    public static Boolean isSpidersBitesMoreThanDogs(List<Animal> list) {
        var map = list.stream()
            .filter(x -> (x.type() == Animal.Type.DOG || x.type() == Animal.Type.SPIDER) && x.bites())
            .collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
        if (map.get(Animal.Type.DOG) == null) {
            return false;
        }
        if (map.get(Animal.Type.SPIDER) == null) {
            return false;
        }

        return map.get(Animal.Type.SPIDER) > map.get(Animal.Type.DOG);
    }
}
