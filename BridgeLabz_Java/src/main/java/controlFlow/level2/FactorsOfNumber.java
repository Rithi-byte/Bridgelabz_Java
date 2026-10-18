package controlFlow.level2;
import java.util.Scanner;

//Created FactorsOfNumber class to print the factors of a number
public class FactorsOfNumber {
    /**
     * Finds and displays the factors of a given number.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc = new Scanner(System.in);

        //Take integer input
        int number = sc.nextInt();

        //Check numbers from 1 to number - 1
        for (int i = 1; i < number; i++) {
            //Check if it is a factor of number
            if (number % i == 0) {
                //Display the factor
                System.out.println(i);
            }
        }

        sc.close();
    }
}
