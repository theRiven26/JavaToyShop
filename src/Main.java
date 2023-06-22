import model.GiveawayToys;
import model.ListToy;
import model.ShopToy;
import model.Toy;
import model.fileWork.LoadUnloadFiles;
import presenter.Presenter;
import ui.Console;
import ui.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static <E extends Toy> void main(String[] args) throws Exception {
        View view = new Console();
        String fileAddress = "ShopToy.json";
        String fileAddressGiveaway = "GiveawayList.json";
        ListToy shopToy = new ShopToy<>();
        ListToy giveawayToys = new GiveawayToys<>();
        Presenter presenter = new Presenter(view, shopToy, giveawayToys, fileAddress, fileAddressGiveaway);
        view.start();
    }
}