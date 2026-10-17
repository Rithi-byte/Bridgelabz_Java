package javaProgrammingElement.level1;
//Created Profit class to calculate the profit and profit percentage
public class Profit {
    public static void main(String[] args){
        //Create double type variable for cost price , selling price
        double costPrice=129,sellingPrice=191;

        //Profit Calculation (Profit = selling price - cost price)
        double profit=sellingPrice-costPrice;

        //Profit Percentage (Profit Percentage = profit / cost price * 100)
        double profitPercentage=(profit/costPrice) * 100;

        //Print the cost price and selling price
        System.out.println("The The Cost Price is INR "+sellingPrice+" and Selling Price is INR "+sellingPrice);

        //Print the profit and profit percentage
        System.out.println("The Profit is INR "+profit+" and the Profit Percentage is "+profitPercentage);
    }}

