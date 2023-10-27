package edu.hw3.Task7;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class NullComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Comparable c1 = (Comparable) o1;
        Comparable c2 = (Comparable) o2;
        if (c1 == null && c2 == null) {
            return 0;
        } else if (c1 == null) {
            return -1;
        } else if (c2 == null) {
            return 1;
        } else {
            return c1.compareTo(c2);
        }

    }
}
