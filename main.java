import java.util.Scanner;

public class Main {
    // Counter to track comparisons
    private static int comparisons = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read array size and elements
        String input = scanner.nextLine().trim();
        String[] parts = input.split("\\s+");

        int n = Integer.parseInt(parts[0]);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i + 1]);
        }

        scanner.close();

        // Output unsorted array
        System.out.print("unsorted: ");
        printArray(arr);
        System.out.println();

        // Perform merge sort
        arr = mergeSort(arr);

        // Output sorted array
        System.out.print("sorted:   ");
        printArray(arr);
        System.out.println("comparisons: " + comparisons);
    }

    // Merge sort implementation
    public static int[] mergeSort(int[] arr) {
        // Base case: if array has 0 or 1 elements, it's already sorted
        if (arr.length <= 1) {
            return arr;
        }

        // Split the array into two halves
        int midpoint = arr.length / 2;

        // Create subarrays
        int[] leftArray = new int[midpoint];
        int[] rightArray = new int[arr.length - midpoint];

        // Fill the subarrays
        for (int i = 0; i < midpoint; i++) {
            leftArray[i] = arr[i];
        }

        for (int i = midpoint; i < arr.length; i++) {
            rightArray[i - midpoint] = arr[i];
        }

        // Recursively sort both halves
        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);

        // Merge the sorted halves
        return merge(leftArray, rightArray);
    }

    // Merge two sorted arrays
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        // Compare elements from both arrays and take the smaller one
        while (leftIndex < left.length && rightIndex < right.length) {
            comparisons++; // Count comparison

            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex] = left[leftIndex];
                leftIndex++;
            } else {
                result[resultIndex] = right[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }

        // Copy remaining elements from left array, if any
        while (leftIndex < left.length) {
            result[resultIndex] = left[leftIndex];
            leftIndex++;
            resultIndex++;
        }

        // Copy remaining elements from right array, if any
        while (rightIndex < right.length) {
            result[resultIndex] = right[rightIndex];
            rightIndex++;
            resultIndex++;
        }

        return result;
    }

    // Utility method to print an array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
