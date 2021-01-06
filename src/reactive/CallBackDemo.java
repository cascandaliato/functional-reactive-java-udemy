package reactive;

public class CallBackDemo {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("Main thread is running");

    Runnable r =
        () ->
            new CallBackDemo()
                .runningAsync(
                    new CallBack() {
                      @Override
                      public void pushData(String data) {
                        System.out.println("Callback data: " + data);
                      }

                      @Override
                      public void pushComplete() {
                        System.out.println("Callback done!");
                      }

                      @Override
                      public void pushError(Exception ex) {
                        System.out.println("Callback error called, got an exception: " + ex);
                      }
                    });

    new Thread(r).start();

    Thread.sleep(2000);

    System.out.println("Main thread completed");
  }

  public void runningAsync(CallBack callback) {
    System.out.println("I am running in a separate thread");
    sleep(100);
    callback.pushData("data1");
    callback.pushData("data2");
    callback.pushData("data3");

    callback.pushError(new RuntimeException("Oops!"));

    callback.pushComplete();
  }

  private void sleep(int duration) {
    try {
      Thread.sleep(duration);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
