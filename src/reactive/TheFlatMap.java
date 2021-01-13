package reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.time.LocalTime;

public class TheFlatMap {
  public static void main(String[] args) throws InterruptedException {
    Observable.just("Pasta", "Pizza", "Fries")
        .flatMap(Observable::just)
        .subscribeOn(Schedulers.computation())
        .map(TheFlatMap::compute)
        .subscribe(System.out::println);

    Thread.sleep(2000);
  }

  public static String compute(String element) {
    return element + " printed by " + Thread.currentThread().getName() + " at " + LocalTime.now();
  }
}
