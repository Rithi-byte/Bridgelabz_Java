package javaProgrammingElement.level2;
import java.util.Scanner;

//Created chocolateDistribution Class to distribute chocolates among children
public class ChocolateDistribution {
    public static void main(String[] args) {
        //Create object for Scanner to take input
        Scanner sc = new Scanner(System.in);

        //Created two integer variables to take input
        int numberOfChocolates = sc.nextInt();
        int numberOfChildren = sc.nextInt();

        //Compute and store the chocolates each child gets
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;

        //Compute and store the remaining chocolates
        int remainingChocolates = numberOfChocolates % numberOfChildren;

        //Display Result
        System.out.println("The number of chocolates each child gets is " + chocolatesPerChild + " and the number of remaining chocolates are " + remainingChocolates);
    }
}

