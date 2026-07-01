package linkedList.lc;

/*
BASIC
No. 8

Problem:
Partition List

Pattern:
Linked List + Two Dummy Lists

Status:
✅ Solved


LeetCode:

86 (Partition List)

Input:

10 -> 40 -> 20 -> 50 -> 30

x = 30

Output:

10 -> 20 -> 40 -> 50 -> 30

Explanation:

Create two dummy lists

Store nodes smaller than x

Store nodes greater than or equal to x

Connect both lists

Return merged list
*/

public class PartitionList86 {

    // Node class
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node partition(Node head, int x) {

        Node smallDummy = new Node(0);
        Node largeDummy = new Node(0);

        Node small = smallDummy;
        Node large = largeDummy;

        while (head != null) {

            if (head.data < x) {

                small.next = head; // Exactly like Merge Two Sorted Lists. 0 -> null to 0 ->10 ->40 ->20 ->50 ->30
                small = small.next; // Move to the next node.

            } else {

                large.next = head;
                large = large.next; // Move to the next node.
            }

            head = head.next; // Move to the next node.
        }

        large.next = null;

        small.next = largeDummy.next;

        return smallDummy.next;
    }

    public static void print(Node head) {

        Node temp = head;

        while (temp != null) {

            System.out.print(temp.data + " ");

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(10);

        head.next = new Node(40);
        head.next.next = new Node(20);
        head.next.next.next = new Node(50);
        head.next.next.next.next = new Node(30);

        System.out.println("Before Partition:");

        print(head);

        head = partition(head, 30);

        System.out.println("After Partition:");

        print(head);
    }
}

/*
Concept

Input
10 -> 40 -> 20 -> 50 -> 30
x = 30

Goal:
Small list
10 -> 20

Large list
40 -> 50 -> 30

Finally
10 -> 20 -> 40 -> 50 -> 30

************************

Pattern

Create Small List
        ↓
Create Large List
        ↓
Traverse Original List
        ↓
If node < x
Add to Small List
        ↓
Else
Add to Large List
        ↓
Connect Small List + Large List
        ↓
Return New Head

**********************
Input
10 -> 40 -> 20 -> 50 -> 30
x = 30

That if conditions
Final situation

Small
0 ->10 ->20
         ↑
       small

Large
0 ->40 ->50 ->30
              ↑
            large

****************
large.next = null;
Why only large?

suppose another example
1 ->4 ->3 ->2 ->5 ->2

During partition,
old links may still exist.

For example
5 ->2

might still be connected incorrectly.
So we always do

large.next = null;

to guarantee the last node ends properly.
It's a safety step.

****************
Why not
small.next = null;

Because the next line is
small.next = largeDummy.next;

We are going to connect
Small
↓
Large

So we don't want
20 -> null

We want
20 ->40

***********************
visual of that why not small and how works this
Current

Small
0 ->10 ->20

Large
0 ->40 ->50 ->30

Notice
largeDummy.next
↓
40

because
0 ->40
already exists.

So Java changes
20.next

from
null
to
40

Now
10 ->20 ->40 ->50 ->30

Done.

*******************
concept doubt
Node smallDummy = new Node(0);
Node small = smallDummy;

Picture:
smallDummy
     ↓
     0

small
  ↓
  0

Both point to the same node.

now doubt is
"I changed small, not smallDummy. How does smallDummy know?"

The answer is:
small moved. smallDummy never moved. But they were both pointing to the same linked list.

***********************************
compare 10 < 30 time:

1) head
 ↓
10 -> 40 -> 20 -> 50 -> 30 -> null

2) small.next = head;
0 -> 10 -> 40 -> 20 -> 50 -> 30

3) small = small.next;

smallDummy
 ↓
0 -> 10 -> 40 -> 20 -> 50 -> 30
     ↑
   small

4) now
head
 ↓
40 -> 20 -> 50 -> 30

****************************
compare 40 < 30 time:
the go to large list
1) now head move one step
head
 ↓
20 -> 50 -> 30

**********************
compare 20 < 30 time:
1) head current is
head
 ↓
20 -> 50 -> 30

2) small.next = head;
small = 10
10.next = 20

The old arrow:
10 -> 40
is replaced by
10 -> 20

3) small = small.next;

Picture:
smallDummy
 ↓
0 -> 10 -> 20 -> 50 -> 30
          ↑
        small

*************************
 */