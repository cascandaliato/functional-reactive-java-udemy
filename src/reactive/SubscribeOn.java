package reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SubscribeOn {
  public static void main(String[] args) throws InterruptedException {
    Observable.just("Pasta", "Pizza", "Fries")
        .subscribeOn(Schedulers.computation())
        .map(e -> e.toUpperCase())
        .doOnNext(e -> System.out.println(Thread.currentThread().getName()))
        //        .subscribeOn(Schedulers.newThread())
        .observeOn(Schedulers.newThread())
        .filter(e -> e.startsWith("P"))
        .observeOn(Schedulers.io())
        .subscribe(e -> print(e));

    Thread.sleep(6000);
  }

  public static void print(String element) {
    System.out.println(element + " printed by " + Thread.currentThread().getName());
  }
}
