package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Add new Item" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator() +
                        "=== Create a new Item ====" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Add new Item" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Edit item" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator() +
                        "=== Edit item ====" + System.lineSeparator() +
                        "Completed successfully" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Edit item" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Delete item" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator() +
                        "=== Delete item ====" + System.lineSeparator() +
                        "Completed successfully" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Delete item" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void ShowAllItems() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        tracker.add(item2);
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator() +
                        "=== Show all items ====" + System.lineSeparator() +
                        "Item{id=1, name='item1', created=" + item1.getCreated() + "}" + System.lineSeparator() +
                        "Item{id=2, name='item2', created=" + item2.getCreated() + "}" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void FindByIdItem() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Item item1 = new Item("item1");
        tracker.add(item1);
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item1.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find item by Id" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator() +
                        "=== Find item by Id ====" + System.lineSeparator() +
                        "Item{id=1, name='item1', created=" + item1.getCreated() + "}" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find item by Id" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void FindByNameItems() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Item item1 = new Item("item the best");
        Item item2 = new Item("item2");
        Item item3 = new Item("item the best");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Input in = new StubInput(
                new String[] {"0", item3.getName(), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find items by name" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator() +
                        "=== Find items by name ====" + System.lineSeparator() +
                        "Item{id=1, name='item the best', created=" + item1.getCreated() + "}" + System.lineSeparator() +
                        "Item{id=3, name='item the best', created=" + item3.getCreated() + "}" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find items by name" + System.lineSeparator() +
                        "1. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit Program" + ln
                )
        );
    }
}
