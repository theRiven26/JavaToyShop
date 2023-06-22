package ui.commands;

import ui.Console;

public class EditFrequency extends Command{

    public EditFrequency(Console console){
        super(console);
    }
    @Override
    public String getDescription() {
        return "Изменить частоту выпадания игрушки";
    }

    @Override
    public void execute() {
        this.getConsole().editFrequency();
    }
}
