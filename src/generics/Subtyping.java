package generics;

import java.util.ArrayList;
import java.util.List;

public class Subtyping {
  public static void main(String[] args) {
    Object o = new Object();
    Integer i = Integer.valueOf(11);
    o = i;

    List<Number> list = new ArrayList<>();
    list.add(Integer.valueOf(10));
    list.add(Double.valueOf(10.5));
    //    list.add("foo");

    List<Box<Integer>> bList = new ArrayList<>();
    bList.add(new Box<Integer>(List.of(2, 3, 5)));
    bList.add(new SquareBox<>(List.of(7, 11, 13)));
  }
}
