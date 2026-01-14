package Arrays.easy;

/*
 EASY
 No. 6
 Problem: Find Sum of Array Elements
 Pattern: Simple Traversal
 Status: ✅ Solved

 Input: nums = [1, 2, 3, 4]
 Output: 10

 Logic:
 1. Initialize sum = 0
 2. Traverse array once
 3. Add each element to sum
 4. After loop, sum contains total
*/

public class FindArraySum {

    public static int findSum(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(findSum(nums));
    }
}
