package Arrays.medium;

/*
 MEDIUM
 No. 4
 Problem: Majority Element
 Pattern: Boyer–Moore Voting Algorithm
 LeetCode: 169 (Majority Element)
 Status: ✅ Solved

 Input:
 nums = [2, 2, 1, 1, 1, 2, 2]

 Output:
 2

 Explanation:
 The majority element is the element that appears more than n/2 times.
 Using Boyer–Moore algorithm:
 - Keep a count and a candidate.
 - Increase count if same element.
 - Decrease count if different element.
 - Final candidate is the majority element.
*/

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }
}
