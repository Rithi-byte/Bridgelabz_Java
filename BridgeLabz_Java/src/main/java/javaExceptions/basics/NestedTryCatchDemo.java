package javaExceptions.basics;

import java.util.*;

public class NestedTryCatchDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Get array size
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        // Create array
        int[] arr = new int[n];

        // Get array elements
        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Get index and divisor
        System.out.print("Enter index: ");
        int index = sc.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();

        try {

            // Access array element
            int value = arr[index];

            try {

                // Perform division
                int result = value / divisor;

                System.out.println("Result: " + result);

            } catch (ArithmeticException e) {

                // Handle division by zero
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {

            // Handle invalid array index
            System.out.println("Invalid array index!");
        }

        sc.close();
    }
}
