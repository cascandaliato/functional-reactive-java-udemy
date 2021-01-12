package reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NewThreadScheduler {
  public static void main(String[] args) throws InterruptedException {
    Observable<String> src =
        Observable.just("Pasta", "Pizza", "Fries").subscribeOn(Schedulers.newThread());

    src.subscribe(e -> doo());
    Thread.sleep(4000);
    src.subscribe(e -> doo());
    src.subscribe(e -> doo());
    src.subscribe(e -> doo());
    src.subscribe(e -> doo());

    Thread.sleep(10000);
  }

  public static void doo() throws InterruptedException {
    Thread.sleep(1000);
    System.out.println("Computation done by " + Thread.currentThread().getName());
  }
}
