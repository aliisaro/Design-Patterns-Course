package Task20Iterator;

import java.util.Iterator;

public class Main {
  public static void main(String[] args) {
    FibonacciSequence sequence = new FibonacciSequence(10); // Generate 10 numbers
    Iterator<Integer> iterator = sequence.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
