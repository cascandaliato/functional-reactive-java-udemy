package collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CollectorsInAction {
  public static void main(String[] args) {
    Path path = Paths.get("EmployeeData.txt");
    try (Stream<String> lines = Files.lines(path)) {
      Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(",")));
      Spliterator<String> wordSpliterator = words.spliterator();
      Spliterator<Employee> employeeSpliterator = new EmployeeSpliterator(wordSpliterator);

      Stream<Employee> employees = StreamSupport.stream(employeeSpliterator, false);
      List<Employee> employeeList = employees.collect(Collectors.toList());

      Set<String> designations =
          employeeList.stream().map(Employee::getDesignation).collect(Collectors.toSet());
      //      Set<String> designations =
      //          employeeList.stream()
      //              .map(Employee::getDesignation)
      //              .collect(Collectors.toUnmodifiableList());
      System.out.println(designations);

      List<String> employeeNames =
          employeeList.stream().map(Employee::getName).collect(Collectors.toList());
      //      List<String> employeeNames =
      //          employees.map(Employee::getName).collect(Collectors.toUnmodifiableList());
      employeeNames.forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
