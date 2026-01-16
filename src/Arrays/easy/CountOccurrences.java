package Arrays.easy;

/*
 No. 9
 Problem: Count Occurrences of a Given Number
 Pattern: Array Traversal + Counting
 Status: ✅ Solved
 LeetCode similar : 2089 & 34

 Input:
 nums = [1, 2, 2, 3, 2, 4]
 target = 2

 Output:
 Count = 3

 Explanation:
 Traverse the array from start to end.
 Compare each element with the target number.
 If it matches, increase the count by 1.
*/


public class CountOccurrences {

    public static int countOccurrences(int[] nums, int target) {
        int count = 0;

        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 2, 4};
        int target = 2;

        System.out.println("Count = " + countOccurrences(nums, target));
    }
}
