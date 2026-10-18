package controlFlow.level1;
import java.util.Scanner;
//Created class SmallestOfThree to find the smallest number
public class SmallestOfThree {
    /**
     *
     * To check if the first is the smallest of the 3 numbers
     *
     * @param number1 the first number entered by the user
     * @param number2 the second number entered by the user
     * @param number3 the third number entered by the user
     * @code number1<number2 and number1<number3
     * @return No return value because main is void
     */
    public static void main(String[] args){
        //Created an object scanner to take input
        Scanner sc=new Scanner(System.in);

        //Take input for three numbers
        int number1=sc.nextInt();
        int number2=sc.nextInt();
        int number3=sc.nextInt();

        //Conditional Statement to find whether number1 is the smallest
        if((number1<number2 ) && (number1<number3)){
            System.out.println("Is the first number the smallest? Yes");
        }
        else{
            System.out.println("Is the first number the smallest? No");
        }
    }
}
