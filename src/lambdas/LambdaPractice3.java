package lambdas;

public class LambdaPractice3 {
  public static void main(String[] args) {
    LengthOfString len = (str) -> str.length(); // String::length
    System.out.println(len.length("abc"));
  }

  @FunctionalInterface
  interface LengthOfString {
    int length(String s);
  }
}
