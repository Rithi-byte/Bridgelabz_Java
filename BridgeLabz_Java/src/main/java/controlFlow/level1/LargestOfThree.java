package controlFlow.level1;
import java.util.Scanner;
// Created class LargestOfThree to find the largest number
public class LargestOfThree {

    /**
     * Checks whether the first, second, or third number
     * is the largest among the three numbers.
     *
     * @param number1 the first number entered by the user
     * @param number2 the second number entered by the user
     * @param number3 the third number entered by the user
     * {@code number1 > number2 && number1 > number3}
     * checks whether the first number is the largest.
     */
    public static void main(String[] args) {

        // Created a Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Take input for three numbers
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();

        // Conditional statement to check whether number1 is the largest
        if ((number1 > number2) && (number1 > number3)) {
            System.out.println("Is the first number the largest? Yes");
        } else {
            System.out.println("Is the first number the largest? No");
        }

        // Conditional statement to check whether number2 is the largest
        if ((number2 > number1) && (number2 > number3)) {
            System.out.println("Is the second number the largest? Yes");
        } else {
            System.out.println("Is the second number the largest? No");
        }

        // Conditional statement to check whether number3 is the largest
        if ((number3 > number1) && (number3 > number2)) {
            System.out.println("Is the third number the largest? Yes");
        } else {
            System.out.println("Is the third number the largest? No");
        }

        sc.close();
    }
}
