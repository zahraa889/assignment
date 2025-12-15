package assignment_2;

import java.util.*;

public class Assignment2 {
    // ==================================================
// Q1: Write a function to reverse a string using Stack
// ==================================================
    static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    // ==================================================
// Q2: Write a function to sort a stack using only another Stack
// ==================================================
    static Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                stack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }

        return tempStack;
    }

    // ==================================================
// Q3: Write a function to reverse the order of elements in a queue
// ==================================================
    static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        return queue;
    }

    // ==================================================
// Q4: Implement a priority queue where the smallest element is dequeued first
// ==================================================
    static class MinPriorityQueue {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        void enqueue(int value) {
            pq.add(value);
        }

        int dequeue() {
            return pq.poll();
        }

        boolean isEmpty() {
            return pq.isEmpty();
        }
    }

    // ==================================================
// Q5: Write a function to merge two sorted queues into a single sorted queue
// ==================================================
    static Queue<Integer> mergeSortedQueues(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> result = new LinkedList<>();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek() <= q2.peek())
                result.add(q1.poll());
            else
                result.add(q2.poll());
        }

        while (!q1.isEmpty())
            result.add(q1.poll());

        while (!q2.isEmpty())
            result.add(q2.poll());

        return result;
    }

    // ==================================================
// MAIN: لتجربة وتشغيل كل الأسئلة + كتابة المخرجات كتَعليق
// ==================================================
    public static void main(String[] args) {

        // Q1
        System.out.println("Q1 Reverse String: " + reverseString("HELLO"));
        // Output:
        // Q1 Reverse String: OLLEH

        // Q2
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(1);
        st.push(4);
        st.push(2);
        System.out.println("Q2 Sorted Stack: " + sortStack(st));
        // Output:
        // Q2 Sorted Stack: [1, 2, 3, 4]

        // Q3
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("Q3 Reversed Queue: " + reverseQueue(q));
        // Output:
        // Q3 Reversed Queue: [3, 2, 1]

        // Q4
        MinPriorityQueue mpq = new MinPriorityQueue();
        mpq.enqueue(5);
        mpq.enqueue(1);
        mpq.enqueue(3);

        System.out.print("Q4 Priority Queue Dequeue Order: ");
        while (!mpq.isEmpty()) {
            System.out.print(mpq.dequeue() + " ");
        }
        System.out.println();
        // Output:
        // Q4 Priority Queue Dequeue Order: 1 3 5

        // Q5
        Queue<Integer> q1 = new LinkedList<>(Arrays.asList(1, 3, 5));
        Queue<Integer> q2 = new LinkedList<>(Arrays.asList(2, 4, 6));
        System.out.println("Q5 Merged Sorted Queues: " + mergeSortedQueues(q1, q2));
        // Output:
        // Q5 Merged Sorted Queues: [1, 2, 3, 4, 5, 6]
    }

}