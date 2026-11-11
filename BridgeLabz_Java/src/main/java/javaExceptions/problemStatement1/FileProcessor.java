package javaExceptions.problemStatement1;

import java.io.*;
import java.util.*;

public class FileProcessor {

    // Method to process multiple files
    public static void processFiles(List<String> filePaths) {

        // Iterate through each file path
        for (String path : filePaths) {

            // Try-with-resources automatically closes the reader
            try (BufferedReader br =
                         new BufferedReader(new FileReader(path))) {

                System.out.println("\nReading file: " + path);

                String line;

                // Read the file line by line
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (IOException e) {

                // Handle file reading exceptions
                System.out.println("Error reading file: " + path);
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        // Create a list of file paths
        List<String> files = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of files: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Get file paths from the user
        for (int i = 0; i < n; i++) {
            System.out.print("Enter file path: ");
            files.add(sc.nextLine());
        }

        // Process all files
        processFiles(files);

        sc.close();
    }
}
