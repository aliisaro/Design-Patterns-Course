package Task9Strategy;

public class SelectionSort implements StrategyInterface {
    @Override
    public void sort (int[] array) {
        long startTime = System.nanoTime(); // start time in nanoseconds

        int i, j;
        int n = array.length;

        for (i = 0; i < n - 1; i++) {
            // Find the minimum element in
            // unsorted array
            int min_idx = i;
            for (j = i + 1; j < n; j++) {
                if (array[j] < array[min_idx])
                    min_idx = j;
            }

            // Swap the found minimum element
            // with the first element
            if (min_idx != i) {
                int temporary = array[min_idx]; // temporary variable
                array[min_idx] = array[i];
                array[i] = temporary;
            }
        }

        long endTime = System.nanoTime();  // end time in nanoseconds
        System.out.println("Time taken: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }

    @Override
    public void printArray (int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");
    }
}
