package queue.basic;

import java.util.LinkedList;
import java.util.Queue;

/*
EASY
No. 3

Problem: Stack using Queue
Pattern: Queue + Simulation
Status: ✅ Solved

LeetCode similar:

225 (Implement Stack using Queues)

Input:
push(10)
push(20)
push(30)

pop()

Output:
30 removed

Stack:
20
10

Explanation:

Stack follows LIFO
(Last In First Out)

Queue follows FIFO

Use queue rotation
to simulate stack.
*/

public class StackUsingQueue03 {

    Queue<Integer> queue = new LinkedList<>();

    // push
    public void push(int data) {

        queue.offer(data);

        int size = queue.size();

        // rotate queue
        for (int i = 0; i < size - 1; i++) {

            queue.offer(queue.poll());
        }

        System.out.println(data + " inserted");
    }

    // pop
    public void pop() {

        if (queue.isEmpty()) {

            System.out.println("Stack is empty");
            return;
        }

        System.out.println(queue.poll() + " removed");
    }

    // display
    public void display() {

        if (queue.isEmpty()) {

            System.out.println("Stack is empty");
            return;
        }

        System.out.println("Stack:");

        for (int num : queue) {

            System.out.println(num);
        }
    }

    public static void main(String[] args) {

        StackUsingQueue03 stack =
                new StackUsingQueue03();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.pop();

        stack.display();
    }
}

/*
LC 232 - Queue using Stack
LC 225 - Stack using Queue

This sum
Use Queue but behave like Stack

*********
Stack
LIFO
Last In First Out

Example
push(10)
push(20)
push(30)

pop()

Output:
30
because last inserted comes first.

********************
Queue
FIFO
First In First Out

Example:

10
20
30

remove:
10

Wrong for stack.

REMEMBER THIS TOO
Queue has NO pop() method.
it has poll()

****************
This sum we used queue rotation
After insert,
move old elements to back.
So newest item always becomes front.

offer() - insert at rear
poll()	- remove from front
peek()	- see front

*********************
Dry code:
push(10)
queue.offer(10);

Queue:10

size:1

Loop:
for(i=0;i<0;i++)

No rotation.
Final:
10

***************
push(20)

Insert:
queue.offer(20);

Queue:
10 20

size:2

Now rotate.
Loop:
queue.offer(queue.poll());

queue.poll() -> 10 removed
Remaining:
20
queue.offer()
Queue:
20 10

*********
push(30)

Insert:
20 10 30

Rotate 2 times.

Rotation 1
10 30 20

Rotation 2
30 20 10

Now:
front
 ↓
30 20 10
Looks like stack.
Newest item front.

**************
pop()
queue.poll()

removes:
30

**********
Display time
Remaining shows:
20
10
************
that rotate part:
Case 1:
push(20)

Queue:
front
 ↓
10 20

size = 2
Loop:
for(int i=0;i<size-1;i++)

means:
i < 1
Run ONE time.

queue.offer(queue.poll());
queue.poll() - > Remove FRONT
10 20
↑
remove
Removed value:
10
Queue becomes:
20

Step 2

Now:
queue.offer(10)

Means:
Insert removed value at END.
Queue:
20 10

*********************
Case 2
push(30)

Current Queue:
20 10

Insert:
queue.offer(30)

Queue:
20 10 30

size:
3

Loop:
size-1
means:
2 times

Rotation 1

Current:
20 10 30
Execute:
queue.offer(queue.poll());
Remove:
20
Remaining:
10 30

offer(20)
Queue:
10 30 20

Rotation 2
Current:
10 30 20

Again:
queue.offer(queue.poll());

poll()
Remove:
10

Remaining:
30 20

offer(10)
Queue:
30 20 10
DONE.
***************
poll()
take first

offer()
put at end

************
 */
