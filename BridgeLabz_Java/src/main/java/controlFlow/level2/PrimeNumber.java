package controlFlow.level2;
import java.util.Scanner;
//Created PrimeNumber class to check if the number is prime or not
public class PrimeNumber {
    /**
     * Checks whether the given number is a prime number.
     *
     * @param number the integer to be checked
     * @return true if the number is prime, otherwise false
     */
    public static boolean isPrime(int number){
        boolean isPrime=true;
        if(number<=1){
            isPrime=false;
        }
        else{
            for(int i=2;i< number;i++){
                if(number%i==0){
                    isPrime=false;
                    break;
                }
            }
        }
        return isPrime;
    }
    /**
     * Takes an integer input and displays whether it is prime.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc=new Scanner(System.in);
        //Create variable to take integer
        System.out.print("Enter a number: ");
        int number=sc.nextInt();
        //Display the result
        if(isPrime(number)){
            System.out.println(number+" is a prime number");
        }
        else{
            System.out.println(number+" is not a prime number");
        }
    }
}
