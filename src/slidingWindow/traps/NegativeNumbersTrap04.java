package slidingWindow.traps;

/*
 No. 4
 Problem: Negative Numbers Issue
 Pattern: Sliding Window Limitation
 Status: ✅ Trap Covered

 Input:
 arr = [2,-1,2], k = 3

 Problem:
 sliding window fails

 Logic:
 1. Sliding window works only for positive numbers
 2. If negative numbers → use prefix sum + hashmap
*/

public class NegativeNumbersTrap04 {

    public static void main(String[] args) {

        int[] arr = {2,-1,2};
        int k = 3;

        System.out.println("Sliding window may fail here");
        System.out.println("Use Prefix Sum instead");
    }
}

/*

Sliding window works well ONLY when numbers are positive

Sliding window logic:
Expand → sum increases
Shrink → sum decreases

Easy example
Think:
You are filling water in a bucket
Positive numbers → always add water
Negative numbers → sometimes water is removed 😄

You lose control

so Correct approach
Use Prefix Sum + HashMap
Prefix sum works with any numbers (positive + negative)
so,
Positive only → Sliding Window ✅
Negative exists → Prefix Sum ✅

*****************

arr = [1,2,3]
add → sum increases
remove → sum decreases

Easy to control window ✅

******************

❗ Problem with negative numbers
arr = [2, -1, 2]
k = 3

sliding window thinking
[2] → sum = 2
[2,-1] → sum = 1  ❗ decreased
[2,-1,2] → sum = 3

👉 See problem:
Adding element (-1) decreased sum ❌

Because rule breaks:
Add element → sum may increase OR decrease ❌
Remove element → sum may increase OR decrease ❌

why negative numbers is fail
We cannot decide when to shrink or expand

 */