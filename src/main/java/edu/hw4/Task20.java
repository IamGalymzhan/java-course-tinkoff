package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task20 {
    private Task20() {
    }

    public static Map<String, String> validateAnimals(List<Animal> list) {
        Map<String, String> result = list.stream()
            .collect(Collectors.toMap(Animal::toString, x -> {
                var errors = ValidationError.validateAnimal(x);
                String errorsToString = "";
                for (var error : errors) {
                    errorsToString += error.toString() + "\n";
                }
                return errorsToString;
            }));
        return result;
    }
}
