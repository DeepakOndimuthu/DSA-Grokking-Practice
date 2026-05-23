package queue.lc;

/*
MEDIUM
No. 641

Problem: Design Circular Deque
Pattern: Queue / Deque
Status: ✅ Solved

Concept:

Deque =
Double Ended Queue

Insert/Delete
allowed from both sides.

Circular movement
uses modulo.

Front:
insert/remove

Rear:
insert/remove
*/

class MyCircularDeque641 {

    int[] deque;

    int front;

    int rear;

    int size;

    public MyCircularDeque641(int k) {

        deque = new int[k];

        front = 0;

        rear = 0;

        size = 0;
    }

    // insert front
    public boolean insertFront(int value) {

        if (isFull()) {
            return false;
        }

        front =
                (front - 1
                        + deque.length)
                        % deque.length;

        deque[front] =
                value;

        size++;

        return true;
    }

    // insert rear
    public boolean insertLast(int value) {

        if (isFull()) {
            return false;
        }

        deque[rear] =
                value;

        rear =
                (rear + 1)
                        % deque.length;

        size++;

        return true;
    }

    // remove front
    public boolean deleteFront() {

        if (isEmpty()) {
            return false;
        }

        front =
                (front + 1)
                        % deque.length;

        size--;

        return true;
    }

    // remove rear
    public boolean deleteLast() {

        if (isEmpty()) {
            return false;
        }

        rear =
                (rear - 1
                        + deque.length)
                        % deque.length;

        size--;

        return true;
    }

    public int getFront() {

        if (isEmpty()) {
            return -1;
        }

        return deque[front];
    }

    public int getRear() {

        if (isEmpty()) {
            return -1;
        }

        int index =
                (rear - 1
                        + deque.length)
                        % deque.length;

        return deque[index];
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public boolean isFull() {

        return size ==
                deque.length;
    }

    public static void main(String[] args) {

        MyCircularDeque641 q =
                new MyCircularDeque641(3);

        System.out.println(
                q.insertLast(1));

        System.out.println(
                q.insertLast(2));

        System.out.println(
                q.insertFront(3));

        System.out.println(
                q.insertFront(4));

        System.out.println(
                q.getRear());

        System.out.println(
                q.isFull());

        System.out.println(
                q.deleteLast());

        System.out.println(
                q.insertFront(4));

        System.out.println(
                q.getFront());
    }
}

/*
Circular Queue
front ← remove
rear  ← insert

Deque = Double Ended Queue
Front ← insert/remove → Rear
Both sides work.

Normal Queue:
10 20 30

insert →
remove ←
Only one direction.

Deque:
Front ← [10 20 30] → Rear

Allowed:
insertFront()
insertLast()

deleteFront()
deleteLast()

Circular Deque

Same as circular queue.

When index reaches end:

0 1 2 3
↑     ↓
└─────┘

(index + 1) % length
(index - 1 + length) % length
Clock thinking again

**************************
Dry Run

Index: 0 1 2
Array: _ _ _

front - index of first element (where front element sits)
rear  - index of next insertion at rear (empty space after last element)

Important:

rear does NOT point to last element, it points to next free slot at rear.
front points to actual first element.

*******************************

Program Flow
Create: new MyCircularDeque(3)
Empty:
[ _ _ _ ]

insertLast(1)
[1 _ _]

insertLast(2)
[1 2 _]

insertFront(3)
Move front backward.
[1 2 3]
Deque full.

insertFront(4)
Fail.
Return:
false

getRear()
Return:
2

deleteLast()
Remove:
2

insertFront(4)
Front inserts.
Result:
4 3 1

getFront()
Return:
4

***********
Memory
insertFront
front--

insertLast
rear++

deleteFront
front++

deleteLast
rear--

Then:

% length

****************

Formula

insertLast(1)
Check if full → no.
Insert at rear (which is 0 initially):
deque[rear] = 1

Move rear forward:
rear = (rear + 1) % length
rear = (0 + 1) % 3 = 1

Array:
[1 _ _]
front = 0
rear = 1

✅ Notice: last element (1) is at index 0, rear points to next empty index (1).
This is why it looks like “1 at front”, but conceptually rear is at index 1.

***********
InsertLast(2)
Insert at rear = 1:
deque[1] = 2

Move rear:
rear = (1 + 1) % 3 = 2

Array:

[1 2 _]
front = 0
rear = 2

First element = front = 0 → 1
Last element = rear-1 = (2-1 + 3)%3 = 1 → 2 ✅
So getRear() = 2 is correct.

*****************

insertFront(3)
Move front backward:
front = (front - 1 + length) % length
front = (0 - 1 + 3) % 3 = 2
Insert value:
deque[2] = 3

Array:
[1 2 3]
front = 2
rear = 2
size = 3 (full)

front = index 2 → 3
rear = 2 (next free spot)

Important: rear does NOT point to last element.
Last element = rear-1 = (2-1+3)%3 = 1 → value 2
That’s why getRear() still returns 2 ✅

Now deque is full. insertFront(4) fails.

*************************

Formulas Explained Logically (No Memorization)
Operation	    Formula	                                    Logic (clock way)
insertFront	    front = (front - 1 + length) % length	    Move front pointer backward to insert new front
insertLast	    rear = (rear + 1) % length	                Move rear pointer forward to next free spot
deleteFront	    front = (front + 1) % length	            Front element removed, front moves forward
deleteLast	    rear = (rear - 1 + length) % length	        Last element removed, rear moves backward
getFront	    deque[front]	                            Just value at front pointer
getRear	        deque[(rear - 1 + length) % length]	        Last element is one behind rear

***********************

Front = first element
Rear = next empty spot at end
Moving forward = +1 % length
Moving backward = -1 + length % length

Front insert → move backward
Rear insert → move forward

Get rear → always look one behind rear pointer

***********************
Moving forward = +1 % length
Moving backward = -1 + length % length

insertFront - Moving backward
insertLast  - Moving forward

deleteFront - Moving forward ( after delete move to next)
deleteLast  - Moving backward (after delete one step minus)

*****************

| Operation   | Meaning                  | Move |
| ----------- | ------------------------ | ---- |
| insertFront | create new first element | ←    |
| deleteFront | remove first element     | →    |


insertFront ←
Current:
Array:
[_][1][2]
front = 1

Now:
insertFront(9)
Question:
Where should 9 come?
Answer:
before 1
After:
[9][1][2]
 ↑
front


deleteFront() →
Before:

[9][1][2]
 ↑
front
Delete:
Remove:
9
Now:
[_][1][2]
    ↑
 front
Front moved RIGHT.

same this reverse is insertLast(→) and deleteLast(←)

insertLast (→)

example
Array:
[1][2][_]

front = 0
rear = 2

1 = first element
rear points
next empty place

insertLast(9)
Where should 9 come?
Answer:
after 2

************
both example

insertFront:

[_][1][2]
insert before 1
[9][1][2]
front ←

insertLast:
[1][2][_]
insert after 2
[1][2][9]
rear →

*******************************

ok now only formula
Moving forward = +1 % length
Moving backward = -1 + length % length


1) insertLast() After insert:
Need next empty place. So move forward →
this formula = +1 % length


2) insertFront() Insert before current front.
Need empty place before front. so Move backward ←
this formula = -1 + length % length

**********
3. deleteFront() - front element removed

Current:
[3][1][2]
 ↑
front

Now:

[ ][1][2]

Who becomes front?
1
1 is RIGHT side.
So move forward → this formula +1 % length
front = (front + 1) % length

4. deleteLast()
Current:
3 → 1 → 2
Remove:
2
Now:
3 → 1

Who becomes rear?
Rear points:

next empty
Current rear:
after 2
Need move backward. this formula -1 + length % length
So:
rear =(rear - 1 + length) % length

Visual:
Before:

[3][1][2]
       R
Delete:
[3][1][_]
     R

rear moved left.

***************

why that insertFront and insertLast
value save is diff
deque[front] = value;
deque[rear] = value;

insertFront: this need Where first, so find then save
move then save
front--
save

insertLast: Where should new value go, exactly rear position
save then move
save
rear++

****************

 */
