package Task20Iterator;

import java.util.Iterator;

/**
 * FibonacciIterator maintains the state and calculation logic for the Fibonacci sequence.
 * Rationale:
 * - Each iterator operates independently, ensuring no shared state conflicts.
 * - Encapsulates the sequence generation logic, keeping it separate from the sequence class.
 * - Simplifies the FibonacciSequence class, focusing it only on creating iterators.
 */
public class FibonacciIterator implements Iterator<Integer> {
  private int previous = 0, current = 1, count = 0; // State variables
  private final int limit; // Maximum numbers to generate (-1 for infinite)

  public FibonacciIterator(int limit) {
    this.limit = limit;
  }

  @Override
  public boolean hasNext() {
    return limit == -1 || count < limit;
  }

  @Override
  public Integer next() {
    if (!hasNext()) throw new IllegalStateException("No more elements.");
    int next = (count <= 1) ? 1 : previous + current;
    previous = current;
    current = next;
    count++;
    return next;
  }
}
