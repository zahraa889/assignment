package assignment_1;

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

    /*
     Output:
     Returns the input string reversed.
     Example:
     Input  : "HELLO"
     Output : "OLLEH"
    */

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

    /*
     Output:
     Returns the stack sorted in ascending order.
     Example:
     Input  : [3, 1, 4, 2]
     Output : [1, 2, 3, 4]
    */

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

    /*
     Output:
     Returns the queue with elements in reverse order.
     Example:
     Input  : [1, 2, 3]
     Output : [3, 2, 1]
    */

    // ==================================================
    // Q4: Implement a priority queue where the smallest
    //     element is dequeued first
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

    /*
     Output:
     Elements are removed in ascending order.
     Example:
     Insert elements: 5, 1, 3
     Dequeue order  : 1 3 5
    */

    // ==================================================
    // Q5: Write a function to merge two sorted queues
    //     into a single sorted queue
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

    /*
     Output:
     Returns one sorted queue containing all elements
     from both queues.
     Example:
     q1 = [1, 3, 5]
     q2 = [2, 4, 6]
     Output = [1, 2, 3, 4, 5, 6]
    */
}
