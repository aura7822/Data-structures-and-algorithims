//this is an uncomplicated java program that : 
//sorts delivery ponts[merge sort]
//searches for a specific point using binary search
//measures perfomance using differen tsizes && prints the output
package algorithims_sortingSearching;
import java.util.Arrays;
import java.util.Random;

public class Algorithims_sortingSearching{
    public static void mergeSort(int[]arr, int left, int right){
        if(left<right){
            int mid = (left + right)/2;
            
            mergeSort(arr, left, mid);
            mergeSort(arr,mid+1,right);
            merge(arr, left, mid, right);
        }
    }
    private static void merge(int[]arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right-mid;
        
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        for(int i=0; i<n1; i++){
            leftArray[i]=arr[left +1];
        }
        for(int j=0; j<n2; j++){
            rightArray[j]= arr[mid + 1 + j];
        }
        int i = 0, j=0, k=left;
        while(i<n1 && j<n2){
            if(leftArray[i] <= rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            }else{arr[k]= rightArray[j];
            j++;
            }
            k++;
        }
        while (i<n1){
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; 
    }
    public static PerformanceResult measurePerformance(int inputSize) {
        Random random = new Random();
        
       
        int[] deliveryPoints = new int[inputSize];
        for (int i = 0; i < inputSize; i++) {
            deliveryPoints[i] = random.nextInt(9000) + 100; 
        }
        
        
        int target = deliveryPoints[random.nextInt(inputSize)];
        
        int[] sortedArray = deliveryPoints.clone();
        long sortStartTime = System.nanoTime();
        mergeSort(sortedArray, 0, sortedArray.length - 1);
        long sortEndTime = System.nanoTime();
        double sortTime = (sortEndTime - sortStartTime) / 1_000_000.0; 
        
        
        long searchStartTime = System.nanoTime();
        int resultIndex = binarySearch(sortedArray, target);
        long searchEndTime = System.nanoTime();
        double searchTime = (searchEndTime - searchStartTime) / 1_000_000.0; 
        
        return new PerformanceResult(sortTime, searchTime, resultIndex, target);
    }
    
    
    static class PerformanceResult {
        double sortTime;
        double searchTime;
        int resultIndex;
        int target;
        
        PerformanceResult(double sortTime, double searchTime, int resultIndex, int target) {
            this.sortTime = sortTime;
            this.searchTime = searchTime;
            this.resultIndex = resultIndex;
            this.target = target;
        }
    }
     public static void displayArray(String label, int[] arr) {
        System.out.print(label + ": [");
        for (int i = 0; i < Math.min(arr.length, 20); i++) {
            System.out.print(arr[i]);
            if (i < Math.min(arr.length, 20) - 1) {
                System.out.print(", ");
            }
        }
        if (arr.length > 20) {
            System.out.print(", ...");
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        System.out.println("DELIVERY ROUTE OPTIMIZATION ALGORITHM");
        System.out.println("=====================================\n");
        
        
        int[] samplePoints = {450, 123, 789, 234, 567, 891, 345, 678, 912, 111};
        
        System.out.println("1. SAMPLE EXECUTION (10 delivery points)");
        System.out.println("-".repeat(50));
        displayArray("Original delivery points", samplePoints);
        
        
        int[] sortedPoints = samplePoints.clone();
        mergeSort(sortedPoints, 0, sortedPoints.length - 1);
        displayArray("Sorted delivery points  ", sortedPoints);
        
        
        int target = 567;
        int result = binarySearch(sortedPoints, target);
        System.out.println("\nSearching for delivery point: " + target);
        if (result != -1) {
            System.out.println("✓ Delivery point " + target + " found at index " + result);
        } else {
            System.out.println("✗ Delivery point " + target + " not found");
        }
        
        
        System.out.println("\n\n2. PERFORMANCE COMPARISON");
        System.out.println("-".repeat(50));
        System.out.printf("%-15s %-20s %-20s%n", "Input Size", "Sort Time (ms)", "Search Time (ms)");
        System.out.println("-".repeat(50));
        
        int[] inputSizes = {10, 1000};
        
        for (int size : inputSizes) {
            PerformanceResult resultObj = measurePerformance(size);
            System.out.printf("%-15d %-20.6f %-20.6f%n", 
                size, resultObj.sortTime, resultObj.searchTime);
        }
        
        
        System.out.println("\n\n3. THEORETICAL ANALYSIS");
        System.out.println("-".repeat(50));
        System.out.println("For input size increase from 10 to 1000:");
        System.out.println("• Expected sort time ratio (O(n log n)): ~" + 
            String.format("%.2f", (1000 * Math.log(1000)) / (10 * Math.log(10))));
        System.out.println("• Expected search time ratio (O(log n)): ~" + 
            String.format("%.2f", Math.log(1000) / Math.log(10)));
        
       
        System.out.println("\n\n4. ADDITIONAL VERIFICATION");
        System.out.println("-".repeat(50));
        
      
        PerformanceResult largeResult = measurePerformance(10000);
        System.out.println("Testing with 10,000 delivery points:");
        System.out.printf("• Sort time: %.4f ms%n", largeResult.sortTime);
        System.out.printf("• Search time: %.6f ms%n", largeResult.searchTime);
        System.out.println("• Target " + largeResult.target + 
            (largeResult.resultIndex != -1 ? " found successfully" : " not found"));
    }
    
}
