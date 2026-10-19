package javaMethods.level3;

//Created EmployeeBonusCalculator to calculate salaries and bonuses for 10 employees
public class EmployeeBonusCalculator {
    private static final int EMPLOYEE_COUNT = 10;

    /**
     * Generates salary and years of service for each employee.
     * @return 2D array columns: old salary, years of service
     */
    public static int[][] generateEmployeeData() {
        int[][] data = new int[EMPLOYEE_COUNT][2];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = (int) (Math.random() * 90000) + 10000;
            data[i][1] = (int) (Math.random() * 21);
        }
        return data;
    }

    /**
     * Calculates new salary and bonus for each employee.
     * @param data columns: old salary, years of service
     * @return 2D array columns: new salary, bonus
     */
    public static double[][] calculateBonusAndNewSalary(int[][] data) {
        double[][] result = new double[data.length][2];
        for (int i = 0; i < data.length; i++) {
            double rate = data[i][1] > 5 ? 0.05 : 0.02;
            double bonus = data[i][0] * rate;
            result[i][0] = data[i][0] + bonus;
            result[i][1] = bonus;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] oldData = generateEmployeeData();
        double[][] newData = calculateBonusAndNewSalary(oldData);
        double totalOld = 0, totalNew = 0, totalBonus = 0;
        System.out.println("Employee\tOld Salary\tYears\tBonus\t\tNew Salary");
        for (int i = 0; i < oldData.length; i++) {
            totalOld += oldData[i][0];
            totalNew += newData[i][0];
            totalBonus += newData[i][1];
            System.out.printf("%d\t\t%d\t\t%d\t%.2f\t\t%.2f%n",
                    i + 1, oldData[i][0], oldData[i][1], newData[i][1], newData[i][0]);
        }
        System.out.printf("Totals\t\t%.2f\t\t\t%.2f\t\t%.2f%n", totalOld, totalBonus, totalNew);
    }
}
