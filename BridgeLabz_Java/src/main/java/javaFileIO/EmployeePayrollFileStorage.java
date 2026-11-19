package javaFileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeePayrollFileStorage {

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

        // Convert employee details into string
        public String toString() {
            return id + "," + name + "," + salary;
        }
    }

    public static void main(String[] args) {

        // Populate test employee payroll objects
        ArrayList<EmployeePayroll> employees = new ArrayList<>();

        employees.add(new EmployeePayroll(101, "Arun", 50000));
        employees.add(new EmployeePayroll(102, "Rithika", 60000));
        employees.add(new EmployeePayroll(103, "Priya", 55000));

        String fileName = "EmployeePayroll.txt";

        // Write employee payroll details into file
        try (FileWriter writer = new FileWriter(fileName)) {

            for (EmployeePayroll employee : employees) {
                writer.write(employee.toString() + "\n");
            }

            System.out.println("Employee payroll written successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
            return;
        }

        // Count employee entries in the file
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    count++;
                }
            }

            System.out.println("Number of employee entries: " + count);

            // Verify file operation
            if (count == employees.size()) {
                System.out.println("File operation verified successfully!");
            } else {
                System.out.println("File operation verification failed!");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

