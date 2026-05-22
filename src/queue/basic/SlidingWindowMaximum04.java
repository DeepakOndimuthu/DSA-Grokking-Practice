package queue.basic;

import java.util.ArrayDeque;
import java.util.Deque;

/*
MEDIUM
No. 4

Problem: Sliding Window Maximum
Pattern: Queue / Deque
Status: ✅ Solved

LeetCode:

239 (Sliding Window Maximum)

Input:
arr = [1,3,-1,-3,5,3,6,7]
k = 3

Output:
[3,3,5,5,6,7]

Explanation:

Window size = 3

[1,3,-1] -> 3 (this is max value of that window)
[3,-1,-3] -> 3
[-1,-3,5] -> 5
[-3,5,3] -> 5
[5,3,6] -> 6
[3,6,7] -> 7

Use Deque
Store indexes
Keep largest at front
*/

public class SlidingWindowMaximum04 {

    public static void maxWindow(int[] arr, int k) {

        Deque<Integer> deque =
                new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {

            // remove outside window
            while (!deque.isEmpty()
                    && deque.peekFirst() <= i - k) {

                deque.pollFirst();
            }

            // remove smaller values
            while (!deque.isEmpty()
                    && arr[deque.peekLast()] < arr[i]) {

                deque.pollLast();
            }

            // add current index
            deque.offerLast(i);

            // print max
            if (i >= k - 1) {

                System.out.print(
                        arr[deque.peekFirst()]
                                + " "
                );
            }
        }
    }

    public static void main(String[] args) {

        int[] arr =
                {1,3,-1,-3,5,3,6,7};

        int k = 3;

        maxWindow(arr, k);

    }
}

/*
Deque =
Double Ended Queue
Meaning:
Insert/remove from BOTH sides.

Visual:
Front ← [ ] [ ] [ ] → Back

Operations:
Method	        Meaning
offerFirst()	insert front
offerLast()	insert back
pollFirst()	remove front
pollLast()	remove back
peekFirst()	see front
peekLast()	see back

***********
ArrayDeque - Implementation of Deque
Like,
Queue q = new LinkedList();
here,
Deque<Integer> deque = new ArrayDeque<>();
Create deque object.

*********************

Remove outside window
eque.peekFirst() <= i-k
deque.pollFirst();

Window size:
k=3

Current:
i=3

Window should be:
1 2 3

Index:
0 is outside

Deque:
[0,1]

Check:
0 <= 3-3
true.

Remove:
deque.pollFirst()
Now:
[1]
Old index removed.

*******************
Remove smaller values

Current deque:
Indexes:
[1]

Values:
[3]

New value:
5

Check:
3 < 5
TRUE.

Remove old smaller.
deque.pollLast()

Reason:
Why remove?

Because:
3 can never become max
5 already bigger.
So no need keep smaller.

********************

Store current index.
deque.offerLast(i);

Why Index Not Value?

Because we need:
know window range

Indexes help remove old elements.

*******************
Dry Run First 4 Iterations
Array:
[1,3,-1,-3]

**********
check this my understanding

for loop enter
i =0;
first while deque is empty so not enter
second while deque is empty so not enter
then add the index value deque[0]
then check the if condition 0 >= 2 so its false

*****************

now i=1
first while
deque.peekFirst() is value is 0 (that is we store so not arr value)
while(0 <= -2 ) (i-k => 1-3) so false
second while this is value comparison of array
arr[0] < arr[1] that is 1 < 3 true
so remove smaller 0
deque []
then add index
deque[1]

then if condition
1>=2 false so no print

********************

[1,3,-1,-3]

now i=2
first while
deque.peekFirst() is value is 1
while(1 <= -1 ) (i-k => 2-3) so false
second while this is value comparison of array
arr[1] < arr[2] that is 3 < -1 false
so go to save index
deque [1,2]

then if condition
2>=2 true
so print it value arr[deque.peekFirst()]
that is 1 so arr[1] is 3 so print it 3

*****************
i = 3
current deque is [1,2]
first while 1 < 0 (i-k => 3-3) false, no remove
second while arr[2] < arr[3]
-1 < -3 so false ,
now add the deque [1,2,3]

then if 3 >= 2 (3-1)
so print it arr[1] that is 3

**********************

 */
