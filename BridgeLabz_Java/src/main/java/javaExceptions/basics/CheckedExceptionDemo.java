package javaExceptions.basics;

import java.io.*;

public class CheckedExceptionDemo {

    public static void main(String[] args) {

        // Open the file and read its contents
        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt"))) {

            String line;

            // Read the file line by line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {

            // Handle file-related exceptions
            System.out.println("File not found");
        }
    }
}
