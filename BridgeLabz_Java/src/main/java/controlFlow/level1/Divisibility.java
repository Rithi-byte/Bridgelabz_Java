package controlFlow.level1;
import java.util.Scanner;
//Created Divisibility class to check whether the
// number is divisible by 5
public class Divisibility {
    /**
     * Checks whether the input number is divisible by 5.
     *
     * @param number the input from user
     * @code number%5==0 to check the divisibility by 5
     * @return No return value because main is void
     */
    public static void main(String[] args){
        //Create the scanner object to take input
        Scanner sc=new Scanner(System.in);

        //Create an integer variable to take input
        int number=sc.nextInt();

        //Conditional statement to handle the divisiblity
        if(number%5==0){
            System.out.println("Is the number "+number+" divisible by 5? "+"Yes");
        }
        else{
            System.out.println("Is the number "+number+" divisible by 5? "+"No");
        }
        sc.close();
    }
}
