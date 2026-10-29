package javaMixedProblems.linearBinarySearch;
import java.util.Scanner;

/**
 * Finds a peak element using Binary Search.
 *
 * A peak is greater than its existing neighboring elements.
 */
public class PeakElement {

    /**
     * Finds the index of a peak element.
     *
     * @param arr the input array
     * @return index of a peak element, or -1 for an empty array
     */
    public static int findPeak(int[] arr) {

        if (arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        // Follow the upward slope until a peak is reached.
        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    /**
     * Main method to find a peak element.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int index = findPeak(arr);

        if (index != -1) {
            System.out.println("Peak element: " + arr[index]);
            System.out.println("Index: " + index);
        } else {
            System.out.println("Array is empty.");
        }

        sc.close();
    }
}