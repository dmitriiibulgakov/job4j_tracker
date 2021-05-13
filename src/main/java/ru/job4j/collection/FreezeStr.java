package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> leftMap = new HashMap<>();
        for (Character letter: left.toCharArray()) {
            leftMap.computeIfPresent(letter, (k, v) -> v + 1);
            leftMap.putIfAbsent(letter, 0);
        }

        Map<Character, Integer> rightMap = new HashMap<>();
        for (Character letter: right.toCharArray()) {
            rightMap.computeIfPresent(letter, (k, v) -> v + 1);
            rightMap.putIfAbsent(letter, 0);
        }

        return leftMap.equals(rightMap);
    }
}
