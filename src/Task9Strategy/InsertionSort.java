package Task9Strategy;

//https://www.geeksforgeeks.org/selection-sort-algorithm-2/
public class InsertionSort implements StrategyInterface {
        @Override
        public void sort (int[] array) {
        long startTime = System.nanoTime();  // Start time in nanoseconds

        int i, j;
        int n = array.length;

        for (i = 1; i < n; ++i) {
                int key = array[i];
                j = i - 1;

        /* Move elements of arr[0..i-1], that are
           greater than key, to one position ahead
           of their current position */
                while (j >= 0 && array[j] > key) {
                        array[j + 1] = array[j];
                        j = j - 1;
                }
                array[j + 1] = key;
                }

        long endTime = System.nanoTime();  // end time in nanoseconds
        System.out.println("Time taken: " + (endTime - startTime) / 1_000_000.0 + " ms");
        }

        @Override
        public void printArray(int[] array) {
                for (int i = 0; i < array.length; i++) {
                        System.out.print(array[i] + " ");
                }
                System.out.println("\n");

    }
}
