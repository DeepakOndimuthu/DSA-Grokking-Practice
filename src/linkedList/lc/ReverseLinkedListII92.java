package linkedList.lc;

/*
BASIC
No. 4

Problem:
Reverse Linked List II

Pattern:
Linked List + Partial Reverse

Status:
✅ Solved


LeetCode:
92 (Reverse Linked List II)

Input:
1 -> 2 -> 3 -> 4 -> 5

left = 2
right = 4

Output:
1 -> 4 -> 3 -> 2 -> 5


Explanation:

Go to left position

Reverse selected nodes

Reconnect list

Return new head
*/

public class ReverseLinkedListII92{

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node reverseBetween(Node head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        Node dummy = new Node(0);

        dummy.next = head;

        Node previous = dummy;

        for (int i = 1; i < left; i++) {
            previous = previous.next;
        }

        Node current = previous.next;

        for (int i = 0; i < right - left; i++) {

            Node next = current.next;

            current.next = next.next;

            next.next = previous.next;

            previous.next = next;
        }

        return dummy.next;
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

        head = reverseBetween(head, 2, 4);

        System.out.println("After:");

        print(head);
    }
}

/*
Input:
1 -> 2 -> 3 -> 4 -> 5

left = 2
right = 4

Goal:
1 -> 4 -> 3 -> 2 -> 5

Only reverse middle.( that left to right)
head = linked list
left = reverse start position
right = reverse end position

****************
Create fake node.
Node dummy = new Node(0);

Now
dummy
0
Then
dummy.next = head;
Now:
0 -> 1 -> 2 -> 3 -> 4 -> 5

******************

Node previous = dummy;
Previous points to 0.
Visual
previous
 ↓
0 -> 1 -> 2 -> 3 -> 4 -> 5

************
first loop
left=2
previous = previous.next
Now
0 -> 1 -> 2 -> 3
     ↑
 previous
then i=2 so condition false Loop stop.

**********************

Node current = previous.next;
above Previous is at: 1 so next is 2
that is
current=2

visual
0 -> 1 -> 2 -> 3 -> 4 -> 5

     ↑   ↑

 previous current

***********************

Now reverse loop (Second loop)
left=2
right=4

Calculate
4-2=2

Run:
2 times

Nodes:
2 3 4
Need 2 moves.

*****************
loop start Part 1

Start:
1 -> 2 -> 3 -> 4 -> 5

Previous:1
Current:2

First
Node next = current.next;
next  = 3

Then
current.next = next.next;
current.next = 4

Before:
2 -> 3 -> 4

After:
2 -> 4
3 removed temporarily.

Visual
Now:
1 -> 2 -> 4 -> 5

3 removed temporarily.

***************
second loop first time Part 2

next.next = previous.next;
Before:
3 -> 4

After: (previous is 1 so 2 is next)
3 -> 2

Now:
3 -> 2 -> 4

then
previous.next = next;
Before:
1 -> 2

After:
1 -> 3

Now:
1 -> 3 -> 2 -> 4 -> 5
One reverse step done.

****************************
2 time loop go same like
final is Final:
1 -> 4 -> 3 -> 2 -> 5
After reverse: 0 STILL EXISTS.
0 -> 1 -> 4 -> 3 -> 2 -> 5

return dummy.next; not dummy so O ignore
***************
program flow:

1) first create dummy node with 0
2) attach this dummy to head node 0-> 1 -> 2 -> 3 -> 4 -> 5
3) set previous value to dummy
4) first for loop add find previous value
5) now current value set the previous next

6) then we move to second loop to reverse logic
second for loop we set
1) next value
2) current next value
3) next next value
4) previous next value

*****************

1 Create dummy node
2 Move previous before reverse area
3 current = previous.next

Reverse loop:
4 save next
5 remove next
6 attach next
7 connect previous

****************
why first loop is start with 1 and second loop start with zero

left=2
so previous is
dummy -> 1 -> 2
↑
previous

We need:
dummy -> 1 -> 2
         ↑
      previous

Only ONE move.

Reverse
Need:
2 3 4

Need exactly:
count= right-left
4-2 =2

loop 0
loop 1
2 loops.

So normal count:

0 to count-1
That is why second loop starts:
0

because this is not position.
This is repeat count.

************************
 */