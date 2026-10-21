package javaStrings.level1;
import java.util.Scanner;
/**
 * Write a program to compare two strings using the charAt() method and check the result with the built-in String equals() method
 * Hint =>
 * Take user input using the  Scanner next() method for 2 String variables
 * Write a method to compare two strings using the charAt() method and return a boolean result
 * Use the String Built-In method to check if the results are the same and display the result
 */
public class StringComparison {
    /**
     * To compare two strings using the charAt() method and check the result with the built-in String equals() method
     *
     * @param args command line argument
     */
    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc = new Scanner(System.in);

        //take string1 and string2 input
        String string1 = sc.next();
        String string2 = sc.next();
        if(string1.length()!=string2.length()){
            System.out.println("String not of same length.not equal");
        }
        else{
            //Create a boolean variable to keep track
            boolean check = true;
            //Compare with charAt
            for (int i = 0; i < string1.length(); i++) {
                if (string1.charAt(i) != string2.charAt(i)) {
                    check = false;
                    break;
                }
            }
            System.out.println("The strings are equal(charAt): "+check);

            //Using .equals
            System.out.println("The strings are equal(equals): "+string1.equals(string2));

            sc.close();
        }
    }
}
