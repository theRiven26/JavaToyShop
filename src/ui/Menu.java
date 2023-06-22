package ui;

import ui.commands.*;

import java.util.ArrayList;
import java.util.List;


public class Menu {
    private List<Command> list;

    public Menu(Console console){
        list = new ArrayList<>();
        list.add(new AddToy(console));
        list.add(new GetShopToy(console));
        list.add(new EditFrequency(console));
        list.add(new DelToy(console));
        list.add(new Giveaway(console));
        list.add(new GetGiveawayToy(console));
        list.add(new GiveToy(console));

    }

    public void print(Console console){
        console.printMenu(this.list);
    }
    public int getSize(){
        return list.size();
    }
    void execute(int choice){
        list.get(choice - 1).execute();
    }
}
