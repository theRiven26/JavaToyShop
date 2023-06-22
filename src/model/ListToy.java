package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = ShopToy.class, name = "shopToy"),
                @JsonSubTypes.Type(value = GiveawayToys.class, name = "giveaway"),
        })
public abstract class ListToy<E extends Toy> implements Serializable, Iterable<E> {
    private List<E> list;

    public ListToy(List list){
        this.list = list;
    }

    public ListToy(){
        this.list = new ArrayList<>();
    }
    public void addToy(E toy){
        list.add(toy);
    }
    public Iterator<E> iterator(){
        return new IteratorShop<>(list);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        List<E> list = this.list;
        for (E toy: list){
            stringBuilder.append("Индекс: " + list.indexOf(toy) + "; ");
            stringBuilder.append(toy.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void delToy(int id){
        list.remove(id);
    }

    public Toy getByID(int id){
        return list.get(id);
    }

    public List<E> getList(){
            return list;
    }


}
