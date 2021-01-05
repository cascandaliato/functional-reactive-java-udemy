package reactive;

import java.util.Observable;

public class ObservableAndObserver {
  public static void main(String[] args) {
    Observable<Integer> source =
        ObservableCreate
            < Integer
            > (new ObservableOnSubscribe<Integer>() {

              @Override
              public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                try {
                  emitter.onNext(10);
                  emitter.onNext(11);
                  emitter.onComplete();
                } catch (Throwable t) {
                  emitter.onError(t);
                }
              }
            });

    Observer<Integer> observer =
        new Observer<Integer>() {

          @Override
          public void onSubscribe(@NonNull Disposable d) {
            System.out.println("Subscribed");
          }

          @Override
          public void onNext(@NonNull Integer t) {
            System.out.println("On next: " + t);
          }

          @Override
          public void onError(@NonNull Throwable e) {
            e.printStackTrace();
          }

          @Override
          public void onComplete() {
            System.out.println("Completed");
          }
        };

    source.subscribe(observer);
  }
}
