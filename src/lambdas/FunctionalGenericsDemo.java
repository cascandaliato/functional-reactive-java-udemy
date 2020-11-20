package lambdas;

public class FunctionalGenericsDemo {
  public static void main(String[] args) {
    FunctionalGenerics<String, String> funGen1 = s -> s.substring(1, 5);
    System.out.println(funGen1.execute("foobarbaz"));

    FunctionalGenerics<String, Integer> funGen2 = s -> s.length();
    System.out.println(funGen2.execute("foobarbaz"));
  }
}
