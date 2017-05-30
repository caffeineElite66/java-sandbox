
import java.util.*;
import java.util.stream.*;

class QueueTwoStacks {
  public static void main (String[] args) {
    QueueTwoStacks queue = new QueueTwoStacks();
    IntStream.range(0, 10).forEach(i -> queue.enqueue(i));
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    IntStream.range(10, 15).forEach(i -> queue.enqueue(i));
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
  }

  Stack<Integer> inStack;
  Stack<Integer> outStack;

  public QueueTwoStacks() {
    this.inStack = new Stack<>();
    this.outStack = new Stack<>();
  }

  void enqueue(int data) {
    inStack.push(data);
  }

  int dequeue() {
    if (outStack.isEmpty()) {
      while (!inStack.isEmpty()) {
        int data = inStack.pop();
        outStack.push(data);
      }
    }
    return outStack.pop();
  }

}
