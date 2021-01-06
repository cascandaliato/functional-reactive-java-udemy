package reactive;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class CreatingObservable {
  public static void main(String[] args) {

    // create
    Observable<Integer> source =
        Observable.create(
            e -> {
              e.onNext(10);
              e.onNext(11);
              e.onNext(12);
              e.onComplete();
            });

    source.subscribe(System.out::println);

    System.out.println("---");

    // just
    Observable<Integer> just = Observable.just(10, 11, 12);
    just.subscribe(System.out::println);

    System.out.println("---");

    // fromIterable
    List<String> list = List.of("foo", "bar", "baz");
    Observable<String> fromIterable = Observable.fromIterable(list);
    fromIterable.subscribe(System.out::println);
  }
}
