package generics;

import java.util.ArrayList;

public class CollectionDemo {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();

    list.add("John");
    //    list.add(1);

    //    for (Object o : list) {
    //      String str = (String) o;
    for (String o : list) {
      String str = o;
      System.out.println(str);
    }
  }
}
