package javaFileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmployeePayrollFilePrinter {

    public static void main(String[] args) {

        String fileName = "EmployeePayroll.txt";
        int count = 0;

        // Read employee payroll file
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {

            String line;

            System.out.println("===== EMPLOYEE PAYROLL DETAILS =====");

            // Read and print each line
            while ((line = reader.readLine()) != null) {

                System.out.println(line);

                // Count non-empty entries
                if (!line.trim().isEmpty()) {
                    count++;
                }
            }

            // Display total number of entries
            System.out.println("\nTotal Number of Entries: " + count);

            // Verify file reading operation
            if (count > 0) {
                System.out.println("Payroll file read successfully!");
            } else {
                System.out.println("Payroll file is empty!");
            }

        } catch (IOException e) {
            System.out.println("Error reading payroll file: " + e.getMessage());
        }
    }
}
