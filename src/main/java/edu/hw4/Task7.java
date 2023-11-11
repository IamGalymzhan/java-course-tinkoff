package edu.hw4;

import java.util.List;

public class Task7 {
    private Task7() {
    }

    public static Animal kthOldAnimal(List<Animal> list, int k) {
        Animal result = list.stream()
            .sorted((o1, o2) -> o2.age() - o1.age())
            .toList().get(k);
        return result;
    }
}
