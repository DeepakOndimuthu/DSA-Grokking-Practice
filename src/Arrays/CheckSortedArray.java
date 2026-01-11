package Arrays;

/*
 No. 8
 Problem: Check if Array is Sorted
 Pattern: Neighbor Comparison
  LeetCode: 1752 (Check if Array Is Sorted and Rotated - extended interview version)
 Status: ✅ Solved

 Input: nums = [1, 2, 3, 4, 5]
 Output: true

 Explanation:
 Compare current element with next element.
 If any element is greater than next, array is not sorted.
*/

public class CheckSortedArray {

    public static boolean isSorted(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(isSorted(nums));
    }
}
