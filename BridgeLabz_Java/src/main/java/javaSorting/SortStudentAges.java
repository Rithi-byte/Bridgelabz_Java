package javaSorting;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Program to sort student ages in ascending order using Counting Sort.
 *
 * Problem Statement:
 * A school collects students' ages ranging from 10 to 18
 * and wants them sorted. Implement Counting Sort for this task.
 *
 * Algorithm:
 * 1. Count the frequency of each age.
 * 2. Calculate cumulative frequencies.
 * 3. Place each age into its correct position in the output array.
 * 4. Copy the sorted elements back into the original array.
 *
 * Time Complexity: O(n + k)
 * Auxiliary Space Complexity: O(n + k)
 *
 * Here, n is the number of students and k is the age range (9).
 */
public class SortStudentAges {

    /**
     * Sorts student ages in ascending order using Counting Sort.
     *
     * @param ages the array containing student ages from 10 to 18
     */
    public static void countingSort(int[] ages) {

        // Minimum and maximum permitted ages.
        int minAge = 10;
        int maxAge = 18;

        // Calculate the number of possible age values.
        int range = maxAge - minAge + 1;

        // Store the frequency of each age.
        int[] count = new int[range];

        // Count the occurrences of each age.
        for (int age : ages) {

            // Validate that the age is within the permitted range.
            if (age < minAge || age > maxAge) {
                throw new IllegalArgumentException(
                        "Ages must be between 10 and 18."
                );
            }

            count[age - minAge]++;
        }

        // Calculate cumulative frequencies.
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Create an output array for the sorted ages.
        int[] output = new int[ages.length];

        // Traverse backwards to preserve stability.
        for (int i = ages.length - 1; i >= 0; i--) {

            int age = ages[i];

            // Find the correct position of the age.
            int position = count[age - minAge] - 1;

            // Place the age in the output array.
            output[position] = age;

            // Decrease the cumulative frequency.
            count[age - minAge]--;
        }

        // Copy the sorted ages back into the original array.
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    /**
     * Main method to accept student ages and display them in sorted order.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the number of students.
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        // Create an array to store student ages.
        int[] ages = new int[n];

        // Read student ages.
        System.out.println("Enter student ages (10 to 18):");

        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
        }

        // Sort the ages using Counting Sort.
        try {
            countingSort(ages);

            // Display the sorted ages.
            System.out.println("Student ages in ascending order:");
            System.out.println(Arrays.toString(ages));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
