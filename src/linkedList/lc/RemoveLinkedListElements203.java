package linkedList.lc;

/*
LC
No. 1

Problem:
203. Remove Linked List Elements

Pattern:
Linked List Traversal + Delete

Status:
✅ Solved


Question:

Given the head of a linked list and an integer val,
remove all nodes where Node.val == val.

Return new head.


Example 1:

Input:
1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6

val = 6

Output:
1 -> 2 -> 3 -> 4 -> 5


Example 2:

Input:
[]

val = 1

Output:
[]


Example 3:

Input:
7 -> 7 -> 7 -> 7

val = 7

Output:
[]


Explanation:

Start from head

Check next node

If value matches

Skip node

Continue traversal

Return updated head
*/

public class RemoveLinkedListElements203 {

    // Node class
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // remove elements
    public static Node removeElements(Node head, int val) {

        // remove matching nodes from beginning
        while (head != null && head.data == val) {

            head = head.next;
        }

        Node current = head;

        while (current != null &&
                current.next != null) {

            if (current.next.data == val) {
                // skip node
                current.next = current.next.next;

            } else {
                current =current.next;
            }
        }

        return head;
    }

    // print linked list
    public static void print(Node head) {

        Node current = head;

        while (current != null) {

            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current =current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // create list

        Node head = new Node(1);

        head.next = new Node(2);

        head.next.next =new Node(6);

        head.next.next.next = new Node(3);

        head.next.next.next.next = new Node(4);

        head.next.next.next.next.next = new Node(5);

        head.next.next.next.next.next.next = new Node(6);

        int val = 6;

        System.out.println("Before:");

        print(head);

        head =removeElements(head,val);

        System.out.println("After:" );

        print(head);

    }
}
/*
Move head forward until first value is NOT remove value.

Example:
head
 ↓
1 -> 2 -> 6 -> 3

Now imagine:Example2
Input:
6 -> 6 -> 2 -> 3
remove=6

Problem:
First node itself must be removed.

***************
first while loop

head!=null && head.data==6
TRUE

Move:
head=head.next;

Before:
head
 ↓
6 -> 6 -> 2 -> 3

After:
head
      ↓
6 -> 2 -> 3

Round 2
Again:
head=head.next;

Now:
head
         ↓
2 -> 3

Stop.
Now list starts from:
2 -> 3

That first while means:
Move head forward until first value is NOT remove value.
*****************************************
Part 2 — Second while Start traversal

Node current = head;
head
 ↓
1 -> 2 -> 6 -> 3

current
 ↓
1

while condition is
current exists
AND
next node exists

Why check next?
Because later we do:

current.next.data

Without checking:
null.data ❌ ERROR

**********************
Remove nodes
if (current.next.data == val)

NOT:
current.data

BUT:
current.next.data

Why?

Because current stays behind.
Example:
current
 ↓
1 -> 2 -> 6 -> 3

Check:
current.next

means:2

Move.

Now:
current
     ↓
1 -> 2 -> 6 -> 3

Check:
current.next

means:6
Found.

******************
how remove part

current.next = current.next.next;

This is the magic.
Before:
current
 ↓
2 -> 6 -> 3

Meaning:
2.next = 6

Execute:
current.next = current.next.next;

Becomes:
2.next = 3

Now:
2 -----> 3

Node 6 disconnected.

Visual:
Before:
1 -> 2 -> 6 -> 3

After:
1 -> 2 -----> 3
*********************

Else block

If not remove:
current = current.next;

Move forward.
Example:
1 -> 2 -> 3

current
 ↓
becomes
1 -> 2 -> 3
     ↑
 current
****************

 */

/*
LC version
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

class Solution {

    public ListNode removeElements(ListNode head, int val) {
        // remove matching nodes from beginning
        while (head != null && head.val == val) {

            head = head.next;
        }

        ListNode  current = head;

        while (current != null &&
                current.next != null) {

            if (current.next.val == val) {

                // skip node
                current.next =
                        current.next.next;

            } else {

                current =
                        current.next;
            }
        }

        return head;

    }
}
 */