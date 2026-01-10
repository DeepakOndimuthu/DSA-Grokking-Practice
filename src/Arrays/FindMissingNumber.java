package Arrays;

/*
 No. 6
 Problem: Find Missing Number (1 to N)
 LeetCode: 268 (Missing Number)
 Pattern: Sum Formula
 Status: ✅ Solved

 Input: nums = [1, 2, 4, 5]
 Output: 3

 Explanation:
 Expected sum - actual sum = missing number
*/

public class FindMissingNumber {

    public static int missingNumber(int[] nums) {
        int n = nums.length + 1;

        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5};
        System.out.println(missingNumber(nums));
    }
}
