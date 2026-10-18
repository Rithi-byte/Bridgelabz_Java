package controlFlow.level2;
import java.util.Scanner;

//Created FriendsComparison class to find the youngest and tallest friend
public class FriendsComparison {

    /**
     * Takes the ages and heights of three friends and finds the youngest
     * and tallest friend.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc = new Scanner(System.in);

        //Take ages of the three friends
        int amarAge = sc.nextInt();
        int akbarAge = sc.nextInt();
        int anthonyAge = sc.nextInt();

        //Take heights of the three friends
        double amarHeight = sc.nextDouble();
        double akbarHeight = sc.nextDouble();
        double anthonyHeight = sc.nextDouble();

        //Find the youngest friend
        if (amarAge <= akbarAge && amarAge <= anthonyAge) {
            System.out.println("Youngest friend: Amar");
        } else if (akbarAge <= amarAge && akbarAge <= anthonyAge) {
            System.out.println("Youngest friend: Akbar");
        } else {
            System.out.println("Youngest friend: Anthony");
        }

        //Find the tallest friend
        if (amarHeight >= akbarHeight && amarHeight >= anthonyHeight) {
            System.out.println("Tallest friend: Amar");
        } else if (akbarHeight >= amarHeight && akbarHeight >= anthonyHeight) {
            System.out.println("Tallest friend: Akbar");
        } else {
            System.out.println("Tallest friend: Anthony");
        }

        sc.close();
    }
}
