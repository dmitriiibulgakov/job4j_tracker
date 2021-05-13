package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Article {
    private static final String BY_WORDS = "[^а-яА-Яa-zA-Z]+";

    public static boolean generateBy(String origin, String line) {
        Set<String> stringSet = new HashSet<>(List.of(origin.split(BY_WORDS)));
        int size = stringSet.size();
        stringSet.addAll(List.of(line.split(BY_WORDS)));

        return size == stringSet.size();
    }
}
