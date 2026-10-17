package basicQuestions;
import java.util.Scanner;
//Create simpleInterest class to calculate simple interest
public class simpleInterest {
    public static void main(String[] args){
        //Create object for Scanner to take input
        Scanner sc = new Scanner(System.in);

        //Created three double variables to take principal, rate, and time as input
        double principal = sc.nextDouble();
        double rate = sc.nextDouble();
        double time = sc.nextDouble();

        //Compute and store the simple interest
        double simpleInterest = (principal * rate * time) / 100;

        //Display Result
        System.out.println("The simple interest for principal " + principal + ", rate " + rate + "%, and time " + time + " years is " + simpleInterest);
    }
}
