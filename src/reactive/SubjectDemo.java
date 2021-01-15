package reactive;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class SubjectDemo {
  public static void main(String[] args) {
    PublishSubject<Object> subject = PublishSubject.create();
    Subject<Object> serialized = subject.toSerialized();

    subject.subscribe(System.out::println);
    subject.subscribe(e -> System.out.println("obs2: " + e));

    subject.onNext("Hello");
    subject.onNext("World");
    subject.onComplete();

    subject.onNext("Ignored");
  }
}
