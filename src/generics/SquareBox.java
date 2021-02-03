package generics;

import java.util.List;

public class SquareBox<T> extends Box<T> {
  public SquareBox(List<T> a) {
    super(a);
  }
}
