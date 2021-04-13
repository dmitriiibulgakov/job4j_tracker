package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortByNameDescTest {
    @Test
    public void testCompare() {
        Item item1 = new Item("CBC");
        Item item2 = new Item("ABC");
        Item item3 = new Item("BBC");
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item3);
        expected.add(item2);
        items.sort(new SortByNameDesc());

        assertThat(items, is(expected));
    }
}
