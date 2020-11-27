package fun;

@FunctionalInterface
public interface Consumer<T> {
  void accept(T t);

  default Consumer<T> thenAccept(Consumer<T> c2) {
    return t -> {
      this.accept(t);
      c2.accept(t);
    };
  }
}
