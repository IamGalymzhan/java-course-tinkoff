package edu.hw5;

public class Task6 {
    private Task6() {
    }

    public static boolean isSubsequence(String sequence, String subsequence) {
        String regexp = ".*" + String.join(".*", subsequence.split("")) + ".*";
        return sequence.matches(regexp);
    }
}
