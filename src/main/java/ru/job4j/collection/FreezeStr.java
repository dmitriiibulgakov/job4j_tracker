package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character letter: left.toCharArray()) {
            map.computeIfPresent(letter, (k, v) -> v + 1);
            map.putIfAbsent(letter, 1);
        }

        for (Character chr: right.toCharArray()) {
            if (map.containsKey(chr)) {
                int val = map.get(chr);
                if (val == 1) {
                    map.remove(chr);
                } else {
                    map.put(chr, val - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
}
