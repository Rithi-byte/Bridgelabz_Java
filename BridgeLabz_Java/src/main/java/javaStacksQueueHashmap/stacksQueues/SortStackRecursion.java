package javaStacksQueueHashmap.stacksQueues;
import java.util.Stack;

public class SortStackRecursion {

    public static void sortStack(Stack<Integer> st) {

        if (st.isEmpty())
            return;

        int top = st.pop();

        sortStack(st);

        insertSorted(st, top);
    }

    public static void insertSorted(Stack<Integer> st, int value) {

        if (st.isEmpty() || st.peek() <= value) {
            st.push(value);
            return;
        }

        int top = st.pop();

        insertSorted(st, value);

        st.push(top);
    }
}