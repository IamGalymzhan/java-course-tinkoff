package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Task1 {
    private Task1() {
    }

    @SuppressWarnings("MagicNumber")
    private static LocalDateTime parseTime(String time) {
        int year = Integer.parseInt(time.substring(0, 4));
        int month = Integer.parseInt(time.substring(5, 7));
        int day = Integer.parseInt(time.substring(8, 10));
        int hour = Integer.parseInt(time.substring(12, 14));
        int minute = Integer.parseInt(time.substring(15, 17));
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    @SuppressWarnings("MagicNumber")
    public static Duration averageSessionDuration(List<String> sessions) {
        Duration total = Duration.ofNanos(0);
        for (var session : sessions) {
            total = total.plus(Duration.between(
                parseTime(session.substring(0, 17)),
                parseTime(session.substring(20, 37))
            ));
        }
        total = total.dividedBy(sessions.size());
        return total;
    }
}
