package linkedList.lc;

/*
BASIC
No. 7

Problem:
Linked List Cycle

Pattern:
Fast Pointer + Slow Pointer

Status:
✅ Solved


LeetCode:
141 (Linked List Cycle)

Input:
3 -> 2 -> 0 -> -4
          ^      |
          |______|

Output:
true

Explanation:

Create two pointers

Slow moves 1 step

Fast moves 2 steps

If both pointers meet

Cycle exists

Else

No cycle
*/

public class LinkedListCycle141 {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean hasCycle(Node head) {

        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;

            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Node head = new Node(3);

        head.next = new Node(2);

        head.next.next = new Node(0);

        head.next.next.next = new Node(-4);

        // Create cycle
        head.next.next.next.next = head.next;

        System.out.println(hasCycle(head));
    }
}

/*

concept:

Normal List
1 -> 2 -> 3 -> null
Fast reaches null
Return false

Cycle List
1 -> 2 -> 3
     ^     |
     |_____|

Fast keeps moving
Slow keeps moving
Eventually both meet
Return true

The only difference is:
876: Stop when fast reaches the end, then slow is the middle.
141: If slow == fast before reaching the end, there is a cycle.

 */