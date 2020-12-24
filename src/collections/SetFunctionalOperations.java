package collections;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SetFunctionalOperations {
  public static void main(String[] args) {
    Set<Integer> set = Set.of(3, 56, 7, 82, 39);

    // Traversal
    set.forEach(System.out::println);

    System.out.println("---");

    // Filter
    set.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

    System.out.println("---");

    // Sorting
    set.stream().sorted().forEach(System.out::println);

    System.out.println("---");

    set.stream().collect(Collectors.toCollection(TreeSet::new)).forEach(System.out::println);
    //    new TreeSet<>(set).forEach(System.out::println);

    // Map
    Set<Double> hashSet = set.stream().map(Double::valueOf).collect(Collectors.toSet());
    hashSet.forEach(System.out::println);

    System.out.println("---");

    // Reduce
    System.out.println(set.stream().mapToInt(e -> e).sum());
  }
}
