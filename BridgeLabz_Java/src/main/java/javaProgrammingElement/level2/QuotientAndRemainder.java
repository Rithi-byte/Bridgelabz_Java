package javaProgrammingElement.level2;
import java.util.Scanner;

//Created quotientAndRemainder Class to calculate quotient and remainder
public class QuotientAndRemainder {
    public static void main(String[] args) {
        //Create object for Scanner to take input
        Scanner sc = new Scanner(System.in);

        //Created two integer variables to take input
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();

        //Compute and store the quotient and remainder
        int quotient = number1 / number2;
        int remainder = number1 % number2;

        //Display Result
        System.out.println("The Quotient is " + quotient + " and Remainder is " + remainder + " of two numbers " + number1 + " and " + number2);
    }
}
