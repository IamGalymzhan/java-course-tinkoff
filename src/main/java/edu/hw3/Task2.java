package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

    private Task2() {
    }

    public static List clusterize(String sequence) {
        int balance = 0;
        int pointer = 0;
        List list = new ArrayList<>();

        for (int i = 0; i < sequence.length(); ++i) {
            if (sequence.charAt(i) == '(') {
                balance++;
            } else if (sequence.charAt(i) == ')') {
                balance--;
            } else {
                throw new RuntimeException("Sequence contains non brace elements");
            }
            if (balance < 0) {
                throw new RuntimeException("Sequence is not correct");
            }
            if (balance == 0) {
                list.add(sequence.substring(pointer, i + 1));
                pointer = i + 1;
            }
        }
        return list;
    }
}
