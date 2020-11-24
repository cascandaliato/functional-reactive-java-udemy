package optional;

import java.util.Optional;

public class OptionalCreation {
  public static void main(String[] args) {
    String val = "A string";
    Optional<String> optional = Optional.of(val);

    // empty optional
    Optional<Object> empty = Optional.empty();

    // nullable
    Optional<String> nullable = Optional.ofNullable(val);
    Optional<String> emptyOptional = Optional.ofNullable(null);
  }
}
