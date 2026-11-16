package javaMultiThreading;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Problem Statement:
 * Implement the Producer-Consumer problem using two threads
 * and a shared bounded queue.
 *
 * The producer generates integer tasks and inserts them into
 * the shared queue. The consumer retrieves and processes them.
 *
 * Synchronization must be used to prevent race conditions.
 *
 * @author Student
 */
class SharedResource {

    private final Queue<Integer> taskQueue = new ArrayDeque<>();

    private final int queueCapacity = 3;

    /**
     * Produces a task and adds it to the shared queue.
     * If the queue is full, the producer waits.
     *
     * @param task the integer task to be produced
     * @throws InterruptedException if the producer is interrupted
     */
    public synchronized void produceTask(int task)
            throws InterruptedException {

        // Wait while the queue is full.
        while (taskQueue.size() == queueCapacity) {
            System.out.println("Queue full. Producer is waiting...");
            wait();
        }

        // Insert the task into the queue.
        taskQueue.add(task);

        System.out.println("Produced: " + task);

        // Notify the consumer that a task is available.
        notifyAll();
    }

    /**
     * Retrieves a task from the shared queue.
     * If the queue is empty, the consumer waits.
     *
     * @return the retrieved integer task
     * @throws InterruptedException if the consumer is interrupted
     */
    public synchronized int consumeTask()
            throws InterruptedException {

        // Wait while the queue is empty.
        while (taskQueue.isEmpty()) {
            System.out.println("Queue empty. Consumer is waiting...");
            wait();
        }

        // Remove the task from the queue.
        int task = taskQueue.poll();

        // Notify the producer that space is available.
        notifyAll();

        return task;
    }
}

/**
 * Producer thread responsible for generating integer tasks.
 */
class Producer extends Thread {

    private final SharedResource sharedResource;

    /**
     * Initializes the producer with a shared resource.
     *
     * @param sharedResource shared queue used for communication
     */
    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    /**
     * Generates five tasks and inserts them into the queue.
     * Sends -1 as a termination signal after production.
     */
    @Override
    public void run() {

        try {
            for (int task = 1; task <= 5; task++) {

                sharedResource.produceTask(task);

                // Simulate the time required to produce a task.
                Thread.sleep(500);
            }

            // Send termination signal to the consumer.
            sharedResource.produceTask(-1);

            System.out.println("Producer completed production.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Producer thread interrupted.");
        }
    }
}

/**
 * Consumer thread responsible for retrieving and processing tasks.
 */
class Consumer extends Thread {

    private final SharedResource sharedResource;

    /**
     * Initializes the consumer with a shared resource.
     *
     * @param sharedResource shared queue used for communication
     */
    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    /**
     * Continuously consumes tasks until the termination signal
     * is received.
     */
    @Override
    public void run() {

        try {
            while (true) {

                int task = sharedResource.consumeTask();

                // Stop consuming when the termination signal is received.
                if (task == -1) {
                    System.out.println("Consumer received termination signal.");
                    break;
                }

                System.out.println("Consumed: " + task);

                // Simulate the time required to process a task.
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consumer thread interrupted.");
        }
    }
}

/**
 * Main class that creates and starts the producer
 * and consumer threads.
 */
public class ProducerConsumer {

    /**
     * Entry point of the producer-consumer application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // Create a shared resource for both threads.
        SharedResource sharedResource = new SharedResource();

        Producer producerThread = new Producer(sharedResource);
        Consumer consumerThread = new Consumer(sharedResource);

        // Start producer and consumer concurrently.
        producerThread.start();
        consumerThread.start();

        try {
            // Wait for both threads to finish.
            producerThread.join();
            consumerThread.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Producer-Consumer execution completed.");
    }
}
