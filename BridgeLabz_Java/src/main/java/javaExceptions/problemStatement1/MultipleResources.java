package javaExceptions.problemStatement1;

import java.io.*;

public class MultipleResources {

    public static void main(String[] args) {

        // Define input and output file paths
        String file1 = "input1.txt";
        String file2 = "input2.txt";
        String outputFile = "combined.txt";

        // Try-with-resources manages all three resources
        try (
                BufferedReader br1 =
                        new BufferedReader(new FileReader(file1));

                BufferedReader br2 =
                        new BufferedReader(new FileReader(file2));

                BufferedWriter bw =
                        new BufferedWriter(new FileWriter(outputFile))
        ) {

            String line;

            // Read contents from first file
            while ((line = br1.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            // Read contents from second file
            while ((line = br2.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Files combined successfully!");

        } catch (IOException e) {

            // Handle file-related exceptions
            System.out.println("Error: " + e.getMessage());
        }
    }
}

