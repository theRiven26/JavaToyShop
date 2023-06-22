package ui.commands;
import ui.Console;

public class AddToy extends Command{

    public AddToy(Console console){
        super(console);
    }


    public String getDescription() {
        return "Добавить новую игрушку";
    }


    public void execute() {
        getConsole().addToy();
    }
}
