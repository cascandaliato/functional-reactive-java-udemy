package generics;

public class GenericMethod {

  public static <T> String concat(T data) {
    return "Data is " + data;
  }

  public static void main(String[] args) {
    System.out.println(concat("FooBar"));
    System.out.println(concat(42));
  }
}
