package fun;

import java.util.function.Function;

public class Currying {
  public static void main(String[] args) {
    Function<Integer, Function<Integer, Integer>> fun1 = u -> v -> u + v;

    Function<Integer, Integer> fun2 = fun1.apply(1);

    Integer sum = fun2.apply(2);

    System.out.println(sum);

    System.out.println(fun1.apply(1).apply(2));

    Function<Integer, Function<Integer, Function<Integer, Integer>>> f = u -> v -> w -> u + v + w;
    System.out.println(f.apply(1).apply(2).apply(3));
  }
}
