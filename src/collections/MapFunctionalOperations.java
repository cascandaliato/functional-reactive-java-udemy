package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class MapFunctionalOperations {
  public static void main(String[] args) {
    Map<String, String> contacts = new HashMap<>();
    contacts.put("1237589020", "John");
    contacts.put("1237009020", "John");
    contacts.put("7890291111", "Neal");
    contacts.put("2647210290", "Raju");
    contacts.put("9999999999", "Peter");
    contacts.put("9081234567", "Neha");

    // Traversal
    for (Map.Entry<String, String> entry : contacts.entrySet()) {
      System.out.println(entry.getKey() + " - " + entry.getValue());
    }

    System.out.println("---");

    contacts.forEach((key, value) -> System.out.println(key + " " + value));

    System.out.println("---");

    // Filter
    contacts.entrySet().stream()
        .filter(contact -> "John".equalsIgnoreCase(contact.getValue()))
        .forEach(System.out::println);

    System.out.println("---");

    Map<String, String> filteredContacts =
        contacts.entrySet().stream()
            .filter(contact -> "John".equalsIgnoreCase(contact.getValue()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    System.out.println(filteredContacts);

    System.out.println("---");

    // Map
    //    String contactNames =
    //        contacts.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.joining(",
    // "));
    String contactNames = String.join(", ", contacts.values());
    System.out.println(contactNames);

    System.out.println("---");

    // Sorting
    LinkedHashMap<String, String> sortedMap =
        contacts.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
    sortedMap.forEach((k, v) -> System.out.println(k + " - " + v));

    System.out.println("---");

    // Reduce
    Map<String, Double> marks = new HashMap<>();
    marks.put("Science", 66.00);
    marks.put("Maths", 78.00);
    marks.put("English", 90.00);
    OptionalDouble average = marks.values().stream().mapToDouble(m -> m).average();
    System.out.println(average.getAsDouble());
  }
}
