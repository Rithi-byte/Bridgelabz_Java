package javaSorting;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Program to sort job applicants' expected salary demands
 * in ascending order using Heap Sort.
 *
 * Problem Statement:
 * A company receives job applications with different expected
 * salary demands. Implement Heap Sort to sort these demands
 * in ascending order.
 *
 * Algorithm:
 * 1. Build a Max Heap from the array.
 * 2. Swap the root (largest element) with the last element.
 * 3. Reduce the heap size by one.
 * 4. Restore the Max Heap property.
 * 5. Repeat until the array is sorted.
 *
 * Time Complexity:
 * Best Case: O(n log n)
 * Average Case: O(n log n)
 * Worst Case: O(n log n)
 *
 * Auxiliary Space Complexity: O(1)
 */
public class SortApplicantSalary {

    /**
     * Sorts salary demands in ascending order using Heap Sort.
     *
     * @param arr the array containing expected salary demands
     */
    public static void heapSort(int[] arr) {

        int n = arr.length;

        // Build a Max Heap from the unsorted array.
        // Start from the last non-leaf node.
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract the maximum element one by one.
        for (int i = n - 1; i > 0; i--) {

            // Move the largest element to the end.
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Restore the Max Heap property for the reduced heap.
            heapify(arr, i, 0);
        }
    }

    /**
     * Maintains the Max Heap property for a subtree.
     *
     * @param arr the array representing the heap
     * @param heapSize the number of elements in the active heap
     * @param root the root index of the subtree
     */
    public static void heapify(int[] arr, int heapSize, int root) {

        // Assume the root is the largest element.
        int largest = root;

        // Calculate the indices of the left and right children.
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        // Check whether the left child is larger than the root.
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check whether the right child is larger than the current largest.
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        // If the root is not the largest, swap and continue heapifying.
        if (largest != root) {

            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;

            // Restore the heap property in the affected subtree.
            heapify(arr, heapSize, largest);
        }
    }

    /**
     * Main method to accept salary demands and display them in ascending order.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the number of job applicants.
        System.out.print("Enter the number of job applicants: ");
        int n = sc.nextInt();

        int[] salaries = new int[n];

        // Read expected salary demands.
        System.out.println("Enter the expected salary demands:");

        for (int i = 0; i < n; i++) {
            salaries[i] = sc.nextInt();
        }

        // Sort salary demands using Heap Sort.
        heapSort(salaries);

        // Display the sorted salary demands.
        System.out.println("Salary demands in ascending order:");
        System.out.println(Arrays.toString(salaries));

        sc.close();
    }
}
