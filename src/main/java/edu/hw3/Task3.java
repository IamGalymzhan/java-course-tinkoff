package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    private Task3() {
    }

    public static Map freqDict(List list) {
        HashMap<Object, Integer> dictionary = new HashMap();
        for (var x : list) {
            if (dictionary.containsKey(x)) {
                dictionary.put(x, dictionary.get(x) + 1);
            } else {
                dictionary.put(x, 1);
            }
        }
        return dictionary;
    }
}
