package twoPointers.easy;

import java.util.Arrays;

/*
 EASY
 No. 6
 Problem: Pair Sum in Sorted Array
 Pattern: Two Pointers
 Status: ✅ Solved

 LeetCode similar:
 - 167 (Two Sum II - Input array is sorted)

 Input:
 arr = [1,2,3,4,6]
 target = 6

 Output:
 [2,4] (or indices)

 Explanation:
 Since array is sorted,
 use two pointers:
 left at start, right at end.
*/

public class PairSumSorted06 {

    public static int[] pairSum(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int sum = arr[left] + arr[right];

            if (sum == target) {
                return new int[]{arr[left], arr[right]};
            }
            else if (sum < target) {
                left++; // need bigger sum
            }
            else {
                right--; // need smaller sum
            }
        }

        return new int[]{-1, -1}; // not found
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,6};
        int target = 6;

        int[] result = pairSum(arr, target);

        System.out.println(Arrays.toString(result));
    }
}

/*
If question says "index" → return index
If question says "element" → return value

and 167 sum mention it Given a 1-indexed  so we add plus one in return time

If sum is small → move left++
If sum is big   → move right--

Input
[1,2,3,4,6]
target = 6

Pointers
left = 0 (1) ->(bracket is values)
right = 4 (6)

Step 1
sum = 1 + 6 = 7
Too big ❌
right--

Step 2
left = 0 (1)
right = 3 (4)
sum = 1 + 4 = 5
Too small ❌
left++

Step 3
left = 1 (2)
right = 3 (4)
sum = 2 + 4 = 6 ✅ Found
Final Answer
[2,4]
 */