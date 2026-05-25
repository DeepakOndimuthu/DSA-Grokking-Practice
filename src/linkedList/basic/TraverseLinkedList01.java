package linkedList.basic;

/*
BASIC
No. 1

Problem: Traverse Linked List

Pattern:
Linked List Traversal

Status:
✅ Solved


LeetCode similar:

876 (Middle of the Linked List)
203 (Remove Linked List Elements)

Input:
10 -> 20 -> 30 -> 40

Output:
10 20 30 40

Explanation:

Start from head

Visit current node

Print value

Move to next node

Stop when current becomes null
*/

public class TraverseLinkedList01 {

    // Node class
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void traverse(Node head) {

        Node current = head;

        while (current != null) {

            System.out.print(current.data + " ");

            current = current.next;
        }
    }

    public static void main(String[] args) {

        // create list
        Node head = new Node(10);

        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        traverse(head);

    }

}

/*
Node

Node1     Node2     Node3     Node4
+----+    +----+    +----+    +----+
|10  |--->|20  |--->|30  |--->|40  |--> null
+----+    +----+    +----+    +----+

Each node has
1) data → actual value
2) next → address/reference of next node

*************
Linked List

10 -> 20 -> 30 -> 40

Stored separately and connected using next.

Think:
Train 🚂

Engine -> Coach1 -> Coach2 -> Coach3

****************
head.next - reach only second node.
head.next.next - reach third node.
head.next.next.next - reach fourth node.

Same like:
House → Room → Cupboard → Drawer

*************
summary:
first all node 10 and position also passed that main function then call traverse first head value pass and get it and while loop and that next is null till this program works

Create linked list:
head
 ↓
10 -> 20 -> 30 -> 40 -> null
head stores first node only.

Call traverse
traverse(head);

while loop
10 print
move to 20

20 print
move to 30

30 print
move to 40

40 print
move to null

current → null the loop is stop.

10.next → 20
20.next → 30
30.next → 40
40.next → null

************************
 */