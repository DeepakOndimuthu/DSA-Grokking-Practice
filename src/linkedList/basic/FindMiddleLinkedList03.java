package linkedList.basic;

/*
BASIC
No. 3

Problem:
Find Middle of Linked List

Pattern:
Slow Pointer + Fast Pointer

Status:
✅ Solved


LeetCode:

876 (Middle of the Linked List)
234 → Palindrome Linked List
141 → Linked List Cycle
143 → Reorder List

Input:
10 -> 20 -> 30 -> 40 -> 50

Output:
30

Explanation:

Slow moves 1 step

Fast moves 2 steps

When fast reaches end

Slow becomes middle
*/

public class FindMiddleLinkedList03 {

    // Node class
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node findMiddle(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;

            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        Node head = new Node(10);

        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        Node middle = findMiddle(head);

        System.out.println("Middle = " + middle.data);

    }

}

/*
Concept

slow 1x
fast 2x

Slow turtle 🐢
Fast rabbit 🐇

imagine Race Logic:
When fast finishes full distance
slow finished half distance

Road length = 100m

Slow:
1 meter/sec

Fast:
2 meter/sec

When fast reaches:
100m

Slow reaches:
50m

***********
Visual
List:
10 → 20 → 30 → 40 → 50

Track:

S,F

10
↓
20 ← S
30 ← F
30 ← S
50 ← F
STOP

Slow stayed middle.

**********************
DRY RUN

Dry Run

Input:

head
 ↓
10 → 20 → 30 → 40 → 50

Start:
slow = 10
fast = 10

Loop 1:
slow = 20
fast = 30

Loop 2:
slow = 30
fast = 50

Loop 3:
fast.next = null

STOP
Output:
30
********************
 */