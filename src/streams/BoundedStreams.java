package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BoundedStreams {
  public static void main(String[] args) {
    List<Integer> list = List.of(1, 4, 7, 9, 4);
    Stream<Integer> streamIntegers = list.stream();

    Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "three", 4, "four");
    Stream<Map.Entry<Integer, String>> entries = map.entrySet().stream();
    Stream<String> values = map.values().stream();
    Stream<Integer> keys = map.keySet().stream();

    Stream<String> streamStrings = Stream.of("foo", "bar", "baz");

    Integer[] integerArr = {3, 5, 7, 89, 9};
    Stream<Integer> streamFromArray = Arrays.stream(integerArr);
    int[] intArr = {3, 5, 7, 89, 9};
    IntStream intStream = Arrays.stream(intArr);

    Stream.Builder<Object> builder = Stream.builder();
    builder.add(1);
    builder.add(2);
    builder.add(3);
    Stream<Object> builtStream = builder.build();
  }
}
