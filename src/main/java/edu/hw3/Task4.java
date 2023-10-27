package edu.hw3;

import java.util.List;
import java.util.Map;
import static java.util.Map.entry;

public class Task4 {

    private Task4() {

    }

    private static final List<Map.Entry<Integer, String>> DICT = List.of(
        entry(1000, "M"),
        entry(900, "CM"),
        entry(500, "D"),
        entry(400, "CD"),
        entry(100, "C"),
        entry(90, "XC"),
        entry(50, "L"),
        entry(40, "XL"),
        entry(10, "X"),
        entry(9, "IX"),
        entry(5, "V"),
        entry(5, "V"),
        entry(4, "IV"),
        entry(1, "I")
    );

    public static String convertToRoman(int value) {
        StringBuilder roman = new StringBuilder();

        int val = value;
        while (val > 0) {
            for (var x : DICT) {
                if (val >= x.getKey()) {
                    roman.append(x.getValue());
                    val -= x.getKey();
                    break;
                }
            }
        }
        return roman.toString();
    }
}
