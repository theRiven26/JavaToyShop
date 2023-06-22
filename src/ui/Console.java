package ui;


import presenter.Presenter;
import ui.commands.Command;
import java.util.List;
import java.util.Scanner;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;
    public Console(){
        scanner = new Scanner(System.in);
        menu = new Menu(this);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    public void addToy(){
        System.out.println("Введите название игрушки");
        String name = scanner.nextLine();
        System.out.println("Введите количество игрушек");
        int count = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите частоту выпадания игрушки");
        int frequency = Integer.parseInt(scanner.nextLine());
        presenter.addToy(name, count, frequency);

    }

    @Override
    public void start() throws Exception {
        presenter.readToFileShopToy();
        presenter.readToFileGiveawayList();
        while(true){
            menu.print(this);
            String choice = scanner.nextLine();
            if(check(choice)){
                menu.execute(Integer.parseInt(choice));
            }else {
                fail();
            }
        }
    }

    private boolean check(String text){
        return text.matches("[0-9]+") && Integer.parseInt(text) <= menu.getSize() && Integer.parseInt(text) > 0;
    }

    public void printMenu(List<Command> list){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < list.size(); i++){
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(list.get(i).getDescription());
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    private void fail(){
        System.out.println("Неверный ввод");
    }

    public void getShopToy(){
        this.presenter.getShopToy();
    }
    public void editFrequency(){
        System.out.println("Укажите id игрушки");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите частоту");
        int frequency = Integer.parseInt(scanner.nextLine());
        this.presenter.editFrequency(id,frequency);}

    public void delToy(){
        System.out.println("Укажите id игрушки");
        int id = Integer.parseInt(scanner.nextLine());
        this.presenter.delToyFromShop(id);
    }

    public void giveaway(){
        this.presenter.giveaway();
    }

    public void getGiveawayList(){
        this.presenter.getGiveawayList();
    }

    public void giveToy(){
        System.out.println("Укажите id игрушки");
        int id = Integer.parseInt(scanner.nextLine());
        this.presenter.giveToy(id);
    }
}
