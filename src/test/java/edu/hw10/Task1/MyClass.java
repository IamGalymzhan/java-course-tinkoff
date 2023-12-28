package edu.hw10.Task1;

public class MyClass {
    private int int1;
    String string1;

    private MyClass(int int1, String string1) {
        this.int1 = int1;
        this.string1 = string1;
    }

    public String getString1() {
        return string1;
    }

    public int getInt1() {
        return int1;
    }

    public static MyClass create(@Min(1) @Max(10) int int1, @NotNull String string1) {
        return new MyClass(int1, string1);
    }

    @Override public String toString() {
        return "MyClass{" +
            "int1=" + int1 +
            ", string1='" + string1 + '\'' +
            '}';
    }
}
