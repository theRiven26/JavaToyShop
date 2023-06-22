package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ShopToy<E extends Toy> extends  ListToy {
      public ShopToy(List<E> shopToy){
            super(shopToy);
      }
      public ShopToy(){
            super(new ArrayList<>());
      }

      public int getSumFrequency(){
            int sum = 0;
            List<E> list = super.getList();
            for (E var: list) {
                 sum += var.getFrequency();
            };
            return sum;
      }

      public Toy giveaway(){
            Random random = new Random();
            int sumFrequency = getSumFrequency();
            int randomNumber = random.nextInt(sumFrequency);
            int accumulatedFrequency = 0;
            Toy winner = null;
            List<E> list = super.getList();
            for(Toy toy : list){
                  if(toy.getCount() > 0) {
                        accumulatedFrequency += toy.getFrequency();
                        if (randomNumber < accumulatedFrequency) {
                              winner = toy;
                              break;
                        }
                  }
            }
            return winner;
      }


}
