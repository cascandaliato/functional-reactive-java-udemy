package optional;

import java.util.Optional;

public class Unwrap {
  public static void main(String[] args) {
    Integer a = 10;
    Optional<Integer> optional = Optional.of(a);

    // get
    Integer integerVal = optional.get();
    System.out.println(integerVal);

    Optional<Object> emptyOptional = Optional.empty();
    //    emptyOptional.get();

    // isPresent
    Integer val = emptyOptional.isPresent() ? optional.get() : 0;
    System.out.println(val);

    // orElse
    Integer orElse = optional.orElse(0);
    System.out.println(orElse);

    // orElseGet
    Object orElseGet = emptyOptional.orElseGet(() -> 0);
    System.out.println(orElseGet);

    // orElseThrow
    //    emptyOptional.orElseThrow(IllegalArgumentException::new);
    //    emptyOptional.orElseThrow();
  }
}
