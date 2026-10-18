package controlFlow.level1;
import java.util.Scanner;
//Create SumTillZeroOrLess class o find the sum until the user enters 0 or a negative number
public class SumTillZeroOrLess {
    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc=new Scanner(System.in);

        //Initialize sum to integer
        int sum=0;

        //Sum till 0 or negative
        while(true){
            System.out.println("Enter a Number");
            int input=sc.nextInt();
            //Check if it is 0 or negative
            if(input<=0){
                break;
            }
            //Sum the input
            sum+=input;
        }
        //Display the result
        System.out.println("Total: "+sum);
        //Close the scanner object
        sc.close();

    }
}
