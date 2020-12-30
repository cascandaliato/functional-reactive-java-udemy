package data_structures;

public class TreeDemo {
  public static void main(String[] args) {
    TreeFun<Integer> t = TreeFun.tree(23, 5, 76, 10, 3, 45);
    t = t.remove(10);
    System.out.println(t);

    System.out.println("---");

    System.out.println(t.isMember(45));
    System.out.println(t.isMember(50));

    System.out.println("---");

    System.out.println(t.max());
  }
}
