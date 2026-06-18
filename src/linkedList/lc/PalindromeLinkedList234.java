package linkedList.lc;

/*
BASIC
No. 6

Problem:
Palindrome Linked List

Pattern:
Linked List + Fast Slow Pointer + Reverse

Status:
✅ Solved


LeetCode:
234 (Palindrome Linked List)

Input:
1 -> 2 -> 2 -> 1

Output:
true


Explanation:

Find middle node

Reverse second half

Compare first half and second half

If all values match
return true

Else
return false
*/

public class PalindromeLinkedList234 {

    static class Node {

        int data;
        Node next; // address of next node

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean isPalindrome(Node head) {

        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        // Find Middle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        Node previous = null;
        Node current = slow;

        // Reverse
        while (current != null) {

            Node next = current.next;

            current.next = previous;

            previous = current;

            current = next;
        }

        Node firstHalf = head;
        Node secondHalf = previous;

        // Compare
        while (secondHalf != null) {

            if (firstHalf.data != secondHalf.data) {
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {

        Node head = new Node(1);

        head.next = new Node(2);

        head.next.next = new Node(2);

        head.next.next.next = new Node(1);

        System.out.println(isPalindrome(head));
    }
}

/*
Palindrome means:

Read from left to right
and
Read from right to left
both are same
**************************
Example:
1 -> 2 -> 2 -> 1
Forward:
1 2 2 1
Backward:
1 2 2 1
Same.

Answer:
true

Example 2:
1 -> 2
Forward:
1 2
Backward:
2 1
Different.
Answer:
false
**************************

Logic

Find Middle
↓
Reverse Second Half
↓
Compare Both Halves

**************
Step 1 - Find Middle
Start:

slow = 1
fast = 1

Round 1
slow -> 2
fast -> 2

Round 2
slow -> second 2
fast -> null

Now
1 -> 2 -> 2 -> 1
          ↑
        slow
slow points to the beginning of the second half

*****************
Step 2 - Reverse Second Half

Before reverse:
1 -> 2 -> 2 -> 1
          ↑
       current

Reverse only:
2 -> 1

After reverse:
1 -> 2

1 -> 2
↑
previous

Note:
The first half stays the same.
Only the second half is reversed.

****************
Step 3 - Compare

firstHalf
1 -> 2
and
secondHalf
1 -> 2
Compare.

First comparison
1 == 1
Move both.

Second comparison
2 == 2
Move both.

Second half becomes null.
Loop ends.
Return
true;

****************

Reverse (this sum two times loop while run)

1 -> 2 -> 2 -> 1
          ↑
        slow

Node previous = null;
Node current = slow; //2

enter while loop
Node next = current.next;
Node next = 1

current.next = previous
current.next = null  // 2 -> 1  to 2 -> null

previous = current;
previous = 2

current = next;
current  =  1

ok now go to next time while loop

visual
End of first loop:
previous -> 2 -> null
current -> 1

*************
second time loop run
previous = 2
current = 1

Node next = current.next;
next = null
Last node is 1 -> null

current.next = previous;
current.next = 2  // 1 -> null to 1 -> 2
Now:
1 -> 2 -> null

previous = current;
previous = 1

current = next;
current  =  null

So:
current = null
loop ends

********
compare
(this sum two times loop while run)
firstHalf : 1 -> 2 -> 2 -> 1
secondHalf : 1 -> 2

in reverse concept change the order
Original List
firstHalf
    ↓
1 -> 2 -> 2 -> 1
          ↑
       (old middle)


Reversed Half
secondHalf
      ↓
1 -> 2

*********
First loop
Current pointers:
firstHalf
 ↓
1 -> 2 -> 2 -> 1

secondHalf
 ↓
1 -> 2

Compare:
1 == 1
yes, So don't return false.
Move both.

firstHalf = firstHalf.next;
secondHalf = secondHalf.next;

************

Now:
firstHalf
     ↓
1 -> 2 -> 2 -> 1
     ↑
     2

secondHalf
     ↓
1 -> 2
     ↑
     2
Second loop
Compare:
2 == 2

Correct.
Move both again.

Now:
firstHalf
          ↓
1 -> 2 -> 2 -> 1
          ↑
          2

secondHalf
          ↓
null

so loop Finished.
***************

 */
