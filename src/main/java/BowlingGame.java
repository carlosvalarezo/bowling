import bowling.Game;
import data.Bowler;
import data.DataSourceFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BowlingGame{
    public static void main(String a[]){
        DataSourceFile dataSourceFile = new DataSourceFile();
        List<Bowler> list = dataSourceFile.readData(a[0].toString());

        Map<String, List<Bowler>> result;
        result = list.stream().collect(Collectors.groupingBy(Bowler::getName));
        result.forEach((k, v) -> {
            new Game(k, v.stream()
                    .map(i->new Integer(i.getPins()))
                    .collect(Collectors.toList())).play();
        });
    }
}