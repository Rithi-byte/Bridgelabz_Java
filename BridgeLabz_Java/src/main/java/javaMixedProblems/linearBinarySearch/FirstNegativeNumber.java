package javaMixedProblems.linearBinarySearch;
import java.util.Scanner;

/**
 * Finds the index of the first negative number using Linear Search.
 */
public class FirstNegativeNumber {

    /**
     * Searches for the first negative number.
     *
     * @param arr the input array
     * @return index of the first negative number, or -1 if absent
     */
    public static int findFirstNegative(int[] arr) {

        // Check each element from left to right.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Main method to find the first negative number.
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

        int index = findFirstNegative(arr);

        if (index != -1) {
            System.out.println("First negative number: " + arr[index]);
            System.out.println("Index: " + index);
        } else {
            System.out.println("No negative number found. Index: -1");
        }

        sc.close();
    }
}
