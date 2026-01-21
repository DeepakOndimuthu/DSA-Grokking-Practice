package Arrays.medium;

/*
 MEDIUM
 No. 5
 Problem: Rotate Array (Left / Right)
 Pattern: Reverse Array
 LeetCode: 189 (Rotate Array)
 Status: ✅ Solved

 Input:
 nums = [1, 2, 3, 4, 5, 6, 7]
 k = 3

 Output (Right Rotate):
 [5, 6, 7, 1, 2, 3, 4]

 Explanation:
 Rotate the array to the right by k steps.
 Steps:
 1. Reverse entire array
 2. Reverse first k elements
 3. Reverse remaining elements
*/

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(nums, k);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}