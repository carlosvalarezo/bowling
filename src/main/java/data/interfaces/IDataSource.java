package data.interfaces;

import java.util.List;

public interface IDataSource<T>{
    List<T> readData(Object source);
}