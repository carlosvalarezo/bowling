package data;

import data.interfaces.IDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DataSourceFile implements IDataSource{

    @Override
    public List<Bowler> readData(Object source){    	
        List<Bowler> list = new ArrayList<>();

        try{
            Stream<String> lines = Files.lines(Paths.get(source.toString()));            
            list = lines.map(a -> a.split(" "))
                    .map(array -> new Bowler(array[0],Integer.valueOf(array[1])))
                    .collect(Collectors.toList());
        }
        catch(IOException io){
            io.printStackTrace();
        }        
        return list;

    }
}
