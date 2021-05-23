package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Introduce {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-5, 1, -3, 3, 5);
        List<Integer> filteredList = list.stream().filter(num -> num > 0).collect(Collectors.toList());
        filteredList.forEach(System.out::println);
    }
}
