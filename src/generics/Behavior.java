package generics;

import java.util.ArrayList;

public class Behavior {
  public static void main(String[] args) {
    ArrayList<String> l = new ArrayList<>();
    l.add("John");
    method(l);
    System.out.println(l);
  }

  public static void method(ArrayList l) {
    l.add(10);
    l.add("Bar");
    l.add(true);
  }
}
