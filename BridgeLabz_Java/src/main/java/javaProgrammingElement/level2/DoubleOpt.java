package javaProgrammingElement.level2;
import java.util.Scanner;

//Created DoubleOpt Class to perform double operations
public class DoubleOpt {
    public static void main(String[] args) {
        //Create object for Scanner to take input
        Scanner sc = new Scanner(System.in);

        //Created three double variables to take input
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        //Compute and store the results of double operations
        double result1 = a + b * c;
        double result2 = a * b + c;
        double result3 = c + a / b;
        double result4 = a % b + c;

        //Display Result
        System.out.println("The results of Double Operations are " + result1 + ", " + result2 + ", " + result3 + ", and " + result4);
    }
}
