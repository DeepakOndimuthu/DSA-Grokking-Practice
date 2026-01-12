package Arrays;

/*
 No. 10
 Problem: Find Second Largest Element in an Array
 Pattern: Two Variables
 Status: ✅ Solved
 LeetCode similar : 414 & 215
 Input: nums = [10, 5, 20, 8]
 Output: 10

 Logic:
 1. Keep largest and secondLargest
 2. Traverse array
 3. If current > largest:
      - secondLargest = largest
      - largest = current
 4. Else if current < largest and current > secondLargest:
      - update secondLargest
*/

public class SecondLargestElement {

    public static int findSecondLargest(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num < largest && num > secondLargest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 20, 8};
        System.out.println(findSecondLargest(nums));
    }
}
