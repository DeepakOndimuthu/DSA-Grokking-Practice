package linkedList.basic;

/*
BASIC
No. 5

Problem:
Remove Nth Node From End of Linked List

Pattern:
Two Pointers (Gap Method)

Status:
✅ Solved


LeetCode:

19 (Remove Nth Node From End of List)
21 (Merge Two Sorted Lists)
61 (Rotate List)
86 (Partition List)

Input:
10 -> 20 -> 30 -> 40 -> 50

n = 2

Output:
10 -> 20 -> 30 -> 50

Explanation:

Move fast pointer n steps ahead

Move both pointers together

When fast reaches last node

Slow reaches node before target

Remove target node
*/

public class RemoveNthNode05 {

    // Node class
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node removeNthFromEnd(Node head, int n) {

        Node dummy = new Node(0);
        dummy.next = head;

        Node slow = dummy;
        Node fast = dummy;

        // Move fast n+1 steps
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove target node (point out what slow.next)
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void print(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");

            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(10);

        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        System.out.println("Before Remove:");

        print(head);

        head = removeNthFromEnd(head, 2);

        System.out.println();

        System.out.println("After Remove:");

        print(head);

    }

}

/*

Question:
Remove the 2nd node from the end.

Count from end:
50 = 1st
40 = 2nd

Remove:
40

Result:
10 -> 20 -> 30 -> 50

**********************

Whole idea
We don't count the total length.
Instead, we keep a gap.

Fast

            Slow
 ↓            ↓
10 ->20 ->30 ->40 ->50

After moving fast first:

Slow                     Fast
 ↓                        ↓
10 ->20 ->30 ->40 ->50

Gap stays the same.

When Fast reaches the end,
Slow automatically reaches one node before the target.

That is the trick.
********************************************
Why Dummy Node?

Code:
Node dummy = new Node(0);
dummy.next = head;

Suppose input is
10 ->20 ->30

and
n = 3

We must remove
10
(the first node)

Without dummy:
head
↓
10 ->20 ->30

There is no node before 10.
How can Slow stand before 10?

Impossible.

*******************
With dummy:

dummy
↓
0 ->10 ->20 ->30

Now there IS a node before 10.
That node is
0
(dummy)

Now removal becomes easy.

This is why dummy is used.
It handles removing the first node.

Dummy creates previous node one.

*********************

Why n+1 steps?

Input:
10 ->20 ->30 ->40 ->50
n = 2

Create:

dummy
↓
0 ->10 ->20 ->30 ->40 ->50
S
F

Both start here.

******************
Move Fast

for(int i=0;i<=n;i++)
n=2

Loop:
i=0
i=1
i=2

Total:
3 moves

****************
Move 1
0 ->10

Move 2
10 ->20

Move 3
20 ->30

Now
0 ->10 ->20 ->30 ->40 ->50

S
            F

Gap:
S ->10 ->20 ->30 <-F

Exactly 3 nodes apart.

*************************
Why 3?
Because
n = 2

Need one extra node
2 + 1 = 3

That extra one lets Slow stop before the node to delete.

If we moved only
2
Slow would stop ON the node.
We don't want that.

We need
Before Target

**********************

after for loop finish
slow = 0
fast = 30

While loop

Round 1
S=10
F=40

Round 2
S=20
F=50

Round 3
S=30
F=null

Loop stops.

Notice:
Slow is now

10 ->20 ->30 ->40 ->50
          ↑
        Slow

Exactly before
40

*************
Remove
slow.next = slow.next.next;

Before
30 ->40 ->50

After
30 ------>50

40 is skipped.

*******************
We return
dummy.next

dummy
↓
0 ->10 ->20 ->30 ->40 ->50

dummy.next
10 ->20 ->30 ->40 ->50

******************


 */