package reactive;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Buffering {
  public static void main(String[] args) throws InterruptedException {
    //    Observable.range(1, 30).buffer(4, HashSet::new).subscribe(System.out::println);
    //    Observable.range(1, 30).buffer(4, 5).subscribe(System.out::println);

    //    Observable.interval(500, TimeUnit.MILLISECONDS)
    //        .buffer(1, TimeUnit.SECONDS, 2)
    //        .subscribe(System.out::println);

    Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);
    //    Observable.interval(500,
    // TimeUnit.MILLISECONDS).buffer(interval).subscribe(System.out::println);
    Observable.interval(500, TimeUnit.MILLISECONDS).window(interval).subscribe(System.out::println);

    Thread.sleep(3000);
  }
}
