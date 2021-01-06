package reactive;

import io.reactivex.rxjava3.core.Observable;

public class CreatingObserver {
  public static void main(String[] args) {
    Observable<String> source = Observable.just("Orange", "Black", "Red");

    source.subscribe(
        System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed"));

    System.out.println("---");

    source.subscribe(System.out::println, Throwable::printStackTrace);

    System.out.println("---");

    source.subscribe(System.out::println);
  }
}
