package javaExceptions.basics;

import java.util.*;

public class MultipleCatchDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create an integer array
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Get array elements
        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Get index from the user
        System.out.print("Enter index: ");
        int index = sc.nextInt();

        try {

            // Retrieve value from the array
            int value = arr[index];

            System.out.println(
                    "Value at index " + index + ": " + value
            );

        } catch (ArrayIndexOutOfBoundsException e) {

            // Handle invalid index
            System.out.println("Invalid index!");

        } catch (NullPointerException e) {

            // Handle null array
            System.out.println("Array is not initialized!");
        }

        sc.close();
    }
}
