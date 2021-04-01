package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(item.getCreated().format(formatter));

        Tracker tracker = new Tracker();
        tracker.add(new Item("Task number 1"));
        Item item1 = tracker.findById(1);
        System.out.println("ItemId: " + item1.getId() + ". ItemName: " + item1.getName());
        System.out.println(item1.toString());
    }
}
