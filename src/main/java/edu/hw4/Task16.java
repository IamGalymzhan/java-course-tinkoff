package edu.hw4;

import java.util.List;

public class Task16 {
    private Task16() {
    }

    public static List<Animal> sortByTypeSexName(List<Animal> list) {
        List<Animal> result = list.stream()
            .sorted((o1, o2) -> {
                if (o1.type() != o2.type()) {
                    return o1.type().toString().compareTo(o2.type().toString());
                }
                if (o1.sex() != o2.sex()) {
                    return o1.sex().toString().compareTo(o2.sex().toString());
                }
                return o1.name().compareTo(o2.name());
            })
            .toList();
        return result;
    }
}
