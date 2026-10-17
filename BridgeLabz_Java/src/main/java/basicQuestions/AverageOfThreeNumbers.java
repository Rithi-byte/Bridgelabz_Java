package basicQuestions;
import java.util.Scanner;

//Created averageOfThreeNumbers Class to calculate the average of three numbers
public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        //Create object for Scanner to take input
        Scanner sc = new Scanner(System.in);

        //Created three double variables to take input
        double number1 = sc.nextDouble();
        double number2 = sc.nextDouble();
        double number3 = sc.nextDouble();

        //Compute and store the average of the three numbers
        double average = (number1 + number2 + number3) / 3;

        //Display Result
        System.out.println("The average of " + number1 + ", " + number2 + ", and " + number3 + " is " + average);
    }
}
