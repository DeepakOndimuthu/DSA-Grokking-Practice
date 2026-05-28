package linkedList.lc;

/*
MEDIUM
No. 5

Problem:
Reverse Nodes in k-Group

Pattern:
Linked List + Group Reverse

Status:
✅ Solved


LeetCode:
25 (Reverse Nodes in k-Group)

Input:
1 -> 2 -> 3 -> 4 -> 5

k = 2

Output:
2 -> 1 -> 4 -> 3 -> 5


Explanation:

Take k nodes

Reverse that group

Reconnect with next group

If remaining nodes < k
leave them as it is

*/

public class ReverseNodesInKGroup25 {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node reverseKGroup(Node head, int k) {

        if (head == null || k == 1) {
            return head;
        }

        Node dummy = new Node(0);
        dummy.next = head;

        Node previousGroup = dummy;

        while (true) {

            Node kth = previousGroup;

            // Find kth node - Check if k nodes exist.
            for (int i = 0; i < k; i++) {
                kth = kth.next;
                if (kth == null) {
                    return dummy.next;
                }
            }


            Node groupNext = kth.next;
            Node previous = groupNext;
            Node current = previousGroup.next;

            while (current != groupNext) {

                Node next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            Node temp = previousGroup.next;
            previousGroup.next = kth;
            previousGroup = temp;
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

        head = reverseKGroup(head, 2);

        System.out.println("After:");

        print(head);
    }
}

/*
Concept

Example:
Input:

1 -> 2 -> 3 -> 4 -> 5
k = 2

Step 1:
Take first 2 nodes
1 -> 2

Reverse:
2 -> 1

List now:
2 -> 1 -> 3 -> 4 -> 5

************
Step 2:
Take next 2 nodes
3 -> 4

Reverse:
4 -> 3

List now:
2 -> 1 -> 4 -> 3 -> 5

***************
Step 3:
Remaining node:
5

Only 1 node
k = 2

So do not reverse.
Final:
2 -> 1 -> 4 -> 3 -> 5

***************
we do not know how many groups exist & when list ends
so while true is
Keep processing groups again and again
until return happens

if (kth == null) {
    return dummy.next;
}
This stops the program.

****************

Node previousGroup = dummy;
previousGroup
     |
     v
0 -> 1 -> 2 -> 3 -> 4 -> 5

************
Node kth = previousGroup;
previousGroup
     |
     v
0 -> 1 -> 2 -> 3 -> 4 -> 5

kth
 |
 v
0 -> 1 -> 2 -> 3 -> 4 -> 5

******************
For loop
Input:
0 -> 1 -> 2 -> 3 -> 4 -> 5
k = 2

i = 0
kth = kth.next;

0 -> 1 -> 2 -> 3 -> 4 -> 5
     ^
     |
    kth

i = 1
Again:
kth = kth.next;

Now:
0 -> 1 -> 2 -> 3 -> 4 -> 5
          ^
          |
         kth

Loop finished.
So kth node = 2

We found 2 nodes
1 -> 2
These nodes will reverse.
**************************
Next Part
Node groupNext = kth.next;

Currently:
0 -> 1 -> 2 -> 3 -> 4 -> 5
          ^
          |
         kth
so groupNext = 3

Visual:
0 -> 1 -> 2 -> 3 -> 4 -> 5
               ^
               |
           groupNext

******************
Node previous = groupNext;
So:
previous = 3

Visual:
0 -> 1 -> 2 -> 3 -> 4 -> 5
               ^
               |
            previous

********************
Node current = previousGroup.next;
previousGroup.next = 1
Now:

0 -> 1 -> 2 -> 3 -> 4 -> 5
     ^
     |
   current

*******************
Reverse Loop Starts

while (current != groupNext)
means:

Reverse until current reaches 3
So reverse only:

1 -> 2

****************
Current state:
0 -> 1 -> 2 -> 3 -> 4 -> 5
     ^
     |
   current

previous = 3

******************
Step 1:
Node next = current.next;
so next = 2

Step 2
current.next = previous;
1.next = 3

Now:
1 -> 3 -> 4 -> 5

Visual:
0 -> 1 -> 3 -> 4 -> 5
2 still separate

Step 3
previous = current;
so previous = 1

Step 4
current = next;
so current = 2

Visual:

previous
    |
    v
1 -> 3 -> 4 -> 5

current
   |
   v
2

********************
Second Reverse Round

Current:
current = 2
groupNext = 3

Still not equal.
Continue.

*****************
Step 1
next = current.next;
next = 3

Step 2
current.next = previous;
means:
2.next = 1
Now:
2 -> 1 -> 3 -> 4 -> 5

Step 3
previous = current;
previous = 2

Step 4
current = next;
current = 3
Now:
current == groupNext
Loop stops.

Current Final Shape
2 -> 1 -> 3 -> 4 -> 5
*********************

BUT dummy still points to 1
Like this:
0 -> 1 -> 3 -> 4 -> 5

2 -> 1 -> 3 -> 4 -> 5
Need reconnect.

************
Node temp = previousGroup.next;
temp = 1

previousGroup.next = kth;
0.next = 2

Now:
0 -> 2 -> 1 -> 3 -> 4 -> 5
Correctly connected 🎉

****************

previousGroup = temp;
means:
previousGroup = 1

Visual:
0 -> 2 -> 1 -> 3 -> 4 -> 5
          ^
          |
    previousGroup
Now next group starts after 1
So next reverse will process:
3 -> 4
********************
Second group loop
0 -> 2 -> 1 -> 3 -> 4 -> 5
          ^
          |
 previousGroup

          ^
          |
         kth
Both point to node 1
Now For Loop Starts Again
k = 2
Need move 2 times.

****************
First Move
Now:
0 -> 2 -> 1 -> 3 -> 4 -> 5
               ^
               |
              kth

kth = 3

*******************
Second Move
Again:
kth = kth.next;

Now:
0 -> 2 -> 1 -> 3 -> 4 -> 5
                    ^
                    |
                   kth

kth = 4
Loop finished.

Meaning
Now program found next group:
3 -> 4
******************

 */