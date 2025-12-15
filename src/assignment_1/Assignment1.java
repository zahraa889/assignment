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

        temp.next = head; // make circular
        k = k % length;
        int steps = length - k;

        Node newTail = temp;
        while (steps-- > 0)
            newTail = newTail.next;

        Node newHead = newTail.next;
        newTail.next = null; // break circle
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
            return newNode; // new head
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
            if (head.next == head) return null; // one node
            CNode temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = head.next;
            return head.next;
        }

        CNode temp = head;
        for (int i = 0; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;

        if (temp.next != head) {
            temp.next = temp.next.next;
        }
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
        if (head == null) {
            System.out.println("(empty)");
            return;
        }
        CNode temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // =========================
// Helpers for printing/testing
// =========================
    static void printSingly(Node head) {
        Node t = head;
        while (t != null) {
            System.out.print(t.data + (t.next != null ? " -> " : ""));
            t = t.next;
        }
        System.out.println();
    }

    static void printDoublyForward(DNode head) {
        DNode t = head;
        while (t != null) {
            System.out.print(t.data + (t.next != null ? " <-> " : ""));
            t = t.next;
        }
        System.out.println();
    }

    static DNode getTail(DNode head) {
        if (head == null) return null;
        DNode t = head;
        while (t.next != null) t = t.next;
        return t;
    }

    // =========================
// MAIN: لتجربة وتشغيل كل الأسئلة
// =========================
    public static void main(String[] args) {

        // Q1
        int[] q1 = {1, 2, 3};
        System.out.println("Q1 clone: " + Arrays.toString(cloneArray(q1)));
        // Output:
        // Q1 clone: [1, 2, 3]

        // Q2
        int[] q2 = {10, 20, 30, 40};
        System.out.println("Q2 remove random: " + Arrays.toString(removeRandomElement(q2)));
        // Output:
        // Q2 remove random: الناتج يختلف لأن الحذف عشوائي
        // مثال ممكن: [10, 20, 40] أو [10, 30, 40] ... (طول المصفوفة يقل 1)

        // Q3
        int[] q3 = {1, 2, 3, 2, 4};
        System.out.println("Q3 remove value 2: " + Arrays.toString(removeSpecificElement(q3, 2)));
        // Output:
        // Q3 remove value 2: [1, 3, 2, 4]   (يحذف أول 2 فقط)

        // Q4
        int[] q4 = {5, 6, 7, 8};
        reverseArray(q4);
        System.out.println("Q4 reversed: " + Arrays.toString(q4));
        // Output:
        // Q4 reversed: [8, 7, 6, 5]

        // Build singly lists for Q5-Q9
        Node s1 = new Node(1);
        s1.next = new Node(2);
        s1.next.next = new Node(3);

        Node s2 = new Node(4);
        s2.next = new Node(5);

        // Q5
        Node merged = concatenate(s1, s2);
        System.out.print("Q5 concatenated: ");
        printSingly(merged);
        // Output:
        // Q5 concatenated: 1 -> 2 -> 3 -> 4 -> 5

        // Q6
        Node rotated = rotateRight(merged, 2);
        System.out.print("Q6 rotated k=2: ");
        printSingly(rotated);
        // Output:
        // Q6 rotated k=2: 4 -> 5 -> 1 -> 2 -> 3

        // Q7
        System.out.println("Q7 search position of 4: " + searchPosition(rotated, 4));
        // Output:
        // Q7 search position of 4: 0   (لأن 4 صار أول عنصر بعد الدوران)

        // Q8
        System.out.println("Q8 indexOf 99: " + indexOf(rotated, 99));
        // Output:
        // Q8 indexOf 99: -1   (لأن 99 غير موجود)

        // Q9
        Node afterRemove = removeAtPosition(rotated, 1);
        System.out.print("Q9 remove pos=1: ");
        printSingly(afterRemove);
        // Output:
        // Q9 remove pos=1: 4 -> 1 -> 2 -> 3   (حذفنا العنصر بالموقع 1 وهو 5)

        // Build doubly list for Q10-Q12
        DNode d1 = new DNode(1);
        DNode d2 = new DNode(2);
        DNode d3 = new DNode(2);
        DNode d4 = new DNode(3);
        DNode d5 = new DNode(1);

        d1.next = d2; d2.prev = d1;
        d2.next = d3; d3.prev = d2;
        d3.next = d4; d4.prev = d3;
        d4.next = d5; d5.prev = d4;

        // Q10
        removeDuplicates(d1);
        System.out.print("Q10 after remove duplicates: ");
        printDoublyForward(d1);
        // Output:
        // Q10 after remove duplicates: 1 <-> 2 <-> 3

        // Q11
        System.out.print("Q11 reverse traverse: ");
        printReverse(getTail(d1));
        // Output:
        // Q11 reverse traverse: 3 2 1

        // Q12
        System.out.println("Q12 search doubly 3: " + searchDoubly(d1, 3));
        // Output:
        // Q12 search doubly 3: true

        // Build circular list for Q13-Q16: 1 -> 2 -> 3 -> 4 -> back to 1
        CNode c1 = new CNode(1);
        CNode c2 = new CNode(2);
        CNode c3 = new CNode(3);
        CNode c4 = new CNode(4);
        c1.next = c2; c2.next = c3; c3.next = c4; c4.next = c1;

        // Q13
        CNode newHead = insertCircular(c1, 99, 1);
        System.out.print("Q13 after insert 99 at pos=1: ");
        printCircular(newHead);
        // Output:
        // Q13 after insert 99 at pos=1: 1 99 2 3 4

        // Q14
        CNode afterDeleteC = deleteCircular(newHead, 2);
        System.out.print("Q14 after delete pos=2: ");
        printCircular(afterDeleteC);
        // Output:
        // Q14 after delete pos=2: 1 99 3 4   (حذفنا العنصر بالموقع 2 وهو 2)

        // Q15
        System.out.println("Q15 search circular 99: " + searchCircular(afterDeleteC, 99));
        // Output:
        // Q15 search circular 99: true

        // Q16
        System.out.println("Q16 split circular:");
        splitCircular(afterDeleteC);
        // Output (printed by splitCircular):
        // First Half:
        // 1 99
        // Second Half:
        // 3 4
    }


}