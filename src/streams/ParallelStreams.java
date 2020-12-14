package streams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreams {

  public static void main(String[] args) {

    long startTime;
    long endTime;

    List<Employee> list = new ArrayList<>();

    for (int i = 0; i < 100; i++) {
      list.add(new Employee("John", 20000));
      list.add(new Employee("Rohn", 3000));
      list.add(new Employee("Tom", 15000));
      list.add(new Employee("Bheem", 8000));
      list.add(new Employee("Shiva", 200));
      list.add(new Employee("Krishna", 50000));
    }

    startTime = System.currentTimeMillis();
    System.out.println(
        "Performing sequentially: " + list.stream().filter(e -> e.getSalary() > 1000).count());
    endTime = System.currentTimeMillis();
    System.out.println("Time taken with sequential stream: " + (endTime - startTime));

    startTime = System.currentTimeMillis();
    System.out.println(
        "Performing in parallel: "
            + list.stream().parallel().filter(e -> e.getSalary() > 1000).count());
    endTime = System.currentTimeMillis();
    System.out.println("Time taken with parallel stream: " + (endTime - startTime));
  }
}
