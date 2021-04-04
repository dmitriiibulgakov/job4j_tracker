package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit item ====");
        int id = input.askInt("Enter item's id: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);
        out.println(tracker.replace(id, item) ? "Completed successfully" : "Something went wrong");
        return true;
    }
}
