package javaProgrammingElement.level2;
import java.util.Scanner;

//Created swapNumbers Class to swap two numbers
public class SwapNumbers {
    public static void main(String[] args) {
        //Create object for Scanner to take input
        Scanner sc = new Scanner(System.in);

        //Created two integer variables to take input
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();

        //Swap the values using a temporary variable
        int temp = number1;
        number1 = number2;
        number2 = temp;

        //Display Result
        System.out.println("The swapped numbers are " + number1 + " and " + number2);
    }
}
