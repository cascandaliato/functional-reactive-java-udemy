package collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
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

      System.out.println("---");

      List<String> employeeNames =
          employeeList.stream().map(Employee::getName).collect(Collectors.toList());
      //      List<String> employeeNames =
      //          employees.map(Employee::getName).collect(Collectors.toUnmodifiableList());
      employeeNames.forEach(System.out::println);

      System.out.println("---");
      TreeSet employeesSorted =
          employeeList.stream().collect(Collectors.toCollection(TreeSet::new));
      employeesSorted.forEach(System.out::println);

      System.out.println("---");

      Map<Integer, String> getNameById =
          employeeList.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
      System.out.println(getNameById);

      System.out.println("---");

      Map<Boolean, List<Employee>> partitionedData =
          employeeList.stream().collect(Collectors.partitioningBy(e -> e.getGender() == 'M'));
      System.out.println(partitionedData);

      List<Employee> maleEmployees = partitionedData.get(true);
      List<Employee> femaleEmployees = partitionedData.get(false);

      System.out.println("---");

      Map<String, List<Employee>> getByDesignation =
          employeeList.stream().collect(Collectors.groupingBy(Employee::getDesignation));
      System.out.println(getByDesignation);

      System.out.println("---");

      String employeeNamesString =
          employeeList.stream().map(Employee::getName).collect(Collectors.joining(", "));
      System.out.println(employeeNamesString);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
