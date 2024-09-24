package Task9Strategy;
import java.util.Random;

public class ContextMain {
    public static void main(String[] args) {

        Random random = new Random();

        //Creating the small array
        int[] smallArray = new int[30];
        for (int i = 0; i < smallArray.length; i++) {
            smallArray[i] = random.nextInt(100);
        }

        //Creating the large array
        int[] largeArray = new int[10000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = random.nextInt(100);
        }

        // Create BubbleSort object and call sort + printArray method

        BubbleSort bubbleSort = new BubbleSort();
        System.out.println("BUBBLE SORT (small array):");
        bubbleSort.sort(smallArray);
        bubbleSort.printArray(smallArray);
        System.out.println("BUBBLE SORT (large array):");
        bubbleSort.sort(largeArray);
        bubbleSort.printArray(largeArray);

        //Create InsertionSort object and call sort + printArray method
        InsertionSort insertionSort = new InsertionSort();
        System.out.println("INSERTION SORT (small array):");
        insertionSort.sort(smallArray);
        insertionSort.printArray(smallArray);
        System.out.println("INSERTION SORT (large array):");
        insertionSort.sort(largeArray);
        insertionSort.printArray(largeArray);

        //Create SelectionSort object and call sort + printArray method
        SelectionSort selectionSort = new SelectionSort();
        System.out.println("SELECTION SORT (small array):");
        selectionSort.sort(smallArray);
        selectionSort.printArray(smallArray);
        System.out.println("SELECTION SORT (large array):");
        selectionSort.sort(largeArray);
        selectionSort.printArray(largeArray);
    }
}
