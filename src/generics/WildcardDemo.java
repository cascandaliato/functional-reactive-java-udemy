package generics;

import java.util.List;

public class WildcardDemo {
  public static void displayData(List<? super Integer> l) {
    for (Object t : l) {
      System.out.println(t);
    }
  }

  public static void main(String[] args) {
    List<Integer> list1 = List.of(2, 3, 5);
    displayData(list1);

    List<Number> list2 = List.of(2, 3.1, 5.7);
    displayData(list2);
  }
}
