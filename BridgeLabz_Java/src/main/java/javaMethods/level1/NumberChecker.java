package javaMethods.level1;
import java.util.Scanner;
//Created NumberChecker class  to check whether a number is positive, negative, or zero.
public class NumberChecker {
    /**
     *  Created  Numbersign Method to return -1 for negative number, 1 for positive number
     *  0 if number is zero
     *
     * @param number  integer input from the user
     * @return integer type return -1 for negative number, 1 for positive number and 0 if number is zero
     */
    public static int Numbersign(int number){
        if(number==0){
            return 0;
        }
        else if(number>0){
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc=new Scanner(System.in);

        // Get integer input from the user.
        int number=sc.nextInt();

        //Created sign integer variable and Call the method to assign -1,1,0
        int sign=Numbersign(number);

        //Display the result
        System.out.println("The number "+number+" and its sign is "+sign);

        sc.close();
    }
}
