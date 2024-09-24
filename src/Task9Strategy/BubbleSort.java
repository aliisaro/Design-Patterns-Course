package Task9Strategy;

//https://www.geeksforgeeks.org/bubble-sort-algorithm/
public class BubbleSort implements StrategyInterface {

    @Override
    public void sort(int[] array) {
        long startTime = System.nanoTime();  // Start time in nanoseconds

        int i, j;
        int n = array.length;
        boolean swapped;

        for (i = 0; i < n - 1; i++) {
            swapped = false;

            for (j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temporary = array[j]; // temporary variable
                    array[j] = array[j + 1];
                    array[j + 1] = temporary;

                    swapped = true;
                }
            }

            // If no two elements were swapped by the inner loop, then break
            if (swapped == false) {
                break;
            }
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
