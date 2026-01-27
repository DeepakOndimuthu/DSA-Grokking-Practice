package Arrays.medium;

/*
 MEDIUM
 No. 20
 Problem: Maximum Subarray Sum (Kadane’s Algorithm)
 Pattern: Dynamic Programming / Running Sum
 Status: ✅ Solved
 LeetCode: 53

 Input:
 nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

 Output:
 6

 Logic:
 1. Start with first element as currentSum and maxSum
 2. For each element:
    - currentSum = max(current element, currentSum + current element)
 3. Update maxSum
 4. Return maxSum
*/

public class MaximumSubarraySum10 {

    public static int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
