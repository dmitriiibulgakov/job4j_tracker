package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    private static final String DOT = "\\.";

    @Override
    public int compare(String left, String right) {
        return Integer.compare(Integer.parseInt(left.split(DOT)[0]),
                Integer.parseInt(right.split(DOT)[0]));
    }
}
