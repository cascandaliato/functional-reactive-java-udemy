package collectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public class CustomCollector {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(2, 6, 8, 9, 0, 1, 52, 5, 61, 8, 9, 96, 0, 18, 23);

    Collector<Integer, List<Integer>, List<Integer>> toList =
        Collector.of(
            ArrayList::new, // supplier
            (list, e) -> list.add(e), // accumulator (bi-consumer)
            (list1, list2) -> {
              list1.addAll(list2);
              return list1;
            }, // combiner (bi-function)
            Collector.Characteristics.IDENTITY_FINISH // finisher (consumer)
            );

    List<Integer> evens = numbers.stream().filter(n -> n % 2 == 0).collect(toList);
    evens.forEach(System.out::println);

    Collector<Integer, List<Integer>, List<Integer>> toSortedList =
        Collector.of(
            ArrayList::new,
            (list, e) -> list.add(e),
            (list1, list2) -> {
              list1.addAll(list2);
              return list1;
            },
            list -> {
              Collections.sort(list);
              return list;
            }, // finisher (function)
            Collector.Characteristics.UNORDERED);
    List<Integer> sortedEvens = numbers.stream().filter(n -> n % 2 == 0).collect(toSortedList);
    sortedEvens.forEach(System.out::println);
  }
}
