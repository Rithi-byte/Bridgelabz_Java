package javaFileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmployeePayrollFileReader {

    public static void main(String[] args) {

        String fileName = "EmployeePayroll.txt";

        // Read employee payroll file
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {

            String line;

            System.out.println("===== EMPLOYEE PAYROLL DETAILS =====");

            // Read each employee record
            while ((line = reader.readLine()) != null) {

                // Split employee details using comma
                String[] details = line.split(",");

                // Extract employee information
                int id = Integer.parseInt(details[0]);
                String name = details[1];
                double salary = Double.parseDouble(details[2]);

                // Display employee details
                System.out.println("\nEmployee ID: " + id);
                System.out.println("Employee Name: " + name);
                System.out.println("Employee Salary: " + salary);
            }

            System.out.println("\nFile read successfully!");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid employee record: " + e.getMessage());
        }
    }
}

