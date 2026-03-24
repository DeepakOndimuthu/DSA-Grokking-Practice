package twoPointers.medium;

import java.util.Arrays;

/*
 MEDIUM
 No. 3
 Problem: Remove Element
 Pattern: Two Pointers (Overwrite)
 Status: ✅ Solved

 LeetCode:
 - 27 (Remove Element)

 Input:
 nums = [3,2,2,3]
 val = 3

 Output:
 k = 2
 nums = [2,2,_,_]

 Explanation:
 Remove all occurrences of val.
 Do it in-place.
 Return count of remaining elements.
*/

public class RemoveElement03 {

    public static int removeElement(int[] nums, int val) {

        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        int[] nums = {3,2,2,3};
        int val = 3;

        int k = removeElement(nums, val);

        System.out.println("k = " + k);
        System.out.println("Array = " + Arrays.toString(nums));
    }
}

/*
If value == val → skip
If value != val → keep it

We scan array
If element is NOT equal to val
→ move it to left side

right → checks every element
left  → position to place valid elements

Initial
nums = [3,2,2,3]
val = 3

Step 1
right = 0 → value = 3 so Skip ❌

Step 2
right = 1 → value = 2 Keep ✅
nums[left] = 2
Array: [2,2,2,3]
now increase left
so left = 1

Step 3
right = 2 → value = 2 Keep ✅
nums[left] = 2
Array:[2,2,2,3]
left = 2

Step 4
right = 3 → value = 3 Skip ❌
Final
k = left = 2
Valid part:
[2,2]

***********

Same Example Example
nums = [3,2,2,3]
val = 3
Step
3 → skip
2 → keep → move to left
2 → keep → move to left
3 → skip
Final
[2,2,_,_]
k = 2
 */