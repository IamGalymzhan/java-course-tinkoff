package edu.hw10.Task2;

public class DefaultFibCalculator implements FibCalculator {
    @Override
    public int fib(int number) {
        if (number <= 2) {
            return 1;
        }
        return fib(number - 1) + fib(number - 2);
    }
}
