package fun;

public interface IConfigurator<T, R> {
  R configure(T t);
}
