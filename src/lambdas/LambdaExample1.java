package lambdas;

public class LambdaExample1 {
  public static void main(String[] args) {
    // Create a thread by:
    // - Implementing Runnable Interface
    // - Extending the Thread class

    // external class
    //    MyRunnable runnable = new MyRunnable();
    //    Thread t = new Thread(runnable);
    //    t.start();

    // anonymous inner class
    //    Thread t =
    //        new Thread(
    //            new Runnable() {
    //              @Override
    //              public void run() {
    //                System.out.println("Thread Executed");
    //              }
    //            });
    //    t.start();

    // lambda
    Thread t = new Thread(() -> System.out.println("Thread Executed"));
    t.start();
  }
}
