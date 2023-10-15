package edu.hw1;

public class Task2 {

    private Task2() {
    }

    private static final int BASE = 10;

    public static int countDigits(int number) {
        int count = 1;
        int numberCopy = Math.abs(number);
        while (numberCopy >= BASE) {
            numberCopy /= BASE;
            count++;
        }
        return count;
    }
}
