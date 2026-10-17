package basicQuestions;
import java.util.Scanner;
//Created addTwoNumbers Class to add two numbers
public class addTwoNumbers {
    public static void main(String[] args){
        //Create object for Scanner to take input
        Scanner sc=new Scanner(System.in);

        //Created two integer variable to take input
        int number1= sc.nextInt();
        int number2=sc.nextInt();

        //Compute and store the Addition of the two numbers
        int addition=number1+number2;

        //Display Result
        System.out.println("The addition of "+number1+" and "+number2+" is "+addition);
    }
}
