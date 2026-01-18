package Arrays.easy;

/*
 No. 10
 Problem: Find Index of an Element in an Array
 Pattern: Linear Search
 Status: ✅ Solved
 LeetCode similar : 35 & 704

 Input:
 nums = [10, 20, 30, 40, 50]
 target = 30

 Output:
 Index = 2

 Explanation:
 Traverse the array from start to end.
 Compare each element with the target.
 If a match is found, return the index.
 If the element is not present, return -1.
*/

public class FindIndexOfElement {

    public static int findIndex(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1; // element not found
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50};
        int target = 30;

        int index = findIndex(nums, target);
        System.out.println("Index = " + index);
    }
}
