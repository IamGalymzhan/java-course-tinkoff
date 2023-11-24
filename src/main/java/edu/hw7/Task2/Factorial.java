package edu.hw7.Task2;

import java.util.stream.IntStream;

public class Factorial {

    private Factorial() {
    }

    public static int fact(int n) {
        return IntStream.range(2, n + 1).parallel().reduce((o1, o2) -> o1 * o2).getAsInt();
    }

}
