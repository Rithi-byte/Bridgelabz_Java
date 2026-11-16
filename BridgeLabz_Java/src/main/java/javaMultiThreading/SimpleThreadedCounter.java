package javaMultiThreading;

import java.util.Scanner;

/**
 * Problem Statement:
 * Create a multithreaded counter that counts from 1 to a user-specified
 * limit. Divide the counting range among multiple threads and ensure
 * that numbers are printed in the correct sequential order using
 * thread synchronization.
 *
 * @author Student
 */
class SharedCounter {

    private int currentCount = 1;
    private final int countingLimit;

    /**
     * Initializes the shared counter.
     *
     * @param countingLimit maximum number to be printed
     */
    public SharedCounter(int countingLimit) {
        this.countingLimit = countingLimit;
    }

    /**
     * Prints the numbers assigned to a particular thread.
     * Threads wait until the shared counter reaches their range.
     *
     * @param start starting number assigned to the thread
     * @param end ending number assigned to the thread
     */
    public synchronized void printNumbers(int start, int end) {

        // Wait until the counter reaches this thread's range.
        while (currentCount < start && currentCount <= countingLimit) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        // Print all numbers belonging to this thread.
        while (currentCount >= start && currentCount <= end
                && currentCount <= countingLimit) {

            System.out.println(
                    Thread.currentThread().getName()
                            + " : " + currentCount
            );

            currentCount++;

            // Notify other threads that the counter has changed.
            notifyAll();
        }

        // Wake up waiting threads when this range is completed.
        notifyAll();
    }
}

/**
 * Represents an individual counter thread.
 * Each thread is responsible for printing a specific range.
 */
class CounterThread extends Thread {

    private final SharedCounter sharedCounter;
    private final int start;
    private final int end;

    /**
     * Creates a counter thread with an assigned range.
     *
     * @param sharedCounter shared counter object
     * @param start starting number of the assigned range
     * @param end ending number of the assigned range
     * @param threadName name of the thread
     */
    public CounterThread(SharedCounter sharedCounter,
                         int start,
                         int end,
                         String threadName) {

        super(threadName);
        this.sharedCounter = sharedCounter;
        this.start = start;
        this.end = end;
    }

    /**
     * Executes the counting task.
     */
    @Override
    public void run() {
        sharedCounter.printNumbers(start, end);
    }
}

/**
 * Main class responsible for accepting user input
 * and creating the counter threads.
 */
public class SimpleThreadedCounter {

    /**
     * Program execution starts here.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter counting limit: ");
            int countingLimit = scanner.nextInt();

            if (countingLimit <= 0) {
                System.out.println("Please enter a positive integer.");
                return;
            }

            // Divide the counting range among three threads.
            int numberOfThreads = 3;

            int rangeSize =
                    (countingLimit + numberOfThreads - 1)
                            / numberOfThreads;

            SharedCounter sharedCounter =
                    new SharedCounter(countingLimit);

            CounterThread firstThread = new CounterThread(
                    sharedCounter, 1, rangeSize, "Thread-1"
            );

            CounterThread secondThread = new CounterThread(
                    sharedCounter, rangeSize + 1,
                    2 * rangeSize, "Thread-2"
            );

            CounterThread thirdThread = new CounterThread(
                    sharedCounter, 2 * rangeSize + 1,
                    countingLimit, "Thread-3"
            );

            // Start all three threads.
            firstThread.start();
            secondThread.start();
            thirdThread.start();

            // Wait until all threads complete execution.
            firstThread.join();
            secondThread.join();
            thirdThread.join();

            System.out.println("Counting completed!");

        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted.");

        } finally {
            scanner.close();
        }
    }
}
