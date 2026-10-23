
package objectModeling.level1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents an employee working in a company.
 */
class CompanyStaff {
    String name;

    /**
     * Initializes an employee with the given name.
     *
     * @param name the employee's name
     */
    CompanyStaff(String name) {
        this.name = name;
    }
}

/**
 * Represents a department that manages employees.
 */
class CompanyDivision {
    String name;
    ArrayList<CompanyStaff> employees = new ArrayList<>();

    /**
     * Initializes a department with the given name.
     *
     * @param name the department's name
     */
    CompanyDivision(String name) {
        this.name = name;
    }

    /**
     * Adds a new employee to the department.
     *
     * @param employeeName the name of the employee to add
     */
    void addEmployee(String employeeName) {
        employees.add(new CompanyStaff(employeeName));
    }

    /**
     * Displays the department name and its employees.
     */
    void display() {
        System.out.println("Department: " + name);

        // Display every employee in the department.
        for (CompanyStaff e : employees) {
            System.out.println("Employee: " + e.name);
        }
    }
}

/**
 * Represents a company that manages multiple departments.
 */
class BusinessOrganization {
    String name;
    ArrayList<CompanyDivision> departments = new ArrayList<>();

    /**
     * Initializes a company with the given name.
     *
     * @param name the company's name
     */
    BusinessOrganization(String name) {
        this.name = name;
    }

    /**
     * Creates a department, adds an employee,
     * and registers the department with the company.
     *
     * @param deptName the department's name
     * @param employeeName the employee's name
     */
    void addDepartment(String deptName, String employeeName) {
        // Create a department and add an employee.
        CompanyDivision d = new CompanyDivision(deptName);
        d.addEmployee(employeeName);

        // Add the department to the company.
        departments.add(d);
    }

    /**
     * Displays the company name and its departments.
     */
    void display() {
        System.out.println("\nCompany: " + name);

        // Display each department and its employees.
        for (CompanyDivision d : departments) {
            d.display();
        }
    }
}

/**
 * Demonstrates the relationship between a company,
 * its departments, and its employees.
 */
public class CompanyDemo {

    /**
     * Executes the company demonstration.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the company name.
        System.out.print("Enter company name: ");
        BusinessOrganization company =
                new BusinessOrganization(sc.nextLine());

        // Read the department name.
        System.out.print("Enter department name: ");
        String dept = sc.nextLine();

        // Read the employee name.
        System.out.print("Enter employee name: ");
        String emp = sc.nextLine();

        // Add the department and employee, then display the details.
        company.addDepartment(dept, emp);
        company.display();

        // Remove the reference held by this variable.
        company = null;
        System.out.println("Company reference removed.");

        sc.close();
    }
}
