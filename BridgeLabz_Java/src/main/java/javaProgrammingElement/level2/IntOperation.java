package javaProgrammingElement.level2;
import java.util.Scanner;

//Created IntOperation Class to perform integer operations
public class IntOperation {
    public static void main(String[] args) {
        //Create object for Scanner to take input
        Scanner sc = new Scanner(System.in);

        //Created three integer variables to take input
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        //Compute and store the results of integer operations
        int result1 = a + b * c;
        int result2 = a * b + c;
        int result3 = c + a / b;
        int result4 = a % b + c;

        //Display Result
        System.out.println("The results of Int Operations are " + result1 + ", " + result2 + ", " + result3 + ", and " + result4);
    }
}
