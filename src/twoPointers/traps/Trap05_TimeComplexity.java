package twoPointers.traps;

/*
 TRAP 5
 Problem: Time Complexity
*/

public class Trap05_TimeComplexity {

    public static void example(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            left++;
            right--;
        }
    }
}

/*

Many think → O(n/2)
Time = O(n)
Ignore constants - means that n steps

Time complexity = how work grows when input grows
We don’t ask: ❌
How many seconds?
We ask: ✅
If input becomes big → how many steps?

n = 6 → loop runs 3 times (n/2)
n = 1000 → loop runs 500 times

[1,2,3,4,5,6]
n = 6

Each step:
left → +1
right → -1

Loop runs:
3 times (n/2)

So why NOT O(n/2)?
Because in Big-O:
We ignore constants

Rule of Time Complexity
O(n/2) → O(n)
O(2n)  → O(n)
O(100n) → O(n)

We only care about:
how it grows with input size

Why ignore constants?
n = 1000

n/2 = 500
n   = 1000 same like steps but run only 500
this 1000 is growth pattern

Both are:
linear growth

Example
You walk full road → n
You walk half road → n/2


ok my understanding
Loop runs n/2 times
But complexity = O(n)

 */