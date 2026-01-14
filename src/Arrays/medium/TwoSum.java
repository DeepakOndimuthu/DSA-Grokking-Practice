package Arrays.medium;

/*
 MEDIUM
 No. 3
 Problem: Two Sum
 Pattern: Brute Force (Nested Loop)
 LeetCode: 1 (Two Sum)
 Status: ✅ Solved

 Input: nums = [2, 7, 11, 15], target = 9
 Output: [0, 1]

 Explanation:
 Use two loops to check all possible pairs.
 The outer loop selects the first element.
 The inner loop selects the next element.
 If the sum of the two elements equals the target, return their indices.
 If no pair matches, return [-1, -1].
*/

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
