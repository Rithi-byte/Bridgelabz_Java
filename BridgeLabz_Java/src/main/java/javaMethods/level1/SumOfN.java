package javaMethods.level1;
import java.util.Scanner;
//Created SumOfN class to find the sum of n natural numbers using loop
public class SumOfN {
    /**
     * sumOfNaturalNumbers Method to find the sum of n natural numbers using loop
     *
     * @param number integer type  input from the user
     * @return sum integer type  sum of n natural numbers
     */
    public static long sumOfNaturalNumbers(int number){
        //Create a variable to keep the sum
        long sum=0;

        //sum of n natural numbers using loop
        while(number!=0){
            sum+=number--;
        }

        //Return the sum
        return sum;
    }

    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc=new Scanner(System.in);

        //Get n integer input from the user.
        //n natural numbers
        int n=sc.nextInt();

        //sum of n natural numbers
        long sum=sumOfNaturalNumbers(n);

        //Display the result
        System.out.println("The sum of "+n+" natural numbers "+sum);

        sc.close();
    }
}
