package javaMethods.level2;
import java.util.Scanner;

//Created RandomNumberAnalyzer to generate and analyze random numbers
public class RandomNumberAnalyzer {

    /**
     * Generates an array of random four-digit numbers.
     * @param size the number of random values to generate
     * @return an array of four-digit random numbers
     */
    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];

        // Generate random integers between 1000 and 9999
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 9000) + 1000;
        }
        return numbers;
    }

    /**
     * Calculates the average, minimum and maximum of an array.
     * @param numbers the array of random numbers
     * @return an array containing average, minimum and maximum
     */
    public static double[] findAverageMinMax(int[] numbers) {
        // Initialize sum, minimum and maximum
        double sum = 0;
        int minimum = numbers[0];
        int maximum = numbers[0];

        // Calculate sum, minimum and maximum
        for (int number : numbers) {
            sum += number;
            minimum = Math.min(minimum, number);
            maximum = Math.max(maximum, number);
        }

        // Calculate average
        double average = sum / numbers.length;

        // Return average, minimum and maximum
        return new double[]{average, minimum, maximum};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the number of random values to generate
        System.out.print("Enter array size: ");
        int size = sc.nextInt();

        if (size <= 0) {
            System.out.println("Array size must be positive.");
            sc.close();
            return;
        }

        // Generate random numbers
        int[] numbers = generate4DigitRandomArray(size);

        // Display the generated numbers
        System.out.print("Random numbers: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        // Calculate average, minimum and maximum
        double[] result = findAverageMinMax(numbers);

        // Display the results
        System.out.println("\nAverage: " + result[0]);
        System.out.println("Minimum: " + result[1]);
        System.out.println("Maximum: " + result[2]);

        sc.close();
    }
}