package classesAndObject.level1;

import java.util.Scanner;

/**
 * Represents an employee and displays employee details.
 */
class Employee {
    String name;
    int id;
    double salary;

    /**
     * Displays the employee's name, ID, and salary.
     */
    void displayDetails() {
        // Display employee information.
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee e1 = new Employee();

        // Read employee details from the user.
        System.out.print("Enter name: ");
        e1.name = sc.nextLine();

        System.out.print("Enter ID: ");
        e1.id = sc.nextInt();

        System.out.print("Enter salary: ");
        e1.salary = sc.nextDouble();

        // Display the entered details.
        e1.displayDetails();
        sc.close();
    }
}

