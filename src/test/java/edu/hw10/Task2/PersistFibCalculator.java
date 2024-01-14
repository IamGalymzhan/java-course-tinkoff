package edu.hw10.Task2;

public interface PersistFibCalculator {
    @Cache(persist = true)
    public int fib(int number);
}
