package ui.commands;

import ui.Console;

public class Giveaway extends Command {
    public Giveaway(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Разыграть игрушки";
    }

    @Override
    public void execute() {
        getConsole().giveaway();
    }
}
