package controlFlow.level1;
import java.util.Scanner;
//Created OddEven class to  print odd and even numbers between 1 to the number
public class OddEven {
    /**
     *  To print odd and even numbers between 1 to the number entered by the user.
     * In each iteration of the loop, print the number is odd or even number
     * @param args command line arguments
     *
     */
    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc=new Scanner(System.in);

        //Get an integer input from the user, assign to a variable numbe
        int number=sc.nextInt();

        //Check for Natural Number
        if(number<0){
            System.out.println("Not a Natural number");
        }
        else{
            //Use for loop to iterate from 1 to number
            for(int i=1;i<=number;i++){
                //In each iteration of the loop,
                // print the number is odd or even number
                if(i%2==0){
                    System.out.println(i + " -Even");
                }
                else{
                    System.out.println(i+" -Odd");
                }
            }

        }
        sc.close();
    }

}
