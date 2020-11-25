package optional;

import java.util.Optional;

public class Operations {
  public static void main(String[] args) {
    //    Optional<String> optional = Optional.empty();
    Optional<String> optional = Optional.of("value");

    // map - returns empty if the original optional is empty
    Integer mapped = optional.map(val -> 42).orElse(21);
    System.out.println(mapped);
    //    System.out.println(mapped.get());

    // filter
    Optional<String> filtered = optional.filter(val -> val.equalsIgnoreCase("value"));
    System.out.println(filtered.get());

    // flatMap
    Optional<String> flatMapped = optional.flatMap(val -> Optional.of("replaced"));
    System.out.println(flatMapped.get());
  }
}
