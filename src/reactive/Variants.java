package reactive;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Variants {
  public static void main(String[] args) {
    Observable<String> source = Observable.just("Foo", "Bar", "Baz");
    Observable<Object> emptySource = Observable.empty();

    source.first("Name").subscribe(System.out::println);

    System.out.println("---");

    Single.just("Foo").subscribe(System.out::println);

    System.out.println("---");

    source.firstElement().subscribe(System.out::println);
    emptySource
        .firstElement()
        .subscribe(
            System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed"));

    System.out.println("---");

    Completable.complete().subscribe(() -> System.out.println("Completed"));

    System.out.println("---");

    Completable.fromRunnable(
            () -> {
              System.out.println("Some process executing");
            })
        .subscribe(() -> System.out.println("The process executed successfully"));
  }
}
