package javaMethods.level1;
import java.util.Scanner;
// Created SmallestAndLargest to find the smallest and largest of three numbers
public class SmallestAndLargest {
    /**
     * Finds the smallest and largest among three numbers.
     *
     * @param number1 the first number
     * @param number2 the second number
     * @param number3 the third number
     * @return an integer array containing the smallest and largest numbers
     */
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        // Initialize smallest and largest with the first number
        int smallest = number1;
        int largest = number1;

        //Find the smallest
        if(number2<smallest){
            smallest=number2;
        }
        if(number3<smallest){
            smallest=number3;
        }

        //Find the Largest
        if(largest<number2){
            largest=number2;
        }
        if(largest<number3){
            largest=number3;
        }
        return new int[]{smallest,largest};
    }

    public static void main(String[] args) {
        //Scanner object to get user input
        Scanner sc = new Scanner(System.in);

        //Create three integer variable and
        // Get three numbers from the user
        System.out.println("Enter the three numbers: ");
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();

        // Call the method to find smallest and largest
        int[] result = findSmallestAndLargest(number1, number2, number3);

        // Display the results
        System.out.println("Smallest number: " + result[0]);
        System.out.println("Largest number: " + result[1]);

        // Close the Scanner
        sc.close();
    }
}
