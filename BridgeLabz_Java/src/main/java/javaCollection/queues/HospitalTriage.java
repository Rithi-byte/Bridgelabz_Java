package javaCollection.queues;

import java.util.*;

class Patient {

    // Patient attributes
    String name;
    int severity;

    // Constructor
    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    // Display patient details
    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriage {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create PriorityQueue
        // Higher severity patients are treated first
        PriorityQueue<Patient> patients =
                new PriorityQueue<>(
                        (p1, p2) ->
                                Integer.compare(p2.severity, p1.severity)
                );

        // Get number of patients
        System.out.println("Enter number of patients:");
        int n = sc.nextInt();

        // Get patient details
        for (int i = 0; i < n; i++) {

            System.out.println("Enter patient name:");
            String name = sc.next();

            System.out.println("Enter severity (1-5):");
            int severity = sc.nextInt();

            // Validate severity
            if (severity < 1 || severity > 5) {
                System.out.println("Invalid severity! Enter between 1 and 5.");
                i--;
                continue;
            }

            // Add patient to priority queue
            patients.add(new Patient(name, severity));
        }

        // Process patients according to severity
        System.out.println("\nHospital Treatment Order:");

        while (!patients.isEmpty()) {

            // Remove highest severity patient
            Patient p = patients.poll();

            System.out.println("Treating: " + p);
        }

        sc.close();
    }
}
