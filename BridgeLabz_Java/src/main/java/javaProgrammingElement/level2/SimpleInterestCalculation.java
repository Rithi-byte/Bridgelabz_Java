package javaProgrammingElement.level2;
import java.util.Scanner;

//Created simpleInterestCalculation Class to calculate simple interest
public class SimpleInterestCalculation {
    public static void main(String[] args) {
        //Create object for Scanner to take input
        Scanner sc = new Scanner(System.in);

        //Created three double variables to take principal, rate, and time as input
        double principal = sc.nextDouble();
        double rate = sc.nextDouble();
        double time = sc.nextDouble();

        //Compute and store the simple interest
        double simpleInterest = (principal * rate * time) / 100;

        //Display Result
        System.out.println("The Simple Interest is " + simpleInterest + " for Principal " + principal + ", Rate of Interest " + rate + " and Time " + time);
    }
}
