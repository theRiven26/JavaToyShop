package model.fileWork;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.ListToy;
import model.Toy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadUnloadFiles implements Writable {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean save(List list, String fileAddress) {
        try{
            File file = new File(fileAddress);
            objectMapper.writeValue(file, list);
            objectMapper.writeValue(file, "\n");
            return true;

        }
        catch (IOException t){
            return false;
        }
    }

    @Override
    public  List<Toy> read(String fileAddress) throws IOException{
        List<Toy> newList = new ArrayList<Toy>();
        try {
            File file = new File(fileAddress);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
             newList = objectMapper.readValue(file, new TypeReference<List<Toy>>(){});
           // ListToy newList = new ListToy(list) {};
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return newList;
    }


}
