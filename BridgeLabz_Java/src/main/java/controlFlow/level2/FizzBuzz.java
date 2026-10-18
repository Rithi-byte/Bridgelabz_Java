package controlFlow.level2;
import java.util.Scanner;
//Created class FizzBuzz to print the number
// but for multiples of 3 print "Fizz" instead of the number, for multiples of 5 print "Buzz", and for multiples of both print "FizzBuzz"

public class FizzBuzz {
    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc=new Scanner(System.in);

        //Take a number as a input
        int number=sc.nextInt();

        //Check if it is a positive integer
        if(number>=0){
            for(int i=0;i<=number;i++){
                // multiples of both print "FizzBuzz"
                if(i%3==0  && i%5==0){
                    System.out.println("FizzBuzz");
                }
                //multiples of 3 print "Fizz"
                else if(i%3==0){
                    System.out.println("Fizz");
                }
                // multiples of 5 print "Buzz"
                else if(i%5==0){
                    System.out.println("Buzz");
                }
                //Print the number
                else{
                    System.out.println(i);
                }
            }
        }
    }
}
