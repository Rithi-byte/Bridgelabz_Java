package controlFlow.level2;
import java.util.Scanner;
//Created LeapYearOperator class to check if it is a leap year or not
public class LeapYearOperator {
    /**
     * LeapChecker method checks and sends if the year is leap year or not
     *
     * @param year integer type
     * The Leap Year is a Year divisible by 4 and not 100
     * It is divisible by 400 -Leap Year
     * @return String whether it is a leap year or not
     */
    public static String LeapChecker(int year){
        //Return result
        if((year%4==0 && year%100!=0) || (year%400==0)) {
            return "It is a Leap Year";
        }
        else{
            return "It is not a Leap Year";
        }
    }
    /**
     * The main method takes a year as input from the user,
     * checks whether the year is greater than or equal to 1582,
     * and displays whether it is a leap year.
     * If the year is below 1582, it displays an appropriate message.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc=new Scanner(System.in);

        //Take integer input for year
        int year=sc.nextInt();

        //The LeapYear program only works for year >= 1582
        //Display the result
        if(year>=1582){
            System.out.println(LeapChecker(year));
        }
        else{
            System.out.println("Leap year doesnt work below 1582");
        }
        sc.close();

    }

}
