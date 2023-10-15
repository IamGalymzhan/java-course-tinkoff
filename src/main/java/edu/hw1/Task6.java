package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private Task6() {

    }

    private static final int KAPREKAR = 6174;
    private static final int NUMBER_LENGTH = 4;
    private static final int RANGE_START = 1001;
    private static final int RANGE_END = 9999;

    private static int charsToInt(char[] array) {
        String str = "";
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            str += array[i];
        }
        return Integer.parseInt(str);
    }

    public static int kaprekarSteps(int num) {
        if (num < RANGE_START || num > RANGE_END) {
            return -1;
        }
        if (num == KAPREKAR) {
            return 0;
        }
        String numString = Integer.toString(num);
        char[] numChars = numString.toCharArray();
        Arrays.sort(numChars);
        int sortedInc = charsToInt(numChars);
        char[] numCharsDec = new char[NUMBER_LENGTH];
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            numCharsDec[i] = numChars[NUMBER_LENGTH - i - 1];
        }
        int sortedDec = charsToInt(numCharsDec);
        int result = sortedDec - sortedInc;
        return kaprekarSteps(result) + 1;
    }
}
