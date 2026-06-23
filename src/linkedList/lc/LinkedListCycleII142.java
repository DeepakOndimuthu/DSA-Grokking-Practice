package linkedList.lc;

/*
BASIC
No. 9

Problem:
Linked List Cycle II

Pattern:
Fast Slow Pointer

Status:
✅ Solved


LeetCode:
142 (Linked List Cycle II)

Input:
3 -> 2 -> 0 -> -4
     ^         |
     |_________|

Output:
Node with value 2


Explanation:

Find meeting point using slow and fast pointers

Move one pointer to head

Move both one step at a time

The node where both meet again

Is the starting node of the cycle
*/

public class LinkedListCycleII142 {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node detectCycle(Node head) {

        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                Node start = head;

                while (start != slow) {

                    start = start.next;
                    slow = slow.next;
                }

                return start;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Node head = new Node(3);

        Node node2 = new Node(2);
        Node node3 = new Node(0);
        Node node4 = new Node(-4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Create cycle
        node4.next = node2;

        Node cycleStart = detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at: " + cycleStart.data);
        } else {
            System.out.println("No Cycle");
        }
    }
}

/*
concept
We already found the meeting point. ( if block => if (slow == fast) )
Why don't we return slow?

Because:
Meeting point ≠ Cycle starting point

Example:
3 -> 2 -> 0 -> -4
     ^         |
     |_________|

Cycle starts at:
2

But slow and fast might meet at:
-4
or
0

So we need one more step
***************************
step 1

Suppose after the first while loop:
3 -> 2 -> 0 -> -4
     ^         |
     |_________|

slow
 ↓
-4

fast
 ↓
-4

They meet at -4.
Question:

Is -4 the cycle start?
No.

Cycle starts at:
2

So don't return slow.

***********************
Step 2

Create another pointer.

Node start = head;

Now:
start
 ↓
3 -> 2 -> 0 -> -4
     ^         |
     |_________|

slow
 ↓
-4

Now two people are standing.

Person A
start
starts from the beginning.

Person B
slow

starts from the meeting point.
********************************
Step 3

Move both one step only.

First move:

start = start.next;
slow = slow.next;

Now:
start
 ↓
2

slow
 ↓
2

WOW!
They meet at:
2

This is the cycle start.
Return it.

***********************
Mathematical logic

Fast and slow meet somewhere inside the cycle.
↓
Move one pointer to head.
↓
Move both one step.
↓
Where they meet again
=
Start of cycle.

**********************

Real-life example

Imagine a circular running track.
Entrance
   |
   v

A ---------- B ---------- C
             ^            |
             |____________|

Two runners meet somewhere inside the circle.
Suppose they meet at:
C

Can you say:
C

is the entrance?
No.

The entrance is:
B

Now:
Runner 1 goes back to the entrance (head).
Runner 2 stays at the meeting point (slow).

Both now walk at the same speed.

After some steps:
Runner 1 → B
Runner 2 → B

They meet exactly at the entrance of the circle.
Linked List Cycle II uses exactly this idea.

***********************

 */
