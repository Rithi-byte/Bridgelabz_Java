package javaProgrammingElement.level1;
import java.util.Scanner;

// Created PurchaseCalculator Class to calculate the total price of a purchase
class PurchaseCalculator {
    public static void main(String[] args) {

        // Create a Scanner object to read input from the keyboard
        Scanner input = new Scanner(System.in);

        // Take user input for unit price and quantity
        double unitPrice = input.nextDouble();
        int quantity = input.nextInt();

        // Compute the total price
        double totalPrice = unitPrice * quantity;

        // Display the result
        System.out.println("The total purchase price is INR " + totalPrice + " if the quantity "
                + quantity + " and unit price is INR " + unitPrice);
        input.close();
    }
}
