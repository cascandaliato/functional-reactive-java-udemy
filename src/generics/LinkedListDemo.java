package generics;

public class LinkedListDemo {
  public static void main(String[] args) {
    DataNode<Integer> node2i = new DataNode<>(20, null);
    DataNode<Integer> node1i = new DataNode<>(35, node2i);

    DataNode<Double> node2d = new DataNode<>(20.9, null);
    DataNode<Double> node1d = new DataNode<>(35.8, node2d);

    DataNode<Number> node1n = new DataNode<>(35.8, node2d);
    System.out.println(node1i);
    System.out.println(node1d);
    System.out.println(node1n);
  }
}
