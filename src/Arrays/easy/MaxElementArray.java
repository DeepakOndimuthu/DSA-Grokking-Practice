package Arrays.easy;

/*
 EASY
 No. 1
 Problem: Find Maximum Element in an Array
 Pattern: Array Traversal
 Status: ✅ Solved
 Input: nums = [3, 7, 2, 9, 1]
 Output: 9
 Explanation:
 We assume the first element as maximum.
 Then we compare each element with max.
 If current element is greater, we update max.
 Source: Basic Array Logic (Interview Fundamental)
*/

public class MaxElementArray {

    public static int findMax(int[] nums) {
        // Step 1: assume first element is max
        int max = nums[0];

        // Step 2: traverse array
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 7, 2, 9, 1};
        System.out.println(findMax(nums)); // Output: 9
    }
}

