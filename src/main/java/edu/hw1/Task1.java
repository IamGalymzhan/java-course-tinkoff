package edu.hw1;

public class Task1 {

    private Task1() {
    }

    private final static int SECONDS_IN_MINUTES = 60;

    public static int minutesToSeconds(String time) {
        if (!time.matches("\\d+:\\d{2}")) {
            return -1;
        }
        int minutesPointer = time.length() - 2;
        int seconds = Integer.parseInt(time.substring(minutesPointer));
        int minutes = Integer.parseInt(time.substring(0, minutesPointer - 1));
        int totalSeconds = minutes * SECONDS_IN_MINUTES + seconds;

        if (seconds >= SECONDS_IN_MINUTES) {
            return -1;
        }
        return totalSeconds;
    }
}
