package reactive;

import io.reactivex.rxjava3.core.Observable;

public class ConcurrencyInRxJava {
  public static void main(String[] args) {
    Observable<Object> source =
        Observable.create(
            e ->
                new Thread(
                        () -> {
                          e.onNext("Hello");
                          e.onNext("RxJava");
                        })
                    .start());

    source.subscribe(
        e ->
            System.out.println(
                "obs1: " + e + " (thread: " + Thread.currentThread().getName() + ")"));

    source.subscribe(
        e ->
            System.out.println(
                "obs2: " + e + " (thread: " + Thread.currentThread().getName() + ")"));
  }
}
