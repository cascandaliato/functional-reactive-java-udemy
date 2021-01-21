package reactive;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.atomic.AtomicInteger;

public class Backpressure {

  public static void main(String[] args) throws InterruptedException {
    //    Observable.range(1, 1000000)
    Flowable.range(1, 1000000)
        .map(
            e -> {
              System.out.println("produced: " + e + " " + Thread.currentThread().getName());
              return e;
            })
        .observeOn(Schedulers.io())
        //        .subscribe(
        //            e -> {
        //              sleep(100);
        //              System.out.println("consumed: " + e + " " +
        // Thread.currentThread().getName());
        //            });
        .subscribe(
            new Subscriber<Integer>() {

              Subscription s;
              AtomicInteger count = new AtomicInteger(0);

              @Override
              public void onSubscribe(Subscription s) {
                this.s = s;
                System.out.println("Asking for 20 items");
                s.request(20);
              }

              @Override
              public void onNext(Integer t) {
                System.out.println("The subscriber consumed: " + t);
                if (count.getAndIncrement() % 20 == 0) {
                  System.out.println("Asking for next 20 items");
                  s.request(20);
                }

                try {
                  sleep(100);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }

              @Override
              public void onError(Throwable t) {
                t.printStackTrace();
              }

              @Override
              public void onComplete() {
                System.out.println("Completed");
              }
            });

    sleep(10000);
  }

  private static void sleep(long ms) throws InterruptedException {
    Thread.sleep(ms);
  }
}
