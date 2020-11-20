package lambdas;

public class LambdaPractice2 {
  public static void main(String[] args) {
    MathOperation add = (a, b) -> System.out.println(a + b);
    add.operation(1, 2);

    MathOperation multiply = (a, b) -> System.out.println(a * b);
    multiply.operation(2, 21);
  }

  @FunctionalInterface
  interface MathOperation {
    void operation(int a, int b);
  }
}
