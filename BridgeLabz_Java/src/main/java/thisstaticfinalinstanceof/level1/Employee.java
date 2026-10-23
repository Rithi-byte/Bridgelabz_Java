
package thisstaticfinalinstanceof.level1;

import java.util.Scanner;

/**
 * Represents an employee and demonstrates static, final, and instanceof.
 */
class Employee {

    // Shared company name and employee count across all Employee objects.
    static String companyName = "TCS";
    static int totalEmployees = 0;

    // Instance variables store individual employee details.
    String name;

    // The employee ID is assigned once and cannot be reassigned.
    final int id;

    String designation;

    /**
     * Initializes an employee and increments the total employee count.
     *
     * @param name the employee's name
     * @param id the employee's unique ID
     * @param designation the employee's job designation
     */
    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;

        // Increment the shared count whenever an employee is created.
        totalEmployees++;
    }

    /**
     * Displays the total number of employees created.
     */
    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    /**
     * Displays the company name and the employee's details.
     */
    void displayDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Designation: " + designation);
    }

    /**
     * Runs the employee details demonstration.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the employee's name.
        System.out.print("Enter employee name: ");
        String name = sc.nextLine();

        // Read the employee ID.
        System.out.print("Enter employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline.

        // Read the employee's designation.
        System.out.print("Enter designation: ");
        String designation = sc.nextLine();

        // Create an Employee object using the entered details.
        Employee employee = new Employee(name, id, designation);

        // Store the Employee reference in a variable of type Object.
        Object obj = employee;

        // Check the object's type before casting and displaying details.
        if (obj instanceof Employee) {
            ((Employee) obj).displayDetails();
        }

        // Display the total number of employees created.
        displayTotalEmployees();

        // Close the Scanner after input is complete.
        sc.close();
    }
}
