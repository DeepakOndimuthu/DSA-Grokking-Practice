package Must50_Interview_Programs;

/*
 No. 05
 Problem: Reverse an Array
 Pattern: Two Pointers
 Status: ✅ Solved
 Input: nums = [1, 2, 3, 4, 5]
 Output: [5, 4, 3, 2, 1]
 Explanation: The array is reversed in place using two-pointer swapping.
 Source: LeetCode (Similar to #344 - Reverse String)
*/

public class ReverseArray {
    // Function to reverse the array in-place
    public static void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        reverse(nums);

        System.out.print("Reversed Array: [");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}