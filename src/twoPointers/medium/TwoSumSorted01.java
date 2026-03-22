package twoPointers.medium;

import java.util.Arrays;

/*
 MEDIUM
 No. 1
 Problem: Two Sum (Sorted)
 Pattern: Opposite Direction Two Pointers
 Status: ✅ Solved

 LeetCode similar:
 - 167 (Two Sum II - Input array is sorted)

 Input:
 arr = [1,2,3,4,6]
 target = 6

 Output:
 [2,4]

 Explanation:
 Use left and right pointers.
 Move based on sum.
*/

public class TwoSumSorted01 {

    public static int[] twoSum(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int sum = arr[left] + arr[right];

            if (sum == target) {
                return new int[]{arr[left], arr[right]};
            }
            else if (sum < target) {
                left++;   // need bigger sum
            }
            else {
                right--;  // need smaller sum
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,6};
        int target = 6;

        System.out.println(Arrays.toString(twoSum(arr, target)));
    }
}

/*
Concept
If sum < target → increase left
If sum > target → decrease right
 */