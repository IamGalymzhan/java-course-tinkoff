package edu.hw5;

public class Task8 {
    private Task8() {
    }

    public static boolean check1(String string) {
        return string.matches("([01][01])*[01]");
    }

    public static boolean check2(String string) {
        return string.matches("(0([01][01])*)|(1([01][01])*[01])");
    }

    public static boolean check3(String string) {
        return string.matches("((1*01*01*01*)*)|(1*)");
    }

    public static boolean check4(String string) {
        return string.matches("^(?!(11|111)$).*");
    }

    public static boolean check5(String string) {
        return string.matches("([01]1)*1?");
    }

    public static boolean check6(String string) {
        return string.matches("(00(0*)1?)|(01?0(0*))|(1?00(0*))");
    }

    public static boolean check7(String string) {
        return string.matches("((0+1)*)|(1(0+)*)");
    }
}
