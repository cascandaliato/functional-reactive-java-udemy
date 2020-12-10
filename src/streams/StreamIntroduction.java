package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntroduction {
  public static void main(String[] args) {
    List<Book> books = new ArrayList<>();
    List<Book> popularHorrorBooks = new ArrayList<>();

    for (Book book : books) {
      if (book.getGenre().equalsIgnoreCase("Horror") && book.getRating() > 3) {
        popularHorrorBooks.add(book);
      }
    }

    // after java 8
    popularHorrorBooks =
        //        books.stream().parallel()
        books.parallelStream() // source
            .filter(b -> b.getGenre().equalsIgnoreCase("Horror")) // intermediate op
            .filter(b -> b.getRating() > 3) // intermediate op
            .collect(Collectors.toList()); // terminal op

    // 1
    Stream<Book> stream = books.stream(); // source

    // 2
    Stream<Book> horrorBooks =
        stream.filter(b -> b.getGenre().equalsIgnoreCase("Horror")); // intermediate op

    // 3
    Stream<Book> phBooks = horrorBooks.filter(b -> b.getRating() > 3); // intermediate op

    // 4
    List<Book> collect = phBooks.collect(Collectors.toList()); // terminal op
  }
}
