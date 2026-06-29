package linkedList.lc;

/*
BASIC
No. 6

Problem:
Merge Two Sorted Lists

Pattern:
Linked List + Two Pointers

Status:
✅ Solved


LeetCode:

21 (Merge Two Sorted Lists)

Input:

List1:
10 -> 30 -> 50

List2:
20 -> 40 -> 60

Output:

10 -> 20 -> 30 -> 40 -> 50 -> 60

Explanation:

Compare both list values

Take smaller node

Move that pointer

Repeat until one list finishes

Attach remaining nodes
*/

public class MergeTwoSortedLists06 {

    // Node class
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node merge(Node list1, Node list2) {

        Node dummy = new Node(0);

        Node tail = dummy;

        while (list1 != null && list2 != null) {

            if (list1.data <= list2.data) {

                tail.next = list1; // add list1 to tail node

                list1 = list1.next; // move one point next

            } else {

                tail.next = list2; // add list2 to tail node

                list2 = list2.next; // move one point next
            }

            tail = tail.next; // move tail one step next (0 to 10 first time)
        }

        if (list1 != null) {

            tail.next = list1; // add pending list node to tail last

        } else {

            tail.next = list2; // // add pending list node to tail last
        }

        return dummy.next;
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

        Node list1 = new Node(10);
        list1.next = new Node(30);
        list1.next.next = new Node(50);

        Node list2 = new Node(20);
        list2.next = new Node(40);
        list2.next.next = new Node(60);

        System.out.println("List 1:");

        print(list1);

        System.out.println("List 2:");

        print(list2);

        Node result = merge(list1, list2);

        System.out.println("Merged List:");

        print(result);
    }
}

/*
concept:

Compare
↓
Take Smaller Node
↓
Move That Pointer
↓
Move Tail
↓
Repeat
↓
Attach Remaining Nodes

***************
Start

List1
10 -> 30 -> 50

List2
20 -> 40 -> 60

dummy
tail
 ↓
0 -> null

tail

is just pointing to
0

*****************
First while loop

initial:

list1
10 -> 30 -> 50

list2
20 -> 40 -> 60

tail
0

compare
i) 10 <= 20
Yes
tail.next = list1;  ( note : This doesn't copy the whole list.)
It only changes one pointer.

Before:
0 -> null

After:
0 -> 10 -> 30 -> 50

ii) list1 = list1.next;

Currently,
list1
↓
10 ->30 ->50

Move
list1 = list1.next;

Now
list1
↓
30 ->50

Notice
The node
10

did NOT disappear.
Only
list1
(pointer) moved.

iii) Next
tail = tail.next;

tail
↓
0

Move
tail
↓
10

Now
0 ->10 ->30 ->50
      ↑
    tail

****************************
list1
10 -> 30 -> 50

list2
20 -> 40 -> 60
*************

Second loop

i) compare
30  <= 20
No, so else block

ii)  tail.next = list2;

Before
10 -> 30 -> 50 ( Java changes only tail.next )

After
10 ->20 ->40 ->60

Again,
nothing copied.

Only
10.next
changed.

iii) Move
list2 = list2.next;

list2 became this like
↓
40 ->60

iv) Move tail
tail = tail.next;

Now
tail
↓
20

Merged list
0 ->10 ->20

visual
So
0 -> 10 -> 20 -> 40 -> 60
           ↑
         tail

******************
Third time while loop

30 <= 40
yes , so if block

final
0 ->10 ->20 ->30

*****************
fourth tie while loop
Take
40

Now
0 ->10 ->20 ->30 ->40

fifth time while loop
Take
50

Now
0 ->10 ->20 ->30 ->40 ->50

Now
list1 = null
because

50
was the last node.
***************************

Last part
if(list1 != null)
False.

So
tail.next = list2;

Current
list2
↓
60

Java does
50.next =60

Finished.

Result
0 ->10 ->20 ->30 ->40 ->50 ->60

******************


 */
