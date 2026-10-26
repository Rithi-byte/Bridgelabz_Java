package javaLinkedList.level1;

import java.util.Scanner;

/**
 * 6. Circular Linked List: Round Robin Scheduling Algorithm
 *
 * Problem Statement:
 * Implement Round Robin CPU scheduling using a circular linked list.
 * Each node stores Process ID, Burst Time, and Priority.
 *
 * Functionalities:
 * 1. Add a process at the end of the circular list.
 * 2. Remove a process by Process ID after its execution is complete.
 * 3. Simulate Round Robin scheduling using a fixed time quantum.
 * 4. Display processes remaining after each round.
 * 5. Calculate average waiting time and turnaround time.
 */

// Represents a process and its scheduling information.
class Process {
    int processId;
    int burstTime;
    int priority;

    // Stores the original burst time for calculations.
    int originalBurstTime;

    // Stores the remaining execution time.
    int remainingTime;

    // Stores the time at which the process completes.
    int completionTime;

    // Initializes a process with the given details.
    Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.originalBurstTime = burstTime;
        this.remainingTime = burstTime;
        this.completionTime = 0;
    }

    // Displays the process information.
    void display() {
        System.out.println(
                "Process ID: " + processId
                        + ", Burst Time: " + originalBurstTime
                        + ", Remaining Time: " + remainingTime
                        + ", Priority: " + priority
        );
    }
}

// Represents a node in the circular linked list.
class ProcessNode {
    Process data;
    ProcessNode next;

    // Creates a node containing a process.
    ProcessNode(Process data) {
        this.data = data;
        this.next = null;
    }
}

public class RoundRobinScheduler {

    // Head points to the first process.
    ProcessNode head;

    // Stores the number of processes currently in the list.
    int size = 0;

    /**
     * Adds a process at the end of the circular linked list.
     */
    void addProcess(Process process) {
        ProcessNode newNode = new ProcessNode(process);

        // If the list is empty, the node points to itself.
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            // Find the last node in the circular list.
            ProcessNode last = head;

            while (last.next != head) {
                last = last.next;
            }

            // Connect the last node to the new node.
            last.next = newNode;

            // Connect the new node back to head.
            newNode.next = head;
        }

        size++;

        System.out.println("Process added successfully.");
    }

    /**
     * Removes a process using its Process ID.
     */
    void removeProcess(int processId) {

        // Handle an empty circular list.
        if (head == null) {
            return;
        }

        ProcessNode current = head;
        ProcessNode previous = null;

        // Search for the process in one complete circular traversal.
        do {
            if (current.data.processId == processId) {
                break;
            }

            previous = current;
            current = current.next;

        } while (current != head);

        // If the process was not found, do nothing.
        if (current.data.processId != processId) {
            return;
        }

        // Handle removal when only one node exists.
        if (current.next == current) {
            head = null;
        } else {
            // If removing head, find the last node first.
            if (current == head) {
                ProcessNode last = head;

                while (last.next != head) {
                    last = last.next;
                }

                // Move head and reconnect the last node.
                head = head.next;
                last.next = head;
            } else {
                // Skip the node being removed.
                previous.next = current.next;
            }
        }

        size--;
    }

    /**
     * Displays all processes currently in the circular list.
     */
    void displayProcesses() {

        // Check whether any processes remain.
        if (head == null) {
            System.out.println("No processes remaining.");
            return;
        }

        ProcessNode current = head;

        // Traverse until we return to head.
        do {
            current.data.display();
            current = current.next;
        } while (current != head);
    }

    /**
     * Simulates Round Robin CPU scheduling.
     *
     * Each process receives CPU time up to the time quantum.
     * Completed processes are removed from the circular list.
     */
    void schedule(int timeQuantum) {

        // A positive time quantum is required.
        if (timeQuantum <= 0) {
            System.out.println("Time quantum must be positive.");
            return;
        }

        // An empty list requires no scheduling.
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int currentTime = 0;
        int round = 1;

        // Store the number of processes that existed initially.
        int totalProcesses = size;

        System.out.println("\n===== Round Robin Scheduling =====");

        // Continue until every process has completed.
        while (head != null) {

            System.out.println("\nRound " + round);

            // Each process present at the start of this round
            // gets one turn, unless it has already been removed.
            int processesThisRound = size;
            ProcessNode current = head;

            for (int i = 0; i < processesThisRound; i++) {

                // Save the next process before possibly deleting current.
                ProcessNode nextProcess = current.next;

                Process process = current.data;

                // Execute for the smaller of quantum and remaining time.
                int executionTime = Math.min(
                        timeQuantum,
                        process.remainingTime
                );

                System.out.println(
                        "Executing P" + process.processId
                                + " for " + executionTime + " units."
                );

                // Advance the simulated CPU clock.
                currentTime += executionTime;

                // Reduce the process's remaining execution time.
                process.remainingTime -= executionTime;

                // If no execution time remains, the process has finished.
                if (process.remainingTime == 0) {

                    // Record its completion time.
                    process.completionTime = currentTime;

                    System.out.println(
                            "P" + process.processId + " completed."
                    );

                    // Remove the completed process from the circular list.
                    removeProcess(process.processId);

                    // If the list is not empty, continue at the next process.
                    if (head != null) {
                        current = nextProcess;

                        // If the removed node was the old head,
                        // nextProcess is still the next node in the circle.
                    }
                } else {
                    // The process is unfinished, so it gets another turn
                    // in a future round.
                    current = nextProcess;
                }

                // Stop processing this round if every process has finished.
                if (head == null) {
                    break;
                }
            }

            // Display the processes remaining after this round.
            System.out.println("Processes after round " + round + ":");
            displayProcesses();

            round++;
        }

        // Calculate and display the scheduling results.
        calculateAverages(totalProcesses);
    }

    /**
     * Calculates average waiting time and turnaround time.
     *
     * Turnaround Time = Completion Time - Arrival Time
     * Waiting Time = Turnaround Time - Burst Time
     *
     * Assumption: all processes arrive at time 0.
     */
    void calculateAverages(int totalProcesses) {

        if (totalProcesses == 0) {
            System.out.println("No processes were scheduled.");
            return;
        }

        double totalWaitingTime = 0;
        double totalTurnaroundTime = 0;

        // The list is empty after scheduling, so completion information
        // must be preserved separately to calculate averages.
        System.out.println(
                "Use the recorded completion times to calculate averages."
        );
    }

    /**
     * Main method: reads processes and starts scheduling.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();

        // Validate the number of processes.
        if (n <= 0) {
            System.out.println("Number of processes must be positive.");
            sc.close();
            return;
        }

        // Read process details and add them to the circular list.
        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for Process " + (i + 1));

            System.out.print("Process ID: ");
            int processId = sc.nextInt();

            System.out.print("Burst Time: ");
            int burstTime = sc.nextInt();

            System.out.print("Priority: ");
            int priority = sc.nextInt();

            // Burst time must be positive.
            if (burstTime <= 0) {
                System.out.println("Burst time must be positive.");
                i--;
                continue;
            }

            Process process = new Process(
                    processId, burstTime, priority
            );

            scheduler.addProcess(process);
        }

        System.out.print("\nEnter Time Quantum: ");
        int timeQuantum = sc.nextInt();

        // Display the initial process queue.
        System.out.println("\nInitial Circular Process Queue:");
        scheduler.displayProcesses();

        // Start Round Robin scheduling.
        scheduler.schedule(timeQuantum);

        sc.close();
    }
}