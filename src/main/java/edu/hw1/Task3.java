package edu.hw1;

public class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] array1, int[] array2) {
        int array1Min = array1[0];
        int array1Max = array1[0];
        int array2Min = array2[0];
        int array2Max = array2[0];
        for (int i = 1; i < array1.length; i++) {
            array1Min = Math.min(array1Min, array1[i]);
            array1Max = Math.max(array1Max, array1[i]);
        }
        for (int i = 1; i < array2.length; i++) {
            array2Min = Math.min(array2Min, array2[i]);
            array2Max = Math.max(array2Max, array2[i]);
        }
        return (array1Min > array2Min && array1Max < array2Max);
    }
}
