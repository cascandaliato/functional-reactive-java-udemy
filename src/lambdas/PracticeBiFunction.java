package lambdas;

import java.util.function.BiFunction;

public class PracticeBiFunction {
  public static void main(String[] args) {
    //    BiFunction<String, String, Integer> biFunction = (a, b) -> (a + b).length();
    BiFunction<String, String, Integer> biFunction = AClass::staticMethod;
    System.out.println(biFunction.apply("foo", "bar"));
  }

  private static class AClass {
    static Integer staticMethod(String a, String b) {
      return (a + b).length();
    }
  }
}
