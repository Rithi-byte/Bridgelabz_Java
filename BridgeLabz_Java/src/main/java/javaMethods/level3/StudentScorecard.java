package javaMethods.level3;
import java.util.Scanner;

//Created StudentScorecard to generate PCM marks and calculate totals, averages, percentages and grades
public class StudentScorecard {
    /** @param studentCount number of students
     * @return 2D array with random two-digit Physics, Chemistry and Math marks */
    public static int[][] generateScores(int studentCount) {
        int[][] scores = new int[studentCount][3];
        for (int i = 0; i < studentCount; i++) {
            for (int j = 0; j < 3; j++) scores[i][j] = (int) (Math.random() * 90) + 10;
        }
        return scores;
    }

    /** @param scores PCM marks
     * @return 2D array columns: total, average, percentage */
    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = total / 300.0 * 100;
            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    /** @param percentage student's percentage
     * @return grade according to the supplied chart */
    public static String findGrade(double percentage) {
        if (percentage >= 80) return "A";
        if (percentage >= 70) return "B";
        if (percentage >= 60) return "C";
        if (percentage >= 50) return "D";
        if (percentage >= 40) return "E";
        return "R";
    }

    /** @param scores PCM marks
     * @param results calculated totals and percentages
     * Displays all scorecards in tabular format. */
    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t\t%d\t%.0f\t%.2f\t%.2f%%\t\t%s%n",
                    i + 1, scores[i][0], scores[i][1], scores[i][2],
                    results[i][0], results[i][1], results[i][2], findGrade(results[i][2]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int count = sc.nextInt();
        if (count <= 0) {
            System.out.println("Number of students must be positive.");
            sc.close();
            return;
        }
        int[][] scores = generateScores(count);
        double[][] results = calculateResults(scores);
        displayScorecard(scores, results);
        sc.close();
    }
}
