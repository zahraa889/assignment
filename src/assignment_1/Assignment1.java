package assignment_1;

import java.util.*;


public class Assignment1 {

    /* =========================
       Q1: Clone an array
       ========================= */
    static int[] cloneArray(int[] arr) {
        return arr.clone();
    }

    /* =========================
       Q2: Remove random element from array
       ========================= */
    static int[] removeRandomElement(int[] arr) {
        if (arr.length == 0) return arr;
        Random r = new Random();
        int index = r.nextInt(arr.length);
        return removeAtIndex(arr, index);
    }

    /* =========================
       Q3: Remove specific element from array
       ========================= */
    static int[] removeSpecificElement(int[] arr, int value) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                index = i;
                break;
            }
        }
        if (index == -1) return arr;
        return removeAtIndex(arr, index);
    }

    static int[] removeAtIndex(int[] arr, int index) {
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index)
                newArr[j++] = arr[i];
        }
        return newArr;
    }

    /* =========================
       Q4: Reverse an array
       ========================= */
    static void reverseArray(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }

    /* =========================
       Singly Linked List Node
       ========================= */
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    /* =========================
       Q5: Concatenate two linked lists
       ========================= */
    static Node concatenate(Node head1, Node head2) {
        if (head1 == null) return head2;
        Node temp = head1;
        while (temp.next != null)
            temp = temp.next;
        temp.next = head2;
        return head1;
    }

    /* =========================
       Q6: Rotate linked list right by k
       ========================= */
    static Node rotateRight(Node head, int k) {
        if (head == null || k == 0) return head;

        Node temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        temp.next = head;
        k = k % length;
        int steps = length - k;

        Node newTail = temp;
        while (steps-- > 0)
            newTail = newTail.next;

        Node newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    /* =========================
       Q7: Search element in singly linked list (return position)
       ========================= */
    static int searchPosition(Node head, int key) {
        int pos = 0;
        while (head != null) {
            if (head.data == key)
                return pos;
            pos++;
            head = head.next;
        }
        return -1;
    }

    /* =========================
       Q8: Find index of value in linked list
       ========================= */
    static int indexOf(Node head, int value) {
        return searchPosition(head, value);
    }

    /* =========================
       Q9: Remove at specific position in singly linked list
       ========================= */
    static Node removeAtPosition(Node head, int pos) {
        if (head == null) return null;
        if (pos == 0) return head.next;

        Node temp = head;
        for (int i = 0; i < pos - 1 && temp.next != null; i++)
            temp = temp.next;

        if (temp.next != null)
            temp.next = temp.next.next;

        return head;
    }

    /* =========================
       Doubly Linked List Node
       ========================= */
    static class DNode {
        int data;
        DNode prev, next;
        DNode(int data) {
            this.data = data;
        }
    }

    /* =========================
       Q10: Remove duplicates from doubly linked list
       ========================= */
    static void removeDuplicates(DNode head) {
        HashSet<Integer> set = new HashSet<>();
        DNode temp = head;

        while (temp != null) {
            if (set.contains(temp.data)) {
                if (temp.prev != null)
                    temp.prev.next = temp.next;
                if (temp.next != null)
                    temp.next.prev = temp.prev;
            } else {
                set.add(temp.data);
            }
            temp = temp.next;
        }
    }

    /* =========================
       Q11: Traverse doubly linked list in reverse
       ========================= */
    static void printReverse(DNode tail) {
        while (tail != null) {
            System.out.print(tail.data + " ");
            tail = tail.prev;
        }
        System.out.println();
    }

    /* =========================
       Q12: Search element in doubly linked list
       ========================= */
    static boolean searchDoubly(DNode head, int key) {
        while (head != null) {
            if (head.data == key)
                return true;
            head = head.next;
        }
        return false;
    }

    /* =========================
       Circular Linked List Node
       ========================= */
    static class CNode {
        int data;
        CNode next;
        CNode(int data) {
            this.data = data;
        }
    }

    /* =========================
       Q13: Insert node at specific position in circular linked list
       ========================= */
    static CNode insertCircular(CNode head, int data, int pos) {
        CNode newNode = new CNode(data);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        if (pos == 0) {
            CNode temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newNode;
            newNode.next = head;
            return newNode;
        }

        CNode temp = head;
        for (int i = 0; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;

        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    /* =========================
       Q14: Delete node at specific position in circular linked list
       ========================= */
    static CNode deleteCircular(CNode head, int pos) {
        if (head == null) return null;

        if (pos == 0) {
            if (head.next == head) return null;
            CNode temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = head.next;
            return head.next;
        }

        CNode temp = head;
        for (int i = 0; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;

        temp.next = temp.next.next;
        return head;
    }

    /* =========================
       Q15: Search element in circular linked list
       ========================= */
    static boolean searchCircular(CNode head, int key) {
        if (head == null) return false;
        CNode temp = head;
        do {
            if (temp.data == key)
                return true;
            temp = temp.next;
        } while (temp != head);
        return false;
    }

    /* =========================
       Q16: Split circular linked list into two halves
       ========================= */
    static void splitCircular(CNode head) {
        if (head == null || head.next == head) return;

        CNode slow = head, fast = head;

        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        CNode head1 = head;
        CNode head2 = slow.next;

        slow.next = head1;

        CNode temp = head2;
        while (temp.next != head)
            temp = temp.next;
        temp.next = head2;

        System.out.println("First Half:");
        printCircular(head1);
        System.out.println("Second Half:");
        printCircular(head2);
    }

    static void printCircular(CNode head) {
        if (head == null) return;
        CNode temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}
