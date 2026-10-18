package controlFlow.level2;
import java.util.Scanner;

//Created GreatestFactor class to find the greatest factor of a number beside itself
public class GreatestFactor {
    /**
     * Finds and displays the greatest factor of a number beside itself.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc = new Scanner(System.in);

        //Take integer input
        int number = sc.nextInt();

        //Initialize greatestFactor to 1
        int greatestFactor = 1;

        //Check factors from number - 1 to 1
        for (int i = number - 1; i >= 1; i--) {
            //Check if the number is perfectly divisible by i
            if (number % i == 0) {
                greatestFactor = i; //Assign the greatest factor
                break; //Exit the loop
            }
        }

        //Display the greatest factor
        System.out.println(greatestFactor);

        sc.close();
    }
}