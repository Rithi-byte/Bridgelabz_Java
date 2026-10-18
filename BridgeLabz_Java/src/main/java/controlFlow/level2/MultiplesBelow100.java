
package controlFlow.level2;
import java.util.Scanner;

//Created MultiplesBelow100 class to print multiples of a number below 100
public class MultiplesBelow100 {
    /**
     * Prints the multiples of a given number below 100 in descending order.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc = new Scanner(System.in);

        //Take integer input
        int number = sc.nextInt();

        //Check numbers from 99 down to 1
        for (int i = 99; i >= 1; i--) {
            //Check if i is a multiple of number
            if (number > 0 && i % number == 0) {
                //Display the multiple
                System.out.println(i);
                continue; //Continue to the next iteration
            }
        }

        sc.close();
    }
}
