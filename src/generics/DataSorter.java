package generics;

import java.util.List;

public class DataSorter<T extends Number> {
  private List<T> list;

  public DataSorter(List<T> list) {
    this.list = list;
  }

  public void getSortedData() {
    list.sort(null);
    for (T t : list) {
      System.out.println(t);
    }
  }
}
