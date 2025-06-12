//program to demonstrate insertion of arrays in java
/*
NAME : Aura Joshua
ADM NO : BSE-05-018-/2024
GROUP : 3
DATE : 6TH june
GITHUB USERNAME : aura7822
 */
import java.util.Arrays;
import java.util.ArrayList;

public class ArraysDemo {  // Changed class name to avoid conflict with java.util.Arrays
    public static void main(String[] args) {
        System.out.println("==INSERTION IN ARRAYS==");

        ArrayList<Integer> aura = new ArrayList<>();
        System.out.println("Using ArrayList:");
        System.out.println("Initial array list: " + aura + " Size: " + aura.size());

        aura.add(10);
        aura.add(20);
        aura.add(30);
        System.out.println("After adding: " + aura + " Size: " + aura.size());

        aura.add(1, 50);  // Inserts 50 at index 1
        System.out.println("After inserting 50 at index 1: " + aura + " Size: " + aura.size());

        aura.add(40);
        System.out.println("After inserting 40: " + aura + " Size: " + aura.size());

        int[] added = new int[4];
        int count = 0;
        if (count < added.length) { added[count++] = 1; }
        if (count < added.length) { added[count++] = 2; }
        if (count < added.length) { added[count++] = 3; }

        System.out.println("Initial fixed array (used " + count + " of " + added.length + " capacity): " + Arrays.toString(added));

        if (count < added.length) {
            added[count++] = 4;
        }

        System.out.println("After 'adding' 4 (used " + count + " of " + added.length + " capacity): " + Arrays.toString(added));
    }
}
