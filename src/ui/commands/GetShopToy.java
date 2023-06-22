package ui.commands;

import ui.Console;

public class GetShopToy extends Command {
    public GetShopToy(Console console){
        super(console);
    }

    @Override
    public String getDescription() {
        return "Открыть список игрушек";
    }

    @Override
    public void execute() {
        this.getConsole().getShopToy();

    }
}
