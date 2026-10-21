
package javaStrings.level2;

import java.util.Scanner;

/**
 * Write a program to generate Physics, Chemistry, and Maths scores,
 * calculate total, average, percentage, and grade for each student.

 * Hint =>
 * Generate random two-digit scores.
 * Calculate total, average, and percentage rounded to two decimals.
 * Assign grades according to the reference table.
 * Display the scorecard in a tabular format.
 */
public class StudentScorecard {

    /**
     * Generates random two-digit PCM scores for each student.
     *
     * @param students the number of students
     * @return a 2D array containing PCM scores
     */
    public static int[][] generateScores(int students) {
        int[][] scores = new int[students][3];

        // Generate marks between 10 and 99
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 10 + (int) (Math.random() * 90);
            }
        }

        return scores;
    }

    /**
     * Calculates total, average, and percentage for each student.
     *
     * @param scores the PCM scores
     * @return a 2D String array containing calculated values
     */
    public static String[][] calculateResults(int[][] scores) {
        String[][] result = new String[scores.length][3];

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = total / 300.0 * 100;

            // Round values to two decimal places
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            result[i][0] = String.valueOf(total);
            result[i][1] = String.valueOf(average);
            result[i][2] = String.valueOf(percentage);
        }

        return result;
    }

    /**
     * Calculates the grade based on percentage.
     *
     * @param results the calculated student results
     * @return a 2D String array containing grades
     */
    public static String[][] calculateGrades(String[][] results) {
        String[][] grades = new String[results.length][1];

        for (int i = 0; i < results.length; i++) {
            double percentage = Double.parseDouble(results[i][2]);

            // Assign grade using the reference table
            if (percentage >= 80) {
                grades[i][0] = "A";
            } else if (percentage >= 70) {
                grades[i][0] = "B";
            } else if (percentage >= 60) {
                grades[i][0] = "C";
            } else if (percentage >= 50) {
                grades[i][0] = "D";
            } else if (percentage >= 40) {
                grades[i][0] = "E";
            } else {
                grades[i][0] = "R";
            }
        }

        return grades;
    }

    /**
     * Displays the student scorecard.
     *
     * @param scores the PCM scores
     * @param results total, average, and percentage
     * @param grades the student grades
     */
    public static void displayScorecard(
            int[][] scores, String[][] results, String[][] grades) {

        System.out.printf(
                "%-8s %-8s %-8s %-8s %-8s %-10s %-12s %-8s%n",
                "Student", "Physics", "Chemistry", "Maths",
                "Total", "Average", "Percentage", "Grade");

        for (int i = 0; i < scores.length; i++) {
            int total = Integer.parseInt(results[i][0]);
            double average = Double.parseDouble(results[i][1]);
            double percentage = Double.parseDouble(results[i][2]);

            System.out.printf(
                    "%-8d %-8d %-8d %-8d %-8d %-10.2f %-11.2f%% %-8s%n",
                    i + 1,
                    scores[i][0],
                    scores[i][1],
                    scores[i][2],
                    total,
                    average,
                    percentage,
                    grades[i][0]);
        }
    }

    /**
     * Main method to generate and display the scorecard.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        // Validate the number of students
        if (students <= 0) {
            System.out.println("Number of students must be positive.");
            sc.close();
            return;
        }

        // Generate scores and calculate results
        int[][] scores = generateScores(students);
        String[][] results = calculateResults(scores);
        String[][] grades = calculateGrades(results);

        // Display the scorecard
        displayScorecard(scores, results, grades);

        sc.close();
    }
}
