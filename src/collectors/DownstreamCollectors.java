package collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DownstreamCollectors {

  public static void main(String[] args) {

    Path path = Paths.get("EmployeeData.txt");
    try (Stream<String> lines = Files.lines(path); ) {

      Spliterator<String> wordSpliterator =
          lines.flatMap(line -> Arrays.stream(line.split(","))).spliterator();

      Spliterator<Employee> employeeSpliterator = new EmployeeSpliterator(wordSpliterator);

      List<Employee> employeeList =
          StreamSupport.stream(employeeSpliterator, false).collect(Collectors.toList());

      Map<String, Long> countByDesignation =
          employeeList.stream()
              .collect(Collectors.groupingBy(Employee::getDesignation, Collectors.counting()));
      System.out.println(countByDesignation);

      Map<String, Double> fundDistribution =
          employeeList.stream()
              .collect(
                  Collectors.groupingBy(
                      Employee::getDesignation, Collectors.summingDouble(Employee::getSalary)));
      System.out.println(fundDistribution);

      Map<String, Optional<Employee>> maxSalaryEmployees =
          employeeList.stream()
              .collect(
                  Collectors.groupingBy(
                      Employee::getDesignation,
                      Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
      System.out.println(maxSalaryEmployees);

      Map<String, Optional<Double>> maxSalaries =
          employeeList.stream()
              .collect(
                  Collectors.groupingBy(
                      Employee::getDesignation,
                      Collectors.mapping(
                          Employee::getSalary,
                          Collectors.maxBy(Comparator.comparing(Function.identity())))));
      System.out.println(maxSalaries);
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
