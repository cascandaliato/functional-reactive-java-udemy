package reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Disposing {
  public static void main(String[] args) throws InterruptedException {
    Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

    Disposable d1 = source.subscribe(e -> System.out.println("Observer 1: " + e));
    Disposable d2 = source.subscribe(e -> System.out.println("Observer 2: " + e));

    Thread.sleep(5000);
    //    d1.dispose();

    CompositeDisposable compositeDisposable = new CompositeDisposable();
    compositeDisposable.addAll(d1, d2);
    compositeDisposable.dispose();

    Thread.sleep(10000);
  }
}
