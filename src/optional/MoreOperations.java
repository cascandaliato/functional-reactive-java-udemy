package optional;

import java.util.Optional;

public class MoreOperations {
  public static void main(String[] args) {
    Optional<String> optional = Optional.of("value");
    //    Optional<String> optional = Optional.empty();

    // ifPresent
    optional.ifPresent(System.out::println);

    // ifPresentOrElse
    optional.ifPresentOrElse(System.out::println, () -> System.out.println("empty..."));

    // stream
    optional.stream().forEach(System.out::println);
    Optional.empty().stream().forEach(System.out::println);

    // or
    optional
        .or(() -> Optional.of("foo"))
        .ifPresentOrElse(System.out::println, () -> System.out.println("empty..."));
    ;
    Optional.empty()
        .or(() -> Optional.of("bar"))
        .ifPresentOrElse(System.out::println, () -> System.out.println("empty..."));
    ;

    // equals
    System.out.println(optional.equals(Optional.of("value")));
    System.out.println(optional.equals(Optional.empty()));

    // hashcode
    System.out.println(optional.hashCode());
  }
}
