package javaMixedProblems.inputOutput;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Reads console input and writes each entry to a file.
 * Input stops when the user enters "exit".
 */
public class InputToFile {

    /**
     * Main method to save user input to a file.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // Read characters from the console.
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter output file path: ");
        String fileName = sc.nextLine();

        // Write each input line to the file.
        try (FileWriter writer = new FileWriter(fileName)) {

            String line;

            System.out.println("Enter text (type exit to stop):");

            while ((line = reader.readLine()) != null) {

                // Stop when the user enters "exit".
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.write(line);
                writer.write(System.lineSeparator());
            }

            System.out.println("Input saved successfully.");

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
