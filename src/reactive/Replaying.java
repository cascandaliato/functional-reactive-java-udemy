package reactive;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Replaying {
  public static void main(String[] args) throws InterruptedException {
    //    Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS).replay(2).autoConnect();
    Observable<Long> src =
        Observable.interval(1, TimeUnit.SECONDS).replay(1, 2, TimeUnit.SECONDS).autoConnect();

    src.subscribe(e -> System.out.println("obs1: " + e));

    Thread.sleep(3000);

    src.subscribe(e -> System.out.println("obs2: " + e));

    Thread.sleep(3000);
  }
}
