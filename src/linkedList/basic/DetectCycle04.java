package linkedList.basic;

/*
BASIC
No. 4

Problem:
Detect Cycle in Linked List

Pattern:
Slow Pointer + Fast Pointer (Floyd's Cycle Detection)

Status:
✅ Solved


LeetCode:

141 (Linked List Cycle)
142 → Linked List Cycle II
202 → Happy Number (same slow & fast idea)
287 → Find the Duplicate Number (same pattern)

Input:

10 -> 20 -> 30 -> 40
      ^         |
      |_________|

Output:
Cycle Detected

Explanation:

Slow moves 1 step

Fast moves 2 steps

If both pointers meet

Cycle exists

Otherwise

No cycle
*/

public class DetectCycle04 {

    // Node class
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean hasCycle(Node head) {

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

        Node head = new Node(10);

        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        head.next = second;
        second.next = third;
        third.next = fourth;

        // create cycle
        fourth.next = second; // This is why it is 20, not 10.

        if (hasCycle(head)) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle");
        }

    }

}

/*
Dry Run
Linked List
10 → 20 → 30 → 40
     ↑         ↓
     └─────────┘

The cycle is:
20 → 30 → 40
↑         ↓
└─────────┘
// create cycle
fourth.next = second; -> This is why it is 20, not 10.

Initial
slow = 10
fast = 10

Loop 1
slow = 20
fast = 30

Loop 2
slow = 30
fast = 20

Loop 3
slow = 40
fast = 40
Both meet ✅

Return
true

 */
