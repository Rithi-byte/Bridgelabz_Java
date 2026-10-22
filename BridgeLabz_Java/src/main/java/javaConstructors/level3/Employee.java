package javaConstructors.level3;

import java.util.Scanner;

/**
 * Represents an employee.
 */
class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    /**
     * Initializes employee details.
     *
     * @param employeeID the employee ID
     * @param department the employee's department
     * @param salary the employee's salary
     */
    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        setSalary(salary);
    }

    /**
     * Updates the employee's salary.
     *
     * @param salary the new salary
     */
    public void setSalary(double salary) {
        // Accept only nonnegative salary values.
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary.");
        }
    }

    /**
     * Returns the employee's salary.
     *
     * @return the current salary
     */
    public double getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read employee details.
        System.out.print("Enter employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter department: ");
        String department = sc.nextLine();

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        Manager manager = new Manager(id, department, salary);
        manager.displayDetails();

        // Modify salary through the public setter.
        System.out.print("Enter updated salary: ");
        manager.setSalary(sc.nextDouble());

        System.out.println("Updated Salary: " + manager.getSalary());

        sc.close();
    }
}

/**
 * Represents a manager who inherits employee details.
 */
class Manager extends Employee {

    /**
     * Initializes manager details.
     *
     * @param employeeID the employee ID
     * @param department the department
     * @param salary the salary
     */
    Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    /**
     * Displays the manager's employee details.
     */
    void displayDetails() {
        // Access public and protected fields directly.
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);

        // Access private salary through the getter.
        System.out.println("Salary: " + getSalary());
    }
}
