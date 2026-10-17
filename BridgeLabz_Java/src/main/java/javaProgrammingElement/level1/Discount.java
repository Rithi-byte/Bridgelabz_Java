package javaProgrammingElement.level1;
// Created Discount Class to calculate the discounted university fee
public class Discount {
    public static void main(String[] args){
        //Create a variable named fee to store the student  fee
        int fee=125000;

        //Create another variable discountPercent to store dicounted
        int discountPercent=10;

        //Compute discount and assign it to the discount variable
        double discount=(fee*discountPercent)/100;

        //Compute  the fee to be paid by subtracting the discount from the fee
        double feeTobePaid=fee-discount;

        //Print the discounted fee and money to be paid
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + feeTobePaid);
    }

}
