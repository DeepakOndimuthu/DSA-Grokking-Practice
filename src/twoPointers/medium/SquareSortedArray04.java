package twoPointers.medium;

import java.util.Arrays;

/*
 MEDIUM
 No. 4
 Problem: Square of Sorted Array
 Pattern: Two Pointers (Opposite Direction)
 Status: ✅ Solved

 LeetCode:
 - 977 (Squares of a Sorted Array)

 Input:
 nums = [-4,-1,0,3,10]

 Output:
 [0,1,9,16,100]

 Explanation:
 Square each number and return sorted array.
*/

public class SquareSortedArray04 {

    public static int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;
        int k = n - 1;

        while (left <= right) {

            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[k] = leftSquare;
                left++;
            } else {
                result[k] = rightSquare;
                right--;
            }

            k--;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-4,-1,0,3,10};

        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}

/*
concept:
Largest square always at ends
Fill result from back
 */