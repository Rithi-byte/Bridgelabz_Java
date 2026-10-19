
package arrays.level2;

import java.util.Scanner;

/**
 * Calculates employee bonuses and total salary expenses for Zara.
 */
public class EmployeeBonus {

    /**
     * Reads employee details and calculates bonuses and salary totals.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] salary = new double[10];
        double[] serviceYears = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        // Read and validate employee details
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Employee " + (i + 1));

            System.out.print("Enter salary: ");
            double employeeSalary = input.nextDouble();

            System.out.print("Enter years of service: ");
            double years = input.nextDouble();

            // Repeat input when the salary or service years are invalid
            if (employeeSalary <= 0 || years < 0) {
                System.out.println("Invalid input. Enter details again.");
                i--;
                continue;
            }

            salary[i] = employeeSalary;
            serviceYears[i] = years;
        }

        // Calculate bonuses and new salaries
        for (int i = 0; i < salary.length; i++) {
            if (serviceYears[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }

            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];

            System.out.println("\nEmployee " + (i + 1));
            System.out.println("Old Salary: " + salary[i]);
            System.out.println("Bonus: " + bonus[i]);
            System.out.println("New Salary: " + newSalary[i]);
        }

        // Display total company expenses
        System.out.println("\nTotal Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);

        input.close();
    }
}
