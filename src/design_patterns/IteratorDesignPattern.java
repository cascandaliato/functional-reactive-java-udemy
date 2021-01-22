package design_patterns;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorDesignPattern {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();
    list.add("Foo");
    list.add("Bar");
    list.add("Baz");
    Iterator<String> itr = list.iterator();
    System.out.println("List Iterator: " + itr.toString());
    while (itr.hasNext()) System.out.println("List element: " + itr.next());

    Set<String> set = new HashSet<>();
    set.add("Foo");
    set.add("Bar");
    set.add("Baz");
    Iterator<String> setItr = set.iterator();
    System.out.println("Set Iterator: " + setItr.toString());
    while (itr.hasNext()) System.out.println("Set element: " + setItr.next());
  }
}
