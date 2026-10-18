package controlFlow.level1;
import java.util.Scanner;
//Created FactorialWhile class to factorial of an integer entered by the user.
public class FactorialWhile {
    /**
     * To find the factorial of an integer entered by the user.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc=new Scanner(System.in);
        //Create an integer variable to get from user
        int number=sc.nextInt();
        //Check the user has entered a positive integer.
        if(number>=0){
            //Created long variable to calculate the factorial
            long factorial=1;
            //Using a while loop, compute the factorial.
            while(number>=1){
                factorial*=number--;
            }
            //Display the result
            System.out.println("Factorial of "+number+" is "+factorial);
        }
        else{
            System.out.println("Negative number");
        }
    }
}
