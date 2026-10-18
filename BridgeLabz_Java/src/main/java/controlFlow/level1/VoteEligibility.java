package controlFlow.level1;

import java.util.Scanner;

//Check if the person's age is eligible for voting
public class VoteEligibility {
    /**
     * Age eligibility checks the age is greater or less than 18
     *
     * @param age integer value representing the person's age
     * @return true if age is greater than or equal to 18, otherwise false
     */
    public static boolean ageEligibility(int age) {
        return age >= 18;
    }

    /**
     * The main method takes the person's age as input and checks
     * whether the person is eligible to vote using the ageEligibility method.
     *
     * @param args command-line arguments passed to the main method
     */
    public static void main(String[] args) {
        //Scanner object to take input
        Scanner sc = new Scanner(System.in);

        //Create integer variable and taking age as an input
        int personAge = sc.nextInt();

        //ageEligibility function to check if the person can vote
        if (ageEligibility(personAge)) {
            System.out.println("The person's age is " + personAge + " and can vote");
        } else {
            System.out.println("The person's age is " + personAge + " and can't vote");
        }
    }

}

