package javaStacksQueueHashmap.stacksQueues;
import java.util.Stack;

public class QueueUsingStacks {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void enqueue(int x) {
        input.push(x);
    }

    public int dequeue() {
        if (input.isEmpty() && output.isEmpty())
            return -1;

        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.pop();
    }

    public int peek() {
        if (input.isEmpty() && output.isEmpty())
            return -1;

        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}