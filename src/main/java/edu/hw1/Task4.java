package edu.hw1;

public class Task4 {
    private Task4() {

    }

    public static String fixString(String str) {
        String res = "";
        for (int i = 0; i < str.length() - 1; i += 2) {
            res += (str.substring(i + 1, i + 2) + str.substring(i, i + 1));
        }
        if (str.length() % 2 == 1) {
            res += str.substring(str.length() - 1);
        }
        return res;
    }
}
