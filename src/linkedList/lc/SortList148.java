package linkedList.lc;

/*
BASIC
No. 10

Problem:
Sort List

Pattern:
Linked List + Merge Sort

Status:
✅ Solved


LeetCode:

148 (Sort List)

Input:

4 -> 2 -> 1 -> 3

Output:

1 -> 2 -> 3 -> 4

Explanation:

Find middle node

Split into two halves

Sort both halves recursively

Merge two sorted lists

Return sorted list
*/

public class SortList148 {

    // Node class
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node sortList(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        Node second = slow.next;

        slow.next = null;

        Node left = sortList(head);

        Node right = sortList(second);

        return merge(left, right);
    }

    public static Node merge(Node list1, Node list2) {

        Node dummy = new Node(0);

        Node tail = dummy;

        while (list1 != null && list2 != null) {

            if (list1.data <= list2.data) {

                tail.next = list1;

                list1 = list1.next;

            } else {

                tail.next = list2;

                list2 = list2.next;
            }

            tail = tail.next;
        }

        if (list1 != null) {

            tail.next = list1;

        } else {

            tail.next = list2;
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

        Node head = new Node(4);

        head.next = new Node(2);

        head.next.next = new Node(1);

        head.next.next.next = new Node(3);

        System.out.println("Before Sort:");

        print(head);

        head = sortList(head);

        System.out.println("After Sort:");

        print(head);
    }
}

/*
Pattern:

Find Middle
      ↓
Split List into Two Halves
      ↓
Sort Left Half
      ↓
Sort Right Half
      ↓
Merge Both Sorted Halves
      ↓
Return Sorted List

Note: recursion concept come so why that after middle code part is i not understand
after end visual below dry code is that recursion concept easily understand

************************

Input:
4 -> 2 -> 1 -> 3

Find middle:

4 -> 2 -> 1 -> 3
     ↑
   slow
slow points to 2.

*************
Step 2 ( Recursion)

Node second = slow.next;
slow.next?
1
So

second
 ↓
1 -> 3

Now we have
head
 ↓
4 -> 2 -> 1 -> 3

second
 ↓
1 -> 3

The list is still connected.
Nothing has been split yet.

**********************
Step 3
slow.next = null;

This changes
2.next

from
1
to
null

Before
4 -> 2 -> 1 -> 3

After
Left
4 -> 2 -> null


Right
1 -> 3

Now the list is split into two halves.

**********************

*****Now comes recursion********
Node left = sortList(head);

means
"Sort the left half."

Current left half
4 -> 2

So Java calls
sortList(4 -> 2)

again.

Notice
It is not calling with the full list.
It is calling only with
4 -> 2

***************************
Inside that new call

Input is
4 -> 2

Again Java runs
sortList()

from the beginning.
Again
Find middle.
Again
Split.

Result
4
2

Then Java calls
sortList(4)

and

sortList(2)

Now look at this condition.

if(head == null || head.next == null)
    return head;

For
4
there is only one node.
So
return 4

For
2
only one node.

So
return 2

No more splitting.
Then

merge(4,2)

returns
2 -> 4

So
left
↓
2 -> 4

Now Java goes back.

Next line
Node right = sortList(second);

Remember
second
↓
1 -> 3

Again Java calls
sortList(1 -> 3)

Again split.
1
3

Again
sortList(1)
sortList(3)

Return
1
3

Merge
1 -> 3
So

right
↓
1 -> 3

Now we have

left
2 -> 4


right
1 -> 3

Last line
return merge(left,right);

becomes
merge(2 -> 4, 1 -> 3)

Result
1 -> 2 -> 3 -> 4

Finished.

**************************

Visual
4 2 1 3
      |
      |
     Split
      |
 ----------------
 |              |
4 2            1 3
 |              |
Split         Split
 |              |
----          ----
|  |          |  |
4  2          1  3


Then merge

4 + 2
↓
2 4


1 + 3
↓

1 3

Then
2 4
+
1 3

↓
1 2 3 4

*********************
Full dry code of recursion time

1) First call

Input:
4 -> 2 -> 1 -> 3

Split into:

Left:
4 -> 2

Right:
1 -> 3

Now Java reaches:
Node left = sortList(head);

That means:
"Don't continue yet. First completely sort the left side."

*************************
2) Second call

Now Java is inside:
sortList(4 -> 2)

Split again:
4
2

Now Java again reaches:
Node left = sortList(head);

This becomes
sortList(4)

****************
3) Third call

Input:
4

This satisfies:
if (head == null || head.next == null)

So Java returns
4
Now:
left = 4

******************

Now Java continues with

Node right = sortList(second);

Here
second = 2

So it calls
sortList(2)
*************************

4) Fourth call

Input:
2

Return immediately
2

Now:
right = 2

Now Java finally executes
return merge(left, right);

At this level:
left = 4
right = 2

So it does
merge(4, 2)

Result:
2 -> 4

This is returned to the first call.

*********************
Final merge return time

return dummy.next;  why not return tail.next;

dummy
tail
 ↓
0


As the merge continues, tail keeps moving.

For example, after merging:

0 -> 1 -> 2 -> 3 -> 4

                ↑
              tail

At the end,
tail
 ↓
4

What is
tail.next
?
null

because 4 is the last node.

so we  return
dummy
 ↓
0 -> 1 -> 2 -> 3 -> 4
So we return

return dummy.next;

which points to
1 -> 2 -> 3 -> 4

************************
 */