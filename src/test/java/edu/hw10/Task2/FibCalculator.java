package edu.hw10.Task2;

public interface FibCalculator {
    @Cache()
    public int fib(int number);
}
