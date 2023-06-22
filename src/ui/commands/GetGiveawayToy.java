package ui.commands;

import ui.Console;

public class GetGiveawayToy extends Command{
    public GetGiveawayToy(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Открыть список разагранных игрушек";
    }

    @Override
    public void execute() {
        getConsole().getGiveawayList();
    }
}
