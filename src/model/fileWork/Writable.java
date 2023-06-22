package model.fileWork;

import model.ListToy;
import model.ShopToy;
import model.Toy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Writable {

    boolean save(List list, String fileAddress) throws IOException;

    List<Toy> read(String fileAddress) throws IOException, ClassNotFoundException;
}