package ui.commands;

import ui.Console;

public class DelToy extends Command{
    public DelToy(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Удалить игрушку";
    }

    @Override
    public void execute() {
        getConsole().delToy();
    }
}
