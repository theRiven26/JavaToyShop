package ui.commands;

import ui.Console;

public class GiveToy extends Command{
    public GiveToy(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Выдать игрушку";
    }

    @Override
    public void execute() {
        getConsole().giveToy();
    }
}
