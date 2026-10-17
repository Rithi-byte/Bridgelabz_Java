package basicQuestions;
import java.util.Scanner;

//Created powerCalculation Class to calculate the power of a number
public class powerCalculation {
    public static void main(String[] args) {
        //Create object for Scanner to take input
        Scanner sc = new Scanner(System.in);

        //Created two double variables to take base and exponent as input
        double base = sc.nextDouble();
        double exponent = sc.nextDouble();

        //Compute and store the power of the number
        double power = Math.pow(base, exponent);

        //Display Result
        System.out.println("The result of " + base + " raised to the power " + exponent + " is " + power);
    }
}
