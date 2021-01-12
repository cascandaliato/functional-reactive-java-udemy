package reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ComputationScheduler {
  public static void main(String[] args) throws InterruptedException {
    Observable<String> src =
        Observable.just("Pasta", "Pizza", "Fries").subscribeOn(Schedulers.computation());

    src.subscribe(e -> compute());
    src.subscribe(e -> compute());
    src.subscribe(e -> compute());
    src.subscribe(e -> compute());
    src.subscribe(e -> compute());

    Thread.sleep(10000);
  }

  public static void compute() throws InterruptedException {
    Thread.sleep(1000);
    System.out.println("Computation done by " + Thread.currentThread().getName());
  }
}
