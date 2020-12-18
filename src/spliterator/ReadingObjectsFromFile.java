package spliterator;

import streams.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ReadingObjectsFromFile {
  public static void main(String[] args) {
    Path path = Paths.get("books.txt");
    try (Stream<String> lines = Files.lines(path)) {
      Spliterator<String> baseSpliterator = lines.spliterator();
      Spliterator<Book> spliterator = new BooksSpliterator(baseSpliterator);

      Stream<Book> bookStream = StreamSupport.stream(spliterator, false);
      bookStream.forEach(System.out::println);
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
