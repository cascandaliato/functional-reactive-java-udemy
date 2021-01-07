package reactive;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class OperatorsInAction {
  public static void main(String[] args) {
    //    Observable<Employee> obs; // fill
    //
    //    obs.filter(e -> e.getSalary() > 100000.0)
    //        .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
    //        .map(Employee::getName)
    //        .take(4)
    //        //        .toList()
    //        .subscribe(System.out::println);

    List<Integer> expenses = List.of(200, 500, 300, 340, 129, 234, 999, 1030, 3400, 890, 996, 789);
    Observable.fromIterable(expenses).scan(Integer::sum).subscribe(System.out::println);
    System.out.println("---");
    Observable.fromIterable(expenses).reduce(Integer::sum).subscribe(System.out::println);
  }
}
