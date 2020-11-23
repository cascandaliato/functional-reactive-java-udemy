package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PracticePredicate {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("foo");
    list.add("");
    list.add("bar");
    list.add("");
    list.add("foobar");

    Predicate<String> predicate = s -> !s.isEmpty();
    List<String> newList = filterList(list, predicate);
    System.out.println(newList);

    Predicate<String> filter = s -> s.contains("foo");
    List<String> filteredList = filterList(list, filter);
    System.out.println(filteredList);

    List<Integer> intList = List.of(1, 4, 6, 7, 8);
    Predicate<Integer> integerFilter = e -> e % 2 == 0;
    System.out.println(filterList(intList, integerFilter));
  }

  private static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
    List<T> newList = new ArrayList<>();
    for (T string : list) {
      if (predicate.test(string)) {
        newList.add(string);
      }
    }
    return newList;
  }
}
