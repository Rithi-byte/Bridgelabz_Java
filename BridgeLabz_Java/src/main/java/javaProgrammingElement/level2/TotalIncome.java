package javaProgrammingElement.level2;
import java.util.Scanner;

//Created totalIncome Class to calculate total income
public class TotalIncome {
    public static void main(String[] args) {
        //Create object for Scanner to take input
        Scanner sc = new Scanner(System.in);

        //Created two double variables to take salary and bonus as input
        double salary = sc.nextDouble();
        double bonus = sc.nextDouble();

        //Compute and store the total income
        double income = salary + bonus;

        //Display Result
        System.out.println("The salary is INR " + salary + " and bonus is INR " + bonus + ". Hence Total Income is INR " + income);
    }
}
