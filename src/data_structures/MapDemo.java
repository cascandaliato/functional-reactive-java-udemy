package data_structures;

public class MapDemo {
  public static void main(String[] args) {
    MapFun<Integer, String> map = new MapFun<>(5);
    map.put(1, "foo");
    map.put(2, "bar");
    map.put(3, "baz");
    map.display();
  }
}
