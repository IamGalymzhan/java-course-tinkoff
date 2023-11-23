package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    private Task5() {
    }

    public static boolean isCorrectLicensePlate(String plate) {
        Pattern pattern = Pattern.compile("^[ABEKMHOPCTYXАВЕКМНОРСТУХ]\\d{3}[ABEKMHOPCTYXАВЕКМНОРСТУХ]{2}\\d{2,3}$");
        Matcher matcher = pattern.matcher(plate);
        return matcher.find();
    }
}
