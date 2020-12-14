package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapOperation {
  public static void main(String[] args) {
    Stream<String> a = Stream.of("Hello", "world");
    Stream<String> b = Stream.of("foo", "bar");

    Stream<Stream<String>> c = Stream.of(a, b);
    Stream.of(a, b).flatMap(e -> e).forEach(System.out::println);

    Path p = Paths.get("sometext.txt");
    try (Stream<String> lines = Files.lines(p); ) {
      List<String> words =
          lines.flatMap(line -> Arrays.stream(line.split(" "))).collect(Collectors.toList());
      words.forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
    ;
  }
}
