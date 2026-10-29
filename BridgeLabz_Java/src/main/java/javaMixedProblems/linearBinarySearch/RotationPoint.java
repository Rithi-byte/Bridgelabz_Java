package javaMixedProblems.linearBinarySearch;

import java.util.Scanner;

/**
 * Finds the index of the smallest element in a rotated sorted array.
 *
 * Assumption: The array contains distinct elements.
 */
public class RotationPoint {

    /**
     * Finds the index of the minimum element using Binary Search.
     *
     * @param arr the rotated sorted array
     * @return index of the smallest element, or -1 for an empty array
     */
    public static int findRotationPoint(int[] arr) {

        if (arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        // Narrow the search range to the minimum element.
        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    /**
     * Main method to find the rotation point.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter rotated sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int index = findRotationPoint(arr);

        if (index != -1) {
            System.out.println("Rotation point index: " + index);
            System.out.println("Smallest element: " + arr[index]);
        } else {
            System.out.println("Array is empty.");
        }

        sc.close();
    }
}