package edu.hw5;

public class Task7 {
    private Task7() {
    }

    public static boolean check1(String string) {
        return string.matches("^[01]{2}0[01]*$");
    }

    public static boolean check2(String string) {
        return string.matches("(0.*0)|(1.*1)");
    }

    public static boolean check3(String string) {
        return string.matches("^[01]{1,3}$");
    }
}
