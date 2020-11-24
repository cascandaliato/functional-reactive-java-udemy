package lambdas;

import java.util.function.Supplier;

public class PracticeSupplier {
  public static void main(String[] args) {
    Supplier<String> stringSupplier = () -> "foobar";
    System.out.println(stringSupplier.get());

    //    Supplier<Double> randomNumber = () -> Math.random();
    Supplier<Double> randomNumber = Math::random;
    System.out.println(randomNumber.get());
  }
}
