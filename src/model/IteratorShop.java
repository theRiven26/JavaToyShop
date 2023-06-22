package model;

import java.util.Iterator;
import java.util.List;

public class IteratorShop<E> implements Iterator<E> {
    private int index;
    private List<E> shopToy;

    public IteratorShop(List<E> shopToy){
        this.shopToy = shopToy;
    }

    @Override
    public boolean hasNext(){
        return index < shopToy.size();
    }
    @Override
    public E next(){
        return shopToy.get(index++);
    }
}
