package edu.hw4;

import java.util.List;

public class Task14 {
    private Task14() {
    }

    public static Boolean isDogHigherThanK(List<Animal> list, int k) {
        Boolean result = list.stream()
            .filter(x -> (x.type() == Animal.Type.DOG && x.height() > k))
            .anyMatch(x -> true);
        return result;
    }
}
