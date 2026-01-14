package Arrays.easy;

/*
 EASY
 No. 3
 Problem: Reverse an Array
 Pattern: Two Pointers
 Status: ✅ Solved
 Input: nums = [1, 2, 3, 4, 5]
 Output: [5, 4, 3, 2, 1]
 Explanation:
 We use two pointers (left and right).
 Swap elements and move pointers inward.
 Source: LeetCode (Similar to #344 - Reverse String)

*/

public class ReverseArray {

    public static void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Swap until pointers meet
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        reverse(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Output: 5 4 3 2 1
    }
}

/*
Logic:
Swap first and last
Move pointers inside

Keywords:
left index
right index

One pointer at start
One pointer at end
Swap values
Move both pointers inside

Note:
In Java: Array length, no brackets. String length, brackets
Array → uses .length
String → uses .length()
int[] - arr.length
char[] - arr.length
String - str.length()
 */