package controlFlow.level1;
import java.util.Scanner;
//Created class CountDown to take an integer and print till it reaches 1
public class CountDownfor {
    /**
     * Printing the numbers from user input to 1
     *
     * @param counter the number from the user input value

     */
    public static void rocketLaunch(int counter){
        //for loop to iterate till i is 1
        for(int i=counter;i>=1;i--){
            //print the value of the i
            System.out.println(i);
        }

    }
    /**
     * Takes the starting countdown number from the user and
     * calls the countdown method to perform the rocket launch countdown.
     *
     * @param args command-line arguments passed to the main method
     */
    public static void main(String[] args) {
        //Scanner object to take  input
        Scanner sc=new Scanner(System.in);

        //Create a variable counter
        // to take user inputted value for the countdown.
        int counter=sc.nextInt();

        //Rocket launch method to count down the number
        rocketLaunch(counter);

        //close the object
        sc.close();
    }
}
