package streams;

import java.util.stream.IntStream;

public class Calculations {
  public static void main(String[] args) {
    System.out.println(IntStream.of(1, 2, 3).sum());
    System.out.println(IntStream.of(1, 2, 3).max().getAsInt());
    System.out.println(IntStream.of().max().orElse(-1));
    System.out.println(IntStream.of(1, 2, 3).min().getAsInt());
    System.out.println(IntStream.of(1, 2, 3).average().getAsDouble());
    System.out.println(IntStream.of(1, 2, 3, 4, 5).summaryStatistics());
  }
}
