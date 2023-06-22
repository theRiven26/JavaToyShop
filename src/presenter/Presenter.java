package presenter;


import model.GiveawayToys;
import model.ListToy;

import model.ShopToy;
import model.Toy;
import model.fileWork.LoadUnloadFiles;
import ui.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Presenter {
    private ListToy shopToy;
    private ListToy giveawayToys;
    private View view;
    private String fileAddress;
    private String fileAddressGiveaway;
    public Presenter(View view,ListToy shopToy,ListToy giveawayToys, String fileAddress, String fileAddressGiveaway) {
        this.view = view;
        this.shopToy = shopToy;
        this.giveawayToys = giveawayToys;
        this.fileAddress = fileAddress;
        this.fileAddressGiveaway = fileAddressGiveaway;
        view.setPresenter(this);
    }

    public void addToy(String name, int count, int frequency)  {
        Toy toy = new Toy(name,count,frequency);
        shopToy.addToy(toy);
        Boolean itSave = saveToFile(shopToy, fileAddress);
    }

    public void addToyToGiveaway(Toy toy){
        giveawayToys.addToy(toy);
        Boolean itSave = saveToFile(giveawayToys, fileAddressGiveaway);
    }

    public boolean saveToFile(ListToy list,String fileAddress) {
        LoadUnloadFiles files = new LoadUnloadFiles();
        return files.save(list.getList(), fileAddress);
    }

    public void readToFileShopToy() throws Exception {
        shopToy = new ShopToy(readToFile(fileAddress)) ;
    }

    public void readToFileGiveawayList() throws Exception {
        giveawayToys = new GiveawayToys(readToFile(fileAddressGiveaway));
    }

    public List readToFile( String fileAddress) throws Exception{
        List list = new ArrayList<>();
        File file = new File(fileAddress);
        if(file.createNewFile()){
            view.print("Файл создан " + fileAddress);
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            if (br.readLine() == null) {
                view.print("Файл пустой");
            }else {
                LoadUnloadFiles files = new LoadUnloadFiles();
                list = files.read(this.fileAddress);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return list;

    }

    public void getShopToy(){
        view.print(shopToy.toString());
    }

    public void editFrequency(int id, int frequency){
        Toy toy = this.getToyByID(id);
        toy.setFrequency(frequency);
        Boolean itSave = saveToFile(shopToy, fileAddress);
    }

    public Toy getToyByID(int id){
        return this.shopToy.getByID(id);
    }
    public void delToyFromShop(int id){
        shopToy.delToy(id);
    }

    public void delToyGiveaway(int id){
        giveawayToys.delToy(id);
    }

    public void giveaway(){
        ShopToy shopToyList = new ShopToy<>(shopToy.getList());
        Toy winer = shopToyList.giveaway();
        giveawayToys.addToy(winer);
        view.print("Выпала игрушка " + winer.toString());
        Boolean isSave = saveToFile(giveawayToys,fileAddressGiveaway);
    }
    public void getGiveawayList(){
        view.print(giveawayToys.toString());
    }

    public void giveToy(int id){
        Toy givToy = giveawayToys.getByID(id);
        givToy.setCount(givToy.getCount() - 1);
        delToyGiveaway(id);
    }
}
