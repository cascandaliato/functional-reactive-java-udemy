package lambdas;

public class LambdaPractice4 {
  public static void main(String[] args) {
    LengthOfString len =
        str -> {
          int l = str.length();
          System.out.println("The length of the given string is " + l);
          return l;
        };
    System.out.println(len.length("foo bar"));
  }

  @FunctionalInterface
  interface LengthOfString {
    int length(String s);
  }
}
