package edu.hw8.Task2;

public class Fibonacci {
    private Fibonacci() {
    }

    public static int calculate(int n) {
        if (n <= 2) {
            return 1;
        }
        return calculate(n - 1) + calculate(n - 2);
    }
}
