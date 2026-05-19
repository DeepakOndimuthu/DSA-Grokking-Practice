package queue.basic;

/*
EASY
No. 1

Problem: Queue Implementation using Array
Pattern: Queue Data Structure
Status: ✅ Solved

LeetCode similar:

622 (Design Circular Queue)
232 (Implement Queue using Stacks)

Input:
enqueue(10)
enqueue(20)
enqueue(30)

dequeue()

Output:
10 removed

Queue:
20 30

Explanation:
Queue follows FIFO
(First In First Out)

First inserted element
will be removed first.
*/

public class QueueImplementation01 {

    int[] queue = new int[5];

    int front = 0;
    int rear = -1; // last/back element position, no element inserted yet so why minus one
    int size = 0;

    // enqueue
    public void enqueue(int data) {

        if (size == queue.length) {
            System.out.println("Queue is full");
            return;
        }

        rear++; // Move rear to next position.
        queue[rear] = data;
        size++;

        System.out.println(data + " inserted");
    }

    // dequeue
    public void dequeue() {

        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println(queue[front] + " removed");

        front++;
        size--;
    }

    // display
    public void display() {

        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Queue:");

        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
    }

    public static void main(String[] args) {

        QueueImplementation01 q = new QueueImplementation01();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.dequeue();

        q.display();
    }
}

/*
Queue - FIFO
First In First Out

People standing in ticket counter:
- First person enters queue
- First person gets ticket and leaves

Real Life Examples
1) Ticket counter
2) Printer queue
3) Food order queue
4) Call center waiting
5) CPU scheduling
6) Message queue

enqueue  -> rear++
dequeue  -> front++
display  -> front to rear

*********************
Queue Operations
enqueue() - insert/add
dequeue() - remove
front	  - first element
rear	  - last/back element

*************
DRY RUN

front = 0
rear = -1
size = 0

Array:
[ _, _, _, _, _ ]

enqueue(10)
rear++
rear = 0

queue[0] = 10

size++
size = 1

Array:
[10, _, _, _, _]

******************

enqueue(20)
rear = 1

queue[1] = 20

size = 2

Array:
[10, 20, _, _, _]

*************

enqueue(30)
rear = 2

queue[2] = 30

size = 3

Array:
[10, 20, 30, _, _]

******************
dequeue()

Remove:

queue[front]
queue[0]
10 removed

Then:

front++
front = 1

size--
size = 2

Now queue logically:
20 30

***************
display()
Loop:
front = 1
rear = 2
these are only Queue valid elements
queue[1] = 20
queue[2] = 30

****************
Extra logic problems known
this program has one problem
we use this program Linear Queue using Array
moves only forward and rear also moves only forward never come back

example
int[] queue = new int[5];
indexes : 0 1 2 3 4

insert
enqueue(10)
enqueue(20)
enqueue(30)
enqueue(40)
enqueue(50)

Now:
Index : 0   1   2   3   4
Value :10  20  30  40  50

front = 0
rear = 4
size = 5

Step 2
Now remove 3 elements.

dequeue()
dequeue()
dequeue()

Removed:

10 20 30

Now:
front = 3
rear = 4
size = 2

Logical queue:
40 50

IMPORTANT
Array actually looks like:

Index : 0   1   2   3   4
Value :10  20  30  40  50
But queue ignores first 3 positions because:
front = 3

Step 3
Now insert new element:
enqueue(60)

What happens?
Code:
rear++;

Now:
rear = 5

BUT ARRAY SIZE ONLY 5.
Valid indexes:
0 to 4 only

So queue becomes invalid.

But Wait 😲
Indexes:
0 1 2

are actually free now logically.
Because old elements removed.
But this queue cannot reuse them.
That is the BIG PROBLEM.

So this queue wastes space

Even though empty places exist,
rear cannot go back.

Solution → Circular Queue
Circular Queue does this:
rear goes back to 0

Like circle 🔄
Example:

0 → 1 → 2 → 3 → 4
↑               ↓
└───────────────┘
So freed spaces reused again.

********************
Queue Types
Queue Type     - Problem
Linear Queue   - wastes space
Circular Queue - fixes problem
Queue using Linked List	dynamic size

*********************
 */