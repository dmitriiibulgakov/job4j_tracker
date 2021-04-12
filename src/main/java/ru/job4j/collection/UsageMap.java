package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("bulgakovdg@mail.ru", "Bulgakov D.G.");
        for (String key: map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
