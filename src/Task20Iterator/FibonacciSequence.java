package Task20Iterator;

import java.util.Iterator;

// Creates an iterator for generating Fibonacci numbers.
public class FibonacciSequence implements Sequence {
  private final int length;

  public FibonacciSequence(int length) {
    this.length = length;
  }

  @Override
  public Iterator<Integer> iterator() {
    return new FibonacciIterator(length);
  }
}
