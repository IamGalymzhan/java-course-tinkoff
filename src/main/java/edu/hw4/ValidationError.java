package edu.hw4;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ValidationError {
    private String errorField;
    private String errorMessage;

    public ValidationError(String errorField, String errorMessage) {
        this.errorField = errorField;
        this.errorMessage = errorMessage;
    }

    public static Set<ValidationError> validateAnimal(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();
        if (animal.name() == null || animal.name().isEmpty()) {
            errors.add(new ValidationError("name", "Name cannot be empty"));
        }
        if (animal.age() < 0) {
            errors.add(new ValidationError("age", "Age cannot be negative"));
        }
        if (animal.weight() < 0) {
            errors.add(new ValidationError("weight", "Weight cannot be negative"));
        }
        if (animal.weight() == 0) {
            errors.add(new ValidationError("weight", "Weight cannot be zero"));
        }
        if (animal.height() < 0) {
            errors.add(new ValidationError("height", "Height cannot be negative"));
        }
        if (animal.height() == 0) {
            errors.add(new ValidationError("height", "Height cannot be zero"));
        }
        return errors;
    }

    @Override public String toString() {
        return "ValidationError{" +
            "errorField='" + errorField + '\'' +
            ", errorMessage='" + errorMessage + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object obj) {
        ValidationError o = (ValidationError) obj;
        return o.errorField.equals(this.errorField) && o.errorMessage.equals(this.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorField, errorMessage);
    }
}
