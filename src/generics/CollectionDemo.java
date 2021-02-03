package generics;

import java.util.ArrayList;
import java.util.HashMap;

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

    HashMap<Integer, String> map = new HashMap<>();

    Bin<String, Integer> bin = new Bin<>();
    bin.setDryTrash("abc");
    bin.setWetTrash(123);
    System.out.println("Dry Trash: " + bin.getDryTrash());
    System.out.println("Wet Trash: " + bin.getWetTrash());
  }
}
