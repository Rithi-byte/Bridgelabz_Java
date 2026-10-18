package controlFlow.level2;
import java.util.Scanner;

//Created PowerCalculator class to calculate the power of a number
public class PowerCalculator {
    /**
     * Calculates the power of a number using a for loop.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc = new Scanner(System.in);

        //Take number and power as input
        int number = sc.nextInt();
        int power = sc.nextInt();

        //Initialize result to 1
        int result = 1;

        //Repeat multiplication up to the given power
        for (int i = 1; i <= power; i++) {
            //Multiply result by number
            result = result * number;
        }

        //Display the result
        System.out.println(result);

        sc.close();
    }
}
