
package arrays.level2;

import java.util.Scanner;

/**
 * Calculates student percentages and grades from three subject marks.
 */
public class StudentGradeCalculator {

    /**
     * Reads marks for Physics, Chemistry, and Mathematics, then calculates
     * percentages and assigns grades.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int number = input.nextInt();

        // Validate the number of students
        if (number <= 0) {
            System.out.println("Invalid number of students.");
            input.close();
            return;
        }

        int[][] marks = new int[number][3];
        double[] percentage = new double[number];
        String[] grade = new String[number];

        // Read and validate marks for each student
        for (int i = 0; i < number; i++) {
            System.out.println("Student " + (i + 1));

            System.out.print("Physics marks: ");
            int physics = input.nextInt();

            System.out.print("Chemistry marks: ");
            int chemistry = input.nextInt();

            System.out.print("Mathematics marks: ");
            int mathematics = input.nextInt();

            // Reject negative marks or marks above 100
            if (physics < 0 || physics > 100
                    || chemistry < 0 || chemistry > 100
                    || mathematics < 0 || mathematics > 100) {
                System.out.println("Enter marks between 0 and 100 again.");
                i--;
                continue;
            }

            marks[i][0] = physics;
            marks[i][1] = chemistry;
            marks[i][2] = mathematics;
        }

        // Calculate percentage and grade
        for (int i = 0; i < number; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 80) {
                grade[i] = "A";
            } else if (percentage[i] >= 70) {
                grade[i] = "B";
            } else if (percentage[i] >= 60) {
                grade[i] = "C";
            } else if (percentage[i] >= 50) {
                grade[i] = "D";
            } else if (percentage[i] >= 40) {
                grade[i] = "E";
            } else {
                grade[i] = "R";
            }
        }

        // Display the student scorecards
        System.out.println("\nPhysics\tChemistry\tMaths\tPercentage\tGrade");

        for (int i = 0; i < number; i++) {
            System.out.printf("%d\t%d\t\t%d\t%.2f%%\t\t%s%n",
                    marks[i][0], marks[i][1], marks[i][2],
                    percentage[i], grade[i]);
        }

        input.close();
    }
}
