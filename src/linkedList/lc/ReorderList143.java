package linkedList.lc;

/*
BASIC
No. 8

Problem:
Reorder List

Pattern:
Fast Slow Pointer + Reverse + Merge

Status:
✅ Solved


LeetCode:
143 (Reorder List)

Input:
1 -> 2 -> 3 -> 4

Output:
1 -> 4 -> 2 -> 3


Input:
1 -> 2 -> 3 -> 4 -> 5

Output:
1 -> 5 -> 2 -> 4 -> 3


Explanation:

Find middle node

Reverse second half

Merge first half and second half

Repeat until all nodes are connected
*/

public class ReorderList143 {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void reorderList(Node head) {

        if (head == null || head.next == null) {
            return;
        }

        // Find middle
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node previous = null;
        Node current = slow.next; // this sum second part is slow.next not slow previous like 234

        slow.next = null;

        while (current != null) {

            Node next = current.next;

            current.next = previous;

            previous = current;

            current = next;
        }

        // Merge two halves
        Node first = head;
        Node second = previous;

        while (second != null) {

            Node firstNext = first.next;
            Node secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }

    public static void print(Node head) {

        Node temp = head;

        while (temp != null) {

            System.out.print(temp.data);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(1);

        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Before:");

        print(head);

        reorderList(head);

        System.out.println("After:");

        print(head);
    }
}

/*
concept

Find Middle
      ↓
Reverse Second Half
      ↓
Merge One Node from First Half
      ↓
Merge One Node from Second Half
      ↓
Repeat

This problem combines three Linked List concepts you've already learned:
✅ Find Middle (LeetCode 876)
✅ Reverse Linked List (LeetCode 206)
✅ Merge Two Lists (alternate nodes)

*************************
How works
input: 1 -> 2 -> 3 -> 4 -> 5
1) Middle:
after find the middle 3

2) Reverse:
First part
1 -> 2 -> 3

Second part (slow.next so why after 3rd values node is reverse)
5 -> 4

Node second = previous;
previous points to 5

3) merge

imagine
Queue A : 1 2 3
Queue B : 5 4

Take one from A & B
1 & 5
then
2 & 4
Remaining from A.
3

Result:
1 -> 5 -> 2 -> 4 -> 3

that merge how save is:
Take one from A : 1
Take one from B : 5
Take one from A : 2
Take one from B : 4
Remaining from A : 3

********************************
why slow.next = null declare this sum, not 234 sum ,
first list still has 3 -> 4

So after reverse you get this strange picture:

First list
1 -> 2 -> 3 -> 4
               ↑

Second list
5 -> 4

Node 4 belongs to two lists.
but merge time 3 is still connected to 4.
So merge becomes confused.

Now if we cut.
slow.next = null;

First
1 -> 2 -> 3 -> null

Second
4 -> 5

Now there are two separate lists.
Now merging is very easy.

 */