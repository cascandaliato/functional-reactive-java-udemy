package fun;

public class JavaClosures {
  public static void main(String[] args) {
    int val = 111;
    //    val = 112;
    Task lambda =
        () -> {
          //          val = 112;
          System.out.println(val);
          System.out.println("Task completed");
        };

    printValue(lambda);
  }

  private static void printValue(Task lambda) {
    lambda.doTask();
  }

  @FunctionalInterface
  private interface Task {
    void doTask();
  }
}
