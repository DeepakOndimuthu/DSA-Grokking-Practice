package queue.basic;

import java.util.ArrayDeque;
import java.util.Deque;

/*
EASY
No. 5

Problem: Deque Basics
Pattern: Double Ended Queue
Status: ✅ Solved

LeetCode similar:

641 (Design Circular Deque)

Input:
addFirst(20)
addLast(30)
addFirst(10)

removeLast()

Output:
10 20

Explanation:

Deque means:

Insert → Front / Back
Remove → Front / Back

Unlike Queue
which only works FIFO.
*/

public class DequeBasics05 {

    public static void main(String[] args) {

        Deque<Integer> deque =
                new ArrayDeque<>();

        // insert
        deque.offerFirst(20);

        deque.offerLast(30);

        deque.offerFirst(10);

        // remove
        deque.pollLast();

        // display
        System.out.println("Deque:");

        for (int num : deque) {

            System.out.print(num + " ");
        }

    }

}
