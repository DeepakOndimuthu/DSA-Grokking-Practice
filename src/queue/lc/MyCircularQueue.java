package queue.lc;

/*
MEDIUM
No. 622

Problem: Design Circular Queue
Pattern: Queue / Circular Queue
Status: ✅ Solved

Concept:
Circular Queue follows FIFO
(First In First Out)

Unlike normal queue,
circular queue reuses
empty spaces using
circular movement.

Key Idea:
When rear or front
reaches end of array,
it goes back to start.

Clock Example:
11 -> 12 -> 1

Important Formula:
(index + 1) % size

Used For:
- CPU Scheduling
- Buffers
- Streaming
- Printer Queue
- Keyboard Input

Methods:
enQueue()  -> insert
deQueue()  -> remove
Front()    -> first element
Rear()     -> last element
isEmpty()  -> queue empty?
isFull()   -> queue full?

Important:
rear points to
NEXT EMPTY SPACE
not last element.
*/

public class MyCircularQueue {

    int[] queue;

    int front;
    int rear;
    int size;

    // constructor
    public MyCircularQueue(int k) {

        queue = new int[k];

        front = 0;
        rear = 0;
        size = 0;
    }

    // insert
    public boolean enQueue(int value) {

        // full check
        if (isFull()) {
            return false;
        }

        queue[rear] = value;

        rear = (rear + 1) % queue.length;

        size++;

        return true;
    }

    // remove
    public boolean deQueue() {

        // empty check
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % queue.length;

        size--;

        return true;
    }

    // first element
    public int Front() {

        if (isEmpty()) {
            return -1;
        }

        return queue[front];
    }

    // last element
    public int Rear() {

        if (isEmpty()) {
            return -1;
        }

        int index = (rear - 1 + queue.length) % queue.length;

        return queue[index];
    }

    // empty check
    public boolean isEmpty() {

        return size == 0;
    }

    // full check
    public boolean isFull() {

        return size == queue.length;
    }

    public static void main(String[] args) {

        MyCircularQueue q = new MyCircularQueue(3);

        System.out.println(q.enQueue(1)); // true
        System.out.println(q.enQueue(2)); // true
        System.out.println(q.enQueue(3)); // true
        System.out.println(q.enQueue(4)); // false

        System.out.println(q.Rear()); // 3

        System.out.println(q.isFull()); // true

        System.out.println(q.deQueue()); // true

        System.out.println(q.enQueue(4)); // true

        System.out.println(q.Rear()); // 4
    }
}

/*
rear = (rear + 1) % queue.length;
Example:
Queue size = 3
indexes:
0 1 2

If:
rear = 2
Then:
(2 + 1) % 3
= 3 % 3
= 0
rear goes back to start.
That makes circle.

*****************
int index = (rear - 1 + queue.length) % queue.length;

rear always points to NEXT EMPTY SPACE.
Not current last element.

Example
After insert:
1 2 3

rear becomes:
rear = 0

because circular.
Actual last element is index 2.

So:
(rear - 1 + length) % length
finds previous position safely.
below example

*****************************

Example
Queue:
[1, 2, 3]

rear becomes:
0

because wrapped.
But last element actually at:

index 2
So we do:

rear - 1
But problem:
If rear = 0
then:
0 - 1 = -1

invalid index.
So we safely make it circular:

(rear - 1 + length) % length
Example:

(0 - 1 + 3) % 3
= 2 % 3
= 2

Correct last index.

*******************
Formula
imagine clock
Memorize meanings:

Formula	        Meaning
rear  + 1	move next
front + 1	move next
rear  - 1	find previous

*********************

(index + 1) % size - move next in circle
(index - 1 + size) % size - move previous in circle

*********************
question understanding:

Match Them Together
Method	Argument
MyCircularQueue	- 3
enQueue	- 1
enQueue	- 2
enQueue	- 3
enQueue	 - 4
Rear	- no argument
isFull	- no argument
deQueue	- no argument
enQueue	- 4
Rear	- no argument

["MyCircularQueue", "enQueue", "enQueue"]
[[3], [1], [2]]

[[3], [1], [2], [3], [4], [], [], [], [4], []]

Final Output
[null, true, true, true, false, 3, true, true, true, 4]
 */