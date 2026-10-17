package javaProgrammingElement.level1;
import java.util.Scanner;
// Created FeeDiscountInput Class to calculate the discounted fee from user input
class FeeDiscountInput {
    public static void main(String[] args) {

        // Create a Scanner object to read input from the keyboard
        Scanner input = new Scanner(System.in);

        // Take user input for the fee and discount percentage
        System.out.println("Enter Fee:");
        double fee = input.nextDouble();
        System.out.println("Enter discount(%):");
        double discountPercent = input.nextDouble();

        // Compute the discount and the final fee
        double discount = fee * discountPercent / 100;
        double finalFee = fee - discount;

        // Display the result
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);
        input.close();
    }
}