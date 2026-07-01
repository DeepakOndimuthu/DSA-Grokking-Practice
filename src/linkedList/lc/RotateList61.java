package linkedList.lc;

/*
BASIC
No. 7

Problem:
Rotate List

Pattern:
Linked List + Length + Circular Link

Status:
✅ Solved


LeetCode:

61 (Rotate List)

Input:

10 -> 20 -> 30 -> 40 -> 50

k = 2

Output:

40 -> 50 -> 10 -> 20 -> 30

Explanation:

Find length of linked list

Connect last node to head (make circle)

Find new tail

Break the circle

Return new head
*/

public class RotateList61 {

    // Node class
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node rotateRight(Node head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length and last node
        Node tail = head;

        int length = 1;

        while (tail.next != null) {

            tail = tail.next;

            length++;
        }

        // Reduce extra rotations
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Make circular list
        tail.next = head;

        // Find new tail
        int steps = length - k;

        Node newTail = head;

        for (int i = 1; i < steps; i++) {

            newTail = newTail.next;
        }

        // New head
        Node newHead = newTail.next;

        // Break circle
        newTail.next = null;

        return newHead;
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

        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        System.out.println("Before Rotate:");

        print(head);

        head = rotateRight(head, 2);

        System.out.println("After Rotate:");

        print(head);
    }
}

/*
pattern & visual picture last is there check easy understanding

Find Length
      ↓
Find Last Node
      ↓
Connect Tail to Head (Circle)
      ↓
Find New Tail
      ↓
New Head = NewTail.next
      ↓
Break Circle

*****************

Initially

head
tail
 ↓
10 -> 20 -> 30 -> 40 -> 50

length = 1

Why 1?
Because tail is already on the first node (10).

*****************
Find length and last node
Length count while loop

Move 1

tail = 20
length = 2

Move 2

tail = 30
length = 3

Move 3

tail = 40
length = 4

Move 4

tail = 50
length = 5

Stop.
Because

50.next = null
Final
tail
 ↓
50

length = 5

***************
Reduce extra rotations
k = k % length;
so,
2 % 5 = 2

****************
Make circular list
tail.next = head;

Current list
10 -> 20 -> 30 -> 40 -> 50 -> null

tail.next = head;

means
50.next = 10

Now
10 ->20 ->30 ->40 ->50
↑                  |
|__________________|

It becomes a circle.

**************************
Find new tail
int steps = length - k;
= 5 - 2 = 3
It is 3.

******************
Node newTail = head;

Currently
newTail
↓
10

for loop & remember above steps = 3
Loop
i=1
i=2

Move 1
10 ->20

Move 2
20 ->30

Final
newTail
↓
30

******************
New head
Node newHead = newTail.next;

Current
newTail
↓
30

What is
30.next
?
40

so
newHead
↓
40

Notice
We DID NOT create
40 ->50

It already exists.
Because the circle still exists.

Actually
40 ->50 ->10 ->20 ->30 ->40...

Still circular.

*******************
Break circle
newTail.next = null;

Current
30.next
↓
40

Change
30.next
↓
null

Now
Before

10 ->20 ->30 ->40 ->50
↑                  |
|__________________|

After
40 ->50 ->10 ->20 ->30 ->null

Circle is broken.
Done.

********************************
Final visual picture

1) Before
10 ->20 ->30 ->40 ->50 ->null

2) Make Circle
10 ->20 ->30 ->40 ->50
↑                  |
|__________________|

3) New Tail
10 ->20 ->30 ->40 ->50
          ↑
       newTail

4) New Head
10 ->20 ->30 ->40 ->50
               ↑
            newHead

5) Break Circle
40 ->50 ->10 ->20 ->30 ->null

*******************
This line
tail.next = head;

does NOT mean
tail becomes circular

It means
50.next = 10

Now the linked list itself becomes
head
 ↓
10 -> 20 -> 30 -> 40 -> 50
↑                       |
|_______________________|

Notice:
The nodes changed, not the variable.

Now you create
Node newTail = head;

This is
newTail
   ↓
10 -> 20 -> 30 -> 40 -> 50
↑                       |
|_______________________|

Even though newTail starts from head, it is walking on the same circular linked list.

Why?
Because
50.next
is already
10

*******************************

 */
