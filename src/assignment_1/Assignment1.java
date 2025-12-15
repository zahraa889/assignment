package assignment_1;

import java.util.Random;

public class Assignment1 {

    // =========================
    // Q1: Clone an array
    // =========================
    static int[] cloneArray(int[] a) {
        return (a == null) ? null : a.clone();
    }

    // =========================
    // Q2: Remove a random element from an array
    // =========================
    static int[] removeRandom(int[] a) {
        if (a == null || a.length == 0) return a;
        int idx = new Random().nextInt(a.length);
        return removeAt(a, idx);
    }

    // =========================
    // Q3: Remove a specific element from an array
    // =========================
    static int[] removeValue(int[] a, int value) {
        if (a == null) return null;
        int idx = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == value) {
                idx = i;
                break;
            }
        }
        return (idx == -1) ? a : removeAt(a, idx);
    }

    // =========================
    // Q4: Reverse an array
    // =========================
    static void reverseArray(int[] a) {
        if (a == null) return;
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

    // Helper method (used in Q2 & Q3)
    static int[] removeAt(int[] a, int idx) {
        if (a == null || idx < 0 || idx >= a.length) return a;
        int[] r = new int[a.length - 1];
        for (int i = 0, k = 0; i < a.length; i++) {
            if (i != idx) r[k++] = a[i];
        }
        return r;
    }

    // =========================
    // Singly Linked List Node
    // =========================
    static class SNode {
        int data;
        SNode next;
        SNode(int d) { data = d; }
    }

    // =========================
    // Q5: Concatenate two linked lists
    // =========================
    static SNode concatenate(SNode h1, SNode h2) {
        if (h1 == null) return h2;
        SNode cur = h1;
        while (cur.next != null) cur = cur.next;
        cur.next = h2;
        return h1;
    }

    // =========================
    // Q6: Rotate a linked list right by k
    // =========================
    static SNode rotateRight(SNode head, int k) {
        if (head == null || head.next == null || k <= 0) return head;

        int n = 1;
        SNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        k %= n;
        if (k == 0) return head;

        tail.next = head; // make circular
        int steps = n - k;
        SNode newTail = head;
        for (int i = 1; i < steps; i++) newTail = newTail.next;

        SNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    // =========================
    // Q8: Search and return position (1-based)
    // =========================
    static int searchPosition(SNode head, int value) {
        int pos = 1;
        for (SNode cur = head; cur != null; cur = cur.next) {
            if (cur.data == value) return pos;
            pos++;
        }
        return -1;
    }

    // =========================
    // Q9: Find index (0-based)
    // =========================
    static int indexOf(SNode head, int value) {
        int idx = 0;
        for (SNode cur = head; cur != null; cur = cur.next) {
            if (cur.data == value) return idx;
            idx++;
        }
        return -1;
    }

    // =========================
    // Q11: Remove at specific position (0-based)
    // =========================
    static SNode removeAtPosition(SNode head, int pos) {
        if (head == null || pos < 0) return head;
        if (pos == 0) return head.next;

        SNode prev = head;
        for (int i = 0; i < pos - 1 && prev.next != null; i++)
            prev = prev.next;

        if (prev.next != null)
            prev.next = prev.next.next;

        return head;
    }

    // =========================
    // Doubly Linked List Node
    // =========================
    static class DNode {
        int data;
        DNode prev, next;
        DNode(int d) { data = d; }
    }

    // =========================
    // Q12: Remove duplicates from doubly linked list
    // =========================
    static DNode removeDuplicates(DNode head) {
        for (DNode cur = head; cur != null; cur = cur.next) {
            for (DNode run = cur.next; run != null; ) {
                DNode nextRun = run.next;
                if (run.data == cur.data) {
                    if (run.prev != null) run.prev.next = run.next;
                    if (run.next != null) run.next.prev = run.prev;
                }
                run = nextRun;
            }
        }
        if (head != null) head.prev = null;
        return head;
    }

    // =========================
    // Q13: Traverse doubly linked list in reverse
    // =========================
    static void printReverse(DNode head) {
        if (head == null) return;
        DNode tail = head;
        while (tail.next != null) tail = tail.next;
        for (DNode cur = tail; cur != null; cur = cur.prev)
            System.out.print(cur.data + " ");
        System.out.println();
    }

    // =========================
    // Q14: Search in doubly linked list
    // =========================
    static boolean search(DNode head, int value) {
        for (DNode cur = head; cur != null; cur = cur.next)
            if (cur.data == value) return true;
        return false;
    }

    // =========================
    // Circular Linked List Node
    // =========================
    static class CNode {
        int data;
        CNode next;
        CNode(int d) { data = d; }
    }

    // =========================
    // Q15: Insert at specific position in circular linked list
    // =========================
    static CNode insertAt(CNode head, int pos, int val) {
        CNode n = new CNode(val);
        if (head == null) {
            n.next = n;
            return n;
        }

        if (pos == 0) {
            CNode last = head;
            while (last.next != head) last = last.next;
            n.next = head;
            last.next = n;
            return n;
        }

        CNode prev = head;
        for (int i = 1; i < pos && prev.next != head; i++)
            prev = prev.next;

        n.next = prev.next;
        prev.next = n;
        return head;
    }

    // =========================
    // Q16: Delete at specific position in circular linked list
    // =========================
    static CNode deleteAt(CNode head, int pos) {
        if (head == null) return null;

        if (pos == 0) {
            if (head.next == head) return null;
            CNode last = head;
            while (last.next != head) last = last.next;
            head = head.next;
            last.next = head;
            return head;
        }

        CNode prev = head;
        for (int i = 1; i < pos && prev.next != head; i++)
            prev = prev.next;

        prev.next = prev.next.next;
        return head;
    }

    // =========================
    // Q17: Search in circular linked list
    // =========================
    static boolean searchCircular(CNode head, int value) {
        if (head == null) return false;
        CNode cur = head;
        do {
            if (cur.data == value) return true;
            cur = cur.next;
        } while (cur != head);
        return false;
    }

    // =========================
    // Q18: Split circular linked list into two halves
    // =========================
    static CNode[] splitHalves(CNode head) {
        if (head == null) return new CNode[]{null, null};

        CNode slow = head, fast = head;
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        CNode head1 = head;
        CNode head2 = slow.next;

        fast.next = head2;
        slow.next = head1;

        return new CNode[]{head1, head2};
    }
}
