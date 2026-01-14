package Arrays.easy;

/*
 EASY
 No. 2
 Problem: Find Minimum Element in an Array
 Pattern: Simple Traversal
 Status: ✅ Solved

 Input: nums = [4, 2, 9, 1, 5]
 Output: 1

 Explanation:
 Assume first element as minimum.
 Traverse array and update minimum when smaller element is found.
*/

public class FindMinimum {

    public static int findMin(int[] nums) {
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 9, 1, 5};
        System.out.println(findMin(nums));
    }
}
