package controlFlow.level1;
import java.util.Scanner;
//Created MultiplicationTable class to find the multiplication table of a number entered by the user from 6 to 9.
public class MultiplicationTable {
    /**
     * To print the multiplication table of a number from 6 to 9.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc=new Scanner(System.in);

        //Take integer input from the user
        System.out.println("Enter the number:");
        int number=sc.nextInt();

        //Using for loop, print the multiplication table from 6 to 9
        for(int i=6;i<=9;i++){
            System.out.println(number+ " * "+i+" = "+number*i);
        }

        sc.close();
    }
}
