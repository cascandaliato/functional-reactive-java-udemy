package data_structures;

public class QueueDemo {
  public static void main(String[] args) {
    QueueFun<Object> q = QueueFun.queue();
    QueueFun<Object> enqueue = q.enqueue("Hey").enqueue("How are you?").enqueue("Fine?");
    enqueue.forEach(System.out::println);

    System.out.println("---");

    QueueFun<Object> dequeue = enqueue.dequeue();
    dequeue.forEach(System.out::println);

    System.out.println("---");

    System.out.println(dequeue.peek());

    System.out.println("---");

    System.out.println(dequeue.isEmpty());

    System.out.println("---");

    System.out.println(dequeue.size());
  }
}
