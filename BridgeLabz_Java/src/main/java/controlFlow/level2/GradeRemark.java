package controlFlow.level2;
import java.util.Scanner;
// Created StudentGrade class to calculate average marks and grade
public class GradeRemark {
    /**
     * Calculates the grade based on the average marks.
     *
     * @param average the average marks obtained by the student
     * @return the grade and remarks
     */
    public static String calculateGrade(double average) {
        if (average >= 80) {
            return "Grade A - Level 4, above agency-normalized standards";
        } else if (average >= 70) {
            return "Grade B - Level 3, agency-normalized standards";
        } else if (average >= 60) {
            return "Grade C - Level 2, below but approaching agency-normalized standards";
        } else if (average >= 50) {
            return "Grade D - Level 1, well below agency-normalized standards";
        } else if (average >= 40) {
            return "Grade E - Level 1, too below agency-normalized standards";
        } else {
            return "Grade R - Remedial standards";
        }
    }
    /**
     * Takes marks in Physics, Chemistry, and Mathematics,
     * calculates the average marks, and displays the grade and remarks.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take marks for three subjects
        System.out.print("Enter Physics marks: ");
        double physics = sc.nextDouble();

        System.out.print("Enter Chemistry marks: ");
        double chemistry = sc.nextDouble();

        System.out.print("Enter Mathematics marks: ");
        double maths = sc.nextDouble();

        // Calculate average marks (percentage)
        double average = (physics + chemistry + maths) / 3.0;

        // Display average, grade, and remarks
        System.out.printf("Average Mark: %.2f%%%n", average);
        System.out.println(calculateGrade(average));

        sc.close();
    }
}
