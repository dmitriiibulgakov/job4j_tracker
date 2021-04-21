package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        int index = -1;
        out.println("Menu.");
        for (UserAction action: actions) {
            out.println(++index + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        Output consoleOutput = new ConsoleOutput();
        Input input = new ValidateInput(consoleOutput, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(consoleOutput));
        actions.add(new CreateAction(consoleOutput));
        actions.add(new ShowAllAction(consoleOutput));
        actions.add(new EditAction(consoleOutput));
        actions.add(new FindByIdAction(consoleOutput));
        actions.add(new FindByNameAction(consoleOutput));
        actions.add(new DeleteAction(consoleOutput));
        actions.add(new ExitAction());
        new StartUI(consoleOutput).init(input, tracker, actions);
    }
}
