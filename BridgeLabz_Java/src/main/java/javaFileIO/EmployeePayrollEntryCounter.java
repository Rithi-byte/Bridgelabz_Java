package javaFileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmployeePayrollEntryCounter {

    public static void main(String[] args) {

        String fileName = "EmployeePayroll.txt";
        int count = 0;

        // Read employee payroll file
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {

            String line;

            // Count each non-empty line
            while ((line = reader.readLine()) != null) {

                if (!line.trim().isEmpty()) {
                    count++;
                }
            }

            // Display total number of entries
            System.out.println("Total Number of Employee Entries: " + count);

            System.out.println("Entry count operation completed successfully!");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
