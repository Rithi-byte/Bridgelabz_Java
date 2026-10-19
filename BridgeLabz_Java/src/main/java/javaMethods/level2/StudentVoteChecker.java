package javaMethods.level2;
import java.util.Scanner;

//Created StudentVoteChecker to check voting eligibility
public class StudentVoteChecker {

    /**
     * Checks whether a student is eligible to vote.
     * @param age the age of the student
     * @return true if age is 18 or above, otherwise false
     */
    public static boolean canStudentVote(int age) {
        // Reject negative ages and check voting eligibility
        if (age < 0) {
            return false;
        }
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an array to store ages of 10 students
        int[] ages = new int[10];

        // Get the ages and check eligibility
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();

            // Call the method and display the result
            if (canStudentVote(ages[i])) {
                System.out.println("Student " + (i + 1) + " can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " cannot vote.");
            }
        }

        sc.close();
    }
}
