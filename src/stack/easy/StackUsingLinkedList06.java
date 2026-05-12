package stack.easy;

/*
BASIC
No. 6

Problem: Stack using Linked List
Pattern: Stack Implementation

Status: ✅ Solved

Input:
push(10)
push(20)
push(30)

Output:
30
20

Explanation:
Stack follows LIFO
(Last In First Out)

Linked List allows
dynamic memory allocation.
*/

public class StackUsingLinkedList06 {

    // node class
    static class Node {

        int data;
        Node next;

        // Constructor
        Node(int data) {
            this.data = data;
        }

        /*
        int data; -> stores actual value. 10, 20 , 30

        Node next;
        stores next node address/reference.
        eg: 10 -> 20 -> 30
        next = address of 20 node

        Constructor:
        When node created:
        new Node(10)
        data becomes 10
         */
    }

    /*
    top stores first node reference.
    Initially top = null
     */
    Node top;
    // i write below explanation why not write SOP here
    //System.out.println(top + " top print");
    public void display() {
        if(top == null){
            System.out.println("top is null");
            return;
        }
        //actual value
        System.out.println(top.data + " top print");
        //lassName@memoryAddress
        //System.out.println(top + " top print");
    }

    // push
    public void push(int value) {

        /*
        create new node and save value
        next is null initially

        example:
        data = 10
        next = null
         */
        Node newNode = new Node(value); // Node - this is call that above Node class function & constructor then saved
        // that constructor we saved value only then that next is null then we saved here what value of reference

        newNode.next = top; // new node points to old top.

        top = newNode; // new node becomes top.

        System.out.println(value + " pushed");
    }

    // pop
    public int pop() {

        // stack empty
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int removed = top.data; // Current top removed

        top = top.next; // top moves to next node

        return removed;
    }

    // peek
    public int peek() {

        if (top == null) {
            System.out.println("Stack Empty");
            return -1;
        }

        return top.data; // Current top
    }

    // isEmpty
    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {

        StackUsingLinkedList06 stack =
                new StackUsingLinkedList06();

        //stack.display();
        stack.push(10);
        stack.push(20);
        //stack.display(); - practice print it what happen
        stack.push(30);

        System.out.println(stack.pop()); // 30

        System.out.println(stack.peek()); // 20
    }
}

/*

Linked List

Array: [10,20,30]
stored continuously in memory.

Linked List:
Each element separately stored.
each element stores:
1) data
2) address of next element

Node
one box in linked list

Each node contains:
1) data
2) next node address

***********************

1) push(10)
Create:
[10 | null]
Then:

top = newNode
Now:
top -> 10

2) push(20)
Create:
[20 | ?]

This line:
newNode.next = top;
means:
20 -> 10

Then:
top = newNode;
Now:
top -> 20 -> 10

*************
1) Array Stack
Fixed size
Faster memory access
eg:
new int[5]
Fixed size:
only 5 elements

2) Linked List Stack
Dynamic size
No overflow issue (mostly)
eg:
new Node(value)
creates new memory dynamically.
No fixed size.
Can keep growing until memory finishes.

*********************
who is faster
Array:
continuous memory
Fast access ✅

Linked List:
separate objects + references
Slightly slower.

********************

DRY RUN
Visual Node : [data | next]
Example:
[10 | null]

First push(10)
Node newNode = new Node(10);
Creates:
data = 10
next = null
Because:
👉 no next node yet.

Current situation
top = null
(empty stack)
newNode.next = top;
means:
10.next = null
because:
top = null

🔹 Then
top = newNode;
Now:
top -> 10

Final
top
 ↓
[10 | null]

************

Now push(20)
Current:
top -> 10
Create new node:
Node newNode = new Node(20);

New node:
[20 | null]

newNode.next = top;
Current top: 10 node

So:
20.next = 10 node
Now structure becomes:
20 -> 10

🔹 Then
top = newNode;
Now:
top -> 20 -> 10

🔹 Visual

Before:

top -> 10
After:
top -> 20 -> 10

***************
4. Push(30)

Same logic.
Create:
[30 | null]

This:
newNode.next = top;

means:
30.next = 20 node

Now:
30 -> 20 -> 10

Then:
top = newNode;

Final:
top -> 30 -> 20 -> 10

*****************
newNode.next means Like link/chain.
"new node points to old top"
How saved?

This line:
newNode.next = top;

stores:
address/reference of old top node
inside new node’s next.

Example
Think train compartments 🚂

30 -> 20 -> 10

Each compartment knows:
who is next
next works like connector.

***************
In Java
System.out.println(...)

Must be inside:
1) method
2) constructor
3) block

Not directly

**************
Why constructor not used for top directly?
top is NOT actual node data.
It only stores:
reference/address of first node

Real-world analogy
top = sign board
node = actual house

*******************

 */