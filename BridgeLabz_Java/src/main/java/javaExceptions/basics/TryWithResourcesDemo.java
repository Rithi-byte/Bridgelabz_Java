package javaExceptions.basics;

import java.io.*;

public class TryWithResourcesDemo {

    public static void main(String[] args) {

        // Open file using try-with-resources
        try (BufferedReader br =
                     new BufferedReader(new FileReader("info.txt"))) {

            // Read the first line
            String line = br.readLine();

            // Print the first line
            System.out.println("First line: " + line);

        } catch (IOException e) {

            // Handle file reading exception
            System.out.println("Error reading file");
        }
    }
}

