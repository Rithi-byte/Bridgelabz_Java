package javaFileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayrollService {

    // Employee Payroll Class
    static class EmployeePayroll {
        private int id;
        private String name;
        private double salary;

        // Constructor
        public EmployeePayroll(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        // Convert employee details into a string
        public String toString() {
            return "Employee ID: " + id +
                    "\nEmployee Name: " + name +
                    "\nEmployee Salary: " + salary;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<EmployeePayroll> employees = new ArrayList<>();

        // Get number of employees
        System.out.print("Enter number of employees: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        // Read employee details from user
        for (int i = 0; i < count; i++) {

            System.out.println("\nEnter Employee " + (i + 1) + " Details");

            System.out.print("Enter Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Employee Salary: ");
            double salary = scanner.nextDouble();

            // Create employee object
            employees.add(new EmployeePayroll(id, name, salary));
        }

        // Write employee payroll details into file
        try (FileWriter writer = new FileWriter("EmployeePayroll.txt")) {

            for (EmployeePayroll employee : employees) {
                writer.write(employee.toString());
                writer.write("\n-------------------------\n");
            }

            System.out.println("\nPayroll details written to file successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        // Read file and display payroll details on console
        System.out.println("\n===== EMPLOYEE PAYROLL DETAILS =====");

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("EmployeePayroll.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        scanner.close();
    }
}

