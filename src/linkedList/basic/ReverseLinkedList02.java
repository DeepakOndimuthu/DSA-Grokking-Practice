package linkedList.basic;

/*
BASIC
No. 2

Problem:
Reverse Linked List

Pattern:
Linked List + Pointer Manipulation

Status:
✅ Solved


LeetCode:

206 (Reverse Linked List)

Input:
10 -> 20 -> 30 -> 40

Output:
40 -> 30 -> 20 -> 10

Explanation:

Reverse links one by one

current.next → previous

Move pointers forward

At end previous becomes new head
*/

public class ReverseLinkedList02 {

    // Node class
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node reverse(Node head) {

        Node previous = null;
        Node current = head;

        while (current != null) {

            Node next = current.next;

            current.next = previous;

            previous = current;

            current = next;
        }

        return previous;
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

        System.out.println("Before Reverse:");

        print(head);

        head = reverse(head);

        System.out.println();

        System.out.println("After Reverse:");

        print(head);

    }

}

/*
Previous sum 01 time
public static void traverse(Node head)
returns nothing

this sum
public static Node reverse(Node head)
returns Node so why Node

Before:
head
 ↓
10 -> 20 -> 30 -> 40

After reverse:
40 -> 30 -> 20 -> 10
↑
new head
So function returns
**********************************
Reverse Logic

Three pointers:
previous
current
next

Job:
previous → behind
current  → working node
next     → save future

*************
Initial:
10 -> 20 -> 30 -> 40 -> null

Variables:
previous = null

current
 ↓
10 -> 20 -> 30 -> 40

******************
Dry Run

Round1
previous=null
current=10
next=20

current.next = previous;
10.next = null
Just overwrite. (because before this line 10.next = 20)

previous =10
current = 20

visual
previous
 ↓
10 -> null

current
 ↓
20 -> 30 -> 40

*****************************
ROUND 2

previous=10
current=20
next=30

current.next = previous;
20.next = 10
Just overwrite. (because before this line 20.next = 30)
Now:
20 -> 10
30 -> 40

Move:
previous=20
current=30

*********************
ROUND 3

previous=20
current=30
next=40

current.next = previous;
30.next = 20
Just overwrite. (because before this line 30.next = 40)

Now:
Remember:
20 already points to 10.
Before:
20 -> 10
30 -> 40
After:
30 -> 20 -> 10
40

Move:
previous=30
current=40

visual
State:
previous
 ↓
30 -> 20 -> 10

current
 ↓
40

*********************
ROUND 4

previous=30
current=40
next=null

current.next = previous;
40.next = 30
Just overwrite. (because before this line 40.next = null)

Move:
previous=30
current=null

current=null
Loop stops.

*********************

Final memory trick:
next     → save future
current  → reverse arrow
previous → become behind
current  → move ahead

Reverse Logic
SAVE
TURN
FOLLOW
MOVE

Save future              -   next = current.next;
Turn arrow backward      -   current.next = previous;
Previous follows current -   previous = current;;
Move forward             -   current = next;

One-line memory:
Save future
Reverse current
Shift previous
Move current

************************
return previous;
previous is one variable only.
How does returning one variable return whole reversed list?

Before reverse:
head
 ↓
10 → 20 → 30 → 40

Actually:
head = address of 10
And:
10.next = 20
20.next = 30
30.next = 40
40.next = null

same like this also

Final state:
previous
 ↓
40 → 30 → 20 → 10

previous stores ONLY:
40
But:
40.next = 30
30.next = 20
20.next = 10
10.next = null

So from 40 you can reach all.
*************************
 */