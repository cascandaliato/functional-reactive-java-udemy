package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PracticeFunction {
  public static void main(String[] args) {
    List<String> list = List.of("foo", "bar", "foobar", "foobarbaz");
    Function<String, Integer> len = e -> e.length();
    List<Integer> newList = map(list, len);
    System.out.println(newList);
  }

  private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
    List<R> newList = new ArrayList<>();
    for (T element : list) {
      newList.add(function.apply(element));
    }
    return newList;
  }
}
