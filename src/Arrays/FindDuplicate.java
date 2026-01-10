package Arrays;

/*
 No. 5
 Problem: Find Duplicate Element in an Array
 LeetCode: 217 (Contains Duplicate)
 Pattern: HashSet
 Status: ✅ Solved

 Input: nums = [1, 2, 3, 1]
 Output: true

 Explanation:
 If an element appears more than once, return true.
*/

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {

    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true; // duplicate found
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(hasDuplicate(nums));
    }
}

