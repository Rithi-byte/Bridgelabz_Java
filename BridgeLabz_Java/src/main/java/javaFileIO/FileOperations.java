package javaFileIO;
import java.io.IOException;
import java.io.File;
import java.io.*;
import java.util.Scanner;
/**
 * Write a program to
 * demonstrate File
 * Operations like
 * - Check File Exists
 * - Delete File and Check File Not Exist
 * - Create Directory
 * - Create Empty File
 * - List Files, Directories as well as Files with Extension
 */


public class FileOperations {

    public static void main(String[] args) throws IOException {

        // 1. Check whether a file exists
        File file = new File("sample.txt");

        System.out.println("File exists: " + file.exists());

        // 2. Delete file and check whether it no longer exists
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully");
            }
        }

        System.out.println("File exists after deletion: " + file.exists());

        // 3. Create a directory
        File directory = new File("MyFolder");

        if (directory.mkdir()) {
            System.out.println("Directory created successfully");
        } else {
            System.out.println("Directory already exists or creation failed");
        }

        // 4. Create an empty file
        File emptyFile = new File("MyFolder/empty.txt");

        if (emptyFile.createNewFile()) {
            System.out.println("Empty file created successfully");
        } else {
            System.out.println("File already exists");
        }

        // Create additional files for listing demonstration
        new File("MyFolder/data.txt").createNewFile();
        new File("MyFolder/image.jpg").createNewFile();
        new File("MyFolder/document.pdf").createNewFile();

        // 5. List all files and directories
        System.out.println("\nAll files and directories:");

        File[] allItems = directory.listFiles();

        if (allItems != null) {
            for (File item : allItems) {
                System.out.println(item.getName());
            }
        }

        // 6. List only files
        System.out.println("\nFiles only:");

        if (allItems != null) {
            for (File item : allItems) {
                if (item.isFile()) {
                    System.out.println(item.getName());
                }
            }
        }

        // 7. List only directories
        System.out.println("\nDirectories only:");

        if (allItems != null) {
            for (File item : allItems) {
                if (item.isDirectory()) {
                    System.out.println(item.getName());
                }
            }
        }

        // 8. List files with a specific extension (.txt)
        System.out.println("\nFiles with .txt extension:");

        if (allItems != null) {
            for (File item : allItems) {
                if (item.isFile() && item.getName().endsWith(".txt")) {
                    System.out.println(item.getName());
                }
            }
        }
    }
}
