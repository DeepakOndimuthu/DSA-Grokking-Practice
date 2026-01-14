package Arrays;

/*
 EASY
 No. 8
 Problem: Move All Zeros to End
 Pattern: Two Pointer (Write Index)
 LeetCode: 283 (Move Zeroes)
 Status: ✅ Solved

 Input: nums = [0, 1, 0, 3, 12]
 Output: [1, 3, 12, 0, 0]

 Explanation:
 Traverse the array and copy all non-zero elements to the front.
 Maintain a separate index to track where the next non-zero element should be placed.
 After placing all non-zero elements, fill the remaining positions with zeros.
*/

public class MoveZerosToEnd {

    public static void moveZeroes(int[] nums) {
        int index = 0;

        // step 1: move non-zero elements
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        // step 2: fill remaining with zero
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

