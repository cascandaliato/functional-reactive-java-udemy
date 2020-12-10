package streams;

import java.util.stream.Stream;

public class ReduceOperation {
  public static void main(String[] args) {
    Integer sum = Stream.of(1, 2, 34, 56, 76, 87, 89, 90).reduce(0, Integer::sum);
    System.out.println(sum);
  }
}
