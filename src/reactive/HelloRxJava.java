package reactive;

import java.util.Observable;

public class HelloRxJava {
  public static void main(String[] args) {
    Observable<String> source =
        Observable.create(
            e -> {
              e.onNext("Hello");
              e.onNext("RxJava");
            });

    source.subscribe(e -> "Observer 1: " + e);
    source.subscribe(e -> "Observer 2: " + e);
  }
}
