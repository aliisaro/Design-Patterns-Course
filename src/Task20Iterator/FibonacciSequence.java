package Task20Iterator;

import java.util.Iterator;

// Sequence for creating Fibonacci iterators.
public class FibonacciSequence implements Sequence {
  @Override
  public Iterator<Integer> iterator() {
    return new FibonacciIterator(10); // Default to 10 numbers or -1 for infinite
  }
}
