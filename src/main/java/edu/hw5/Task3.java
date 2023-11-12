package edu.hw5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class Task3 {
    private Task3() {
    }

    @SuppressWarnings("MagicNumber")
    public static Optional<LocalDate> parseDate(String string) {
        Optional<LocalDate> result = Optional.empty();
        if (string.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
            int year = Integer.parseInt(string.substring(0, 4));
            int month = Integer.parseInt(string.substring(5, string.lastIndexOf('-')));
            int day = Integer.parseInt(string.substring(string.lastIndexOf('-') + 1));
            result = Optional.of(LocalDate.of(year, month, day));
        } else if (string.matches("\\d{1,2}/\\d{1,2}/\\d{2,4}")) {
            int year = Integer.parseInt(string.substring(string.lastIndexOf('/') + 1));
            if (year < 100) {
                year += 2000;
            }
            int month = Integer.parseInt(string.substring(string.indexOf('/') + 1, string.lastIndexOf('/')));
            int day = Integer.parseInt(string.substring(0, string.indexOf('/')));
            result = Optional.of(LocalDate.of(year, month, day));
        } else if (string.toLowerCase().equals("tomorrow")) {
            result = Optional.of(LocalDate.now().plus(1, ChronoUnit.DAYS));
        } else if (string.toLowerCase().equals("today")) {
            result = Optional.of(LocalDate.now());
        } else if (string.toLowerCase().equals("yesterday")) {
            result =  Optional.of(LocalDate.now().minus(1, ChronoUnit.DAYS));
        } else if (string.matches("\\d+ day(s?) ago")) {
            int days = Integer.parseInt(string.substring(0, string.indexOf(' ')));
            result =  Optional.of(LocalDate.now().minus(days, ChronoUnit.DAYS));
        }
        return result;
    }
}
