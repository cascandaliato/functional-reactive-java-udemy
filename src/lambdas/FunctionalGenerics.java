package lambdas;

@FunctionalInterface
public interface FunctionalGenerics<T, R> {
  R execute(T t);
}
