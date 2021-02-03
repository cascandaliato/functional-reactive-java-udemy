package generics;

import java.util.List;

public class RawTypeDemo {
  public static void main(String[] args) {
    Box<Integer> genBox = new Box<>(List.of(1, 2, 3));
    for (Integer integer : genBox.getA()) {
      System.out.println(integer);
    }

    Box rawBox = new Box(List.of(4, 5, 6));
    for (Object object : rawBox.getA()) {
      System.out.println(object);
    }
  }
}
