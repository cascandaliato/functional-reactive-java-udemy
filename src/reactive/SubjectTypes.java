package reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.UnicastSubject;

import java.util.concurrent.TimeUnit;

public class SubjectTypes {
  public static void main(String[] args) throws InterruptedException {
    //    PublishSubject<Object> subject = PublishSubject.create();
    //    ReplaySubject<Object> subject = ReplaySubject.create();
    //    BehaviorSubject<Object> subject = BehaviorSubject.create();
    AsyncSubject<Object> subject = AsyncSubject.create();

    subject.subscribe(e -> System.out.println("sub1: " + e));

    subject.onNext("a");
    subject.onNext("b");
    subject.onNext("c");

    subject.subscribe(e -> System.out.println("sub2: " + e));

    subject.onNext("d");
    subject.onNext("e");
    subject.onComplete();

    UnicastSubject<Long> s = UnicastSubject.create();
    Observable.interval(500, TimeUnit.MILLISECONDS).subscribe(s);
    Thread.sleep(2000);
    s.subscribe(System.out::println);
    Thread.sleep(2000);
  }
}
