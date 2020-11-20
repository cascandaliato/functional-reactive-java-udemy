package lambdas;

public class FunctionalInterfaceDemo {
  public static void main(String[] args) {
    //    MyFunInterface fun = () -> System.out.println("hello");
    //    fun.myMethod();
    //
    //    Integer x = 100;

    onTheFly(() -> System.out.println("hello"));
  }

  public static void onTheFly(MyFunctionalInterface fun) {
    fun.myMethod();
  }
}
