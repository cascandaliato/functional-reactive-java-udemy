package reactive;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ZipAndCombineLatest {
  public static void main(String[] args) throws InterruptedException {
    Observable<Long> src1 = Observable.interval(200, TimeUnit.MILLISECONDS);
    Observable<Long> src2 = Observable.interval(1, TimeUnit.SECONDS);

    Observable.zip(src1, src2, (e1, e2) -> "[zip] src1 " + e1 + " and src2 " + e2)
        .subscribe(System.out::println);
    Observable.combineLatest(
            src1, src2, (e1, e2) -> "[combine latest] src1 " + e1 + " and src2 " + e2)
        .subscribe(System.out::println);

    Thread.sleep(5000);
  }
}
