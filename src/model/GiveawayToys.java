package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GiveawayToys<E extends Toy> extends ListToy {

   public GiveawayToys(List<E> giveawaylist){
       super(giveawaylist);
   }

   public GiveawayToys(){
       super(new ArrayList<>());
   }

    @Override
    public String toString() {
        return super.toString();
    }
}
