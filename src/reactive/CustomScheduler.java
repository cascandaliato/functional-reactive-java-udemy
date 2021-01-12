package reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomScheduler {
  public static void main(String[] args) throws InterruptedException {
    ExecutorService scheduler = Executors.newFixedThreadPool(3);

    Observable<String> src =
        Observable.just("Pasta", "Pizza", "Fries")
            .subscribeOn(Schedulers.from(scheduler))
            .doFinally(scheduler::shutdown);

    src.subscribe(e -> doo());
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
