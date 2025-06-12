//program to demonstrate deletion of arrays in java
/*
NAME : Aura Joshua
ADM NO : BSE-05-018-/2024
GROUP : 3
DATE : 6TH june
GITHUB USERNAME : aura7822
 */
import java.util.Arrays;
public class ArrayDeletion {
    public static void main(String[] args) {
        System.out.println("===Deletion of arrays===");
        int[] numbers = new int[5];
        int currentSize = 5;
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;
        System.out.println("Initial array: " + Arrays.toString(numbers) + " (used: " + currentSize + ", capacity: " + numbers.length + ")");
        if (currentSize > 0) {
            int removedValue = numbers[currentSize - 1];
            currentSize--;
            System.out.println("\nAfter 'deleting' from end (removed " + removedValue + "):");
            printArrayContent(numbers, currentSize)}
        int indexToDelete = 1;
        if (indexToDelete >= 0 && indexToDelete < currentSize) {
            int removedValue = numbers[indexToDelete];
            for (int i = indexToDelete; i < currentSize - 1; i++) {
                numbers[i] = numbers[i + 1];
            }
            currentSize--;

            System.out.println("\nAfter 'deleting' " + removedValue + " at index " + indexToDelete + ":");
            printArrayContent(numbers, currentSize);
        } else {
            System.out.println("\nInvalid index for deletion: " + indexToDelete);
        }
        indexToDelete = 0;
        if (currentSize > 0) {
            int removedValue = numbers[indexToDelete];
            for (int i = indexToDelete; i < currentSize - 1; i++) {
                numbers[i] = numbers[i + 1];
            }
            currentSize--;
            System.out.println("\nAfter 'deleting' " + removedValue + " at index " + indexToDelete + ":");
            printArrayContent(numbers, currentSize);
        } else {
            System.out.println("\nArray is empty, cannot delete from index " + indexToDelete);
        }
    }
    public static void printArrayContent(int[] arr, int size) {
        System.out.print("Current array content: [");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("] (used: " + size + ", capacity: " + arr.length + ")");
    }
}