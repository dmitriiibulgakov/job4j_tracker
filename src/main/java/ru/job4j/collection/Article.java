package ru.job4j.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String[] originArr = origin.replaceAll("\\p{P}", "").split(" ");
        String[] lineArr = line.split(" ");
        Set<String> check = new HashSet<>();
        Collections.addAll(check, originArr);
        for (String word: lineArr) {
            if (!check.contains(word)) {
                return false;
            }
        }
        return true;
    }
}
