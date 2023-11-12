package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private Task2() {
    }

    private static final int MONTHS_IN_YEAR = 12;
    private static final int UNLUCKY_NUMBER = 13;

    public static List<LocalDate> allFriday13(int year) {
        List<LocalDate> list = new ArrayList<>();
        for (int month = 1; month <= MONTHS_IN_YEAR; month++) {
            LocalDate date = LocalDate.of(year, month, UNLUCKY_NUMBER);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                list.add(date);
            }
        }
        return list;
    }

    public static LocalDate nextFriday13(LocalDate date) {
        var curDate = date;
        while (curDate.getDayOfWeek() != DayOfWeek.FRIDAY || curDate.getDayOfMonth() != UNLUCKY_NUMBER) {
            curDate = curDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return curDate;
    }
}
