package model;

import java.io.Serializable;

public class Toy implements Serializable {

    private String name;
    private int count;
    private int frequency;

    public Toy(String name, int count, int frequency){
        this.name = name;
        this.count = count;
        this.frequency = frequency;
    }

    public Toy(){
        this("",0,0);
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Наименование: " + name );
        stringBuilder.append("; ");
        stringBuilder.append("Количество: " + count);
        stringBuilder.append("; ");
        stringBuilder.append("Частота: " + frequency);
        stringBuilder.append("; ");
        return stringBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }


    public boolean equals(Toy obj) {
        return this.name == obj.name;
    }
}
