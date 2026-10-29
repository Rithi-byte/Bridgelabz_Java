package javaMixedProblems.linearBinarySearch;
import java.util.Scanner;

/**
 * Finds the first and last occurrence of a target in a sorted array.
 */
public class FirstLastOccurrence {

    /**
     * Finds the first occurrence of the target.
     *
     * @param arr the sorted array
     * @param target the value to search for
     * @return first index, or -1 if absent
     */
    public static int findFirst(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    /**
     * Finds the last occurrence of the target.
     *
     * @param arr the sorted array
     * @param target the value to search for
     * @return last index, or -1 if absent
     */
    public static int findLast(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    /**
     * Main method to find both occurrences.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        System.out.println("First occurrence: " + first);
        System.out.println("Last occurrence: " + last);

        sc.close();
    }
}