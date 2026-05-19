package queue.lc;

import java.util.Stack;

/*
EASY
No. 232

Problem: Implement Queue using Stacks
Pattern: Queue / Stack
Status: ✅ Solved

Concept:
Queue follows FIFO
(First In First Out)

Stack follows LIFO
(Last In First Out)

This problem asks to
implement queue behavior
using stacks.

Idea:
Use two stacks.

input  -> insertion
output -> deletion

When output stack becomes empty,
move all elements from input
to output.

This reverses order
and gives FIFO behavior.

Methods:
push()  -> insert
pop()   -> remove
peek()  -> first element
empty() -> queue empty?
*/

class MyQueue {

    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {

        input = new Stack<>();
        output = new Stack<>();
    }

    // insert
    public void push(int x) {

        input.push(x);
    }

    // remove
    public int pop() {

        shiftStacks();

        return output.pop();
    }

    // first element
    public int peek() {

        shiftStacks();

        return output.peek();
    }

    // empty check
    public boolean empty() {

        return input.isEmpty() && output.isEmpty();
    }

    // move elements
    private void shiftStacks() {

        if (output.isEmpty()) {

            while (!input.isEmpty()) {

                output.push(input.pop());
            }
        }
    }

    public static void main(String[] args) {

        MyQueue q = new MyQueue();

        q.push(1);
        q.push(2);

        System.out.println(q.peek()); // 1

        System.out.println(q.pop()); // 1

        System.out.println(q.empty()); // false
    }
}

/*
How to create Queue behavior using Stack
Use stack to behave like queue

Queue:
FIFO
First In First Out

Stack:
LIFO
Last In First Out

*******************

example
push(1)
push(2)
push(3)

input stack:
TOP
 3
 2
 1

But queue needs:
1 should remove first

So we transfer all elements:
input -> output

Now order reverses:
output stack:

TOP
 1
 2
 3
Now pop works like queue.
****************************
Stack behavior:

LIFO
Last In First Out

Means:
last inserted comes out first

Queue behavior
FIFO
First In First Out

Means:
first inserted comes out first

Use stack but behave like queue

problem
stack always inserts at TOP.
TOP
 2
 1

Now Queue Expectation
Queue wants:
1 should come first

BUT stack top is:
2
Wrong for queue.

**************************
So What We Do?
We reverse stack order.

How?

By moving elements
from one stack to another stack

**************************
output.push(input.pop());
input.pop()
remove TOP element from input

Current input:
TOP
 2
 1

So:
input.pop()
returns:
2
and removes it.

Now input becomes:
TOP
 1
Now:
output.push(2)

output stack:
TOP
 2

Loop Continues

Again:
input.pop()

returns:
1

input becomes empty.
Now:
output.push(1)

output:

TOP
 1
 2

************************
MAGIC HAPPENED 🔥
(Final State input became empty note this)

Before transfer:
input:
TOP
 2
 1

After transfer:
output:
TOP
 1
 2
Order reversed.
************************

Dry Run

push(1)
input:
1

push(2)
input:2

TOP
 2
 1

*************
peek()
output empty.
So transfer happens.

Transfer
output.push(input.pop());

Step 1:
input pop -> 2
output push -> 2

output:
2

Step 2:
input pop -> 1
output push -> 1

output:
TOP
 1
 2

Now queue order achieved.

****************

peek()
output.peek()
returns:
1

**************
pop()
output.pop()

removes:
1

Queue now:
2

**********

 */
