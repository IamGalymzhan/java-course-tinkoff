package edu.hw1;

public class Task7 {
    private Task7() {

    }

    private static int bitLength(int n) {
        int result = 0;
        int num = n;
        while (num > 0) {
            num /= 2;
            result++;
        }
        return result;
    }

    public static int rotateLeft(int n, int shift) {
        return ((n << shift) | (n >> (bitLength(n) - shift))) % (int) (Math.pow(2, bitLength(n)));
    }

    public static int rotateRight(int n, int shift) {
        return ((n >> shift) | (n << (bitLength(n) - shift))) % (int) (Math.pow(2, bitLength(n)));
    }
}
