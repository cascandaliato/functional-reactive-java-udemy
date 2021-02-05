package generics;

import java.util.Arrays;
import java.util.List;

interface IBound1 {}

interface IBound2 {}

class CBound implements IBound1, IBound2 {}

public class BoundedT {
  public static void main(String[] args) {
    List<Integer> intList = Arrays.asList(new Integer[] {2, 5, 8, 9});
    List<Double> dblList = Arrays.asList(new Double[] {1.0, 2.0, 3.0});
    //    List<String> strList = Arrays.asList(new String[] {"foo", "bar", "baz"});
    DataSorter<Integer> intSorter = new DataSorter<>(intList);
    DataSorter<Double> dblSorter = new DataSorter<>(dblList);
    //    DataSorter<String> strSorter = new DataSorter<>(strList);

    intSorter.getSortedData();
    dblSorter.getSortedData();
    //    strSorter.getSortedData();

    //    getSortedData(intSorter);

    CBound b = new CBound();
    getSortedData(b);
  }

  public static <T extends IBound1 & IBound2> void getSortedData(T list) {
    //    list.sort(null);
    //    for (T t : list) {
    //      System.out.println(t);
    //    }
  }
}
