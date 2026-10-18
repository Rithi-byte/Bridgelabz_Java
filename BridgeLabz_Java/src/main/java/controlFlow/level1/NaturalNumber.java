package controlFlow.level1;
import java.util.Scanner;
//Create NaturalNumber class to check if it is a natural number and give the sum of n
public class NaturalNumber {
    /**
     * Check and print sum of n natural numbers
     * @param number input from user
     * @code sum=number(number+1)/2 if number>=0
     * @return void type
     */
    public static void main(String[] args){
        //Create scanner object to take input
        Scanner sc=new Scanner(System.in);

        //Create integer variable to store the user input
        int number=sc.nextInt();

        //Check if the input is a natural number
        if(number<0){
            System.out.println("The number "+number+" is not a natural number");
        }
        //Natural number that satisfy number>0 with inclusion 0
        else{
            //Compute and store the sum of 'number' numbers
            int sum=(int) number*(number+1)/2;
            System.out.println("The sum of "+number+" numbers is "+sum);
        }
        sc.close();

    }
}
