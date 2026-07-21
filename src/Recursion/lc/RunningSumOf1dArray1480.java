package Recursion.lc;

/*
LEETCODE
No. 8

Problem:
Running Sum of 1d Array

Pattern:
Recursion (Array)

Status:
✅ Solved

LeetCode:
1480 (Running Sum of 1d Array)

Input:
[1, 2, 3, 4]

Output:
[1, 3, 6, 10]

Explanation:

Find the running sum of the array.

Each current element becomes:

current element + previous element

Example:

[1, 2, 3, 4]

1

1 + 2 = 3

3 + 3 = 6

6 + 4 = 10

Result:

[1, 3, 6, 10]
*/

import java.util.Arrays;

public class RunningSumOf1dArray1480 {

    public static int[] runningSum(int[] nums) {

        calculate(nums, 1);

        return nums;
    }

    public static void calculate(int[] nums, int index) {

        // Base Case
        if (index == nums.length) {
            return;
        }

        // Add previous value to current value
        nums[index] = nums[index] + nums[index - 1];

        // Recursive Call
        calculate(nums, index + 1);
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = runningSum(nums);

        System.out.println(Arrays.toString(result));
    }
}
/*

DRY CODE
[1, 2, 3, 4]

We call:
calculate(nums, 1);
We start from index 1 because index 0 already has its correct running sum:
nums[0] = 1

******************
then
1) index = 1:
nums[1] = nums[1] + nums[0]
2 + 1 = 3
[1, 3, 3, 4]

2) index = 2:
nums[2] = nums[2] + nums[1]
3 + 3 = 6
[1, 3, 6, 4]

3) index = 3:
nums[3] = nums[3] + nums[2]
4 + 6 = 10
[1, 3, 6, 10]

4) index = 4
nums.length = 4
4 == 4 → true
return;

Final result:
[1, 3, 6, 10]

******************
Note:
This recursion has no waiting calculation like SumOfArray (basic folder sum 5)

For example
At index 1:
nums[1] = nums[1] + nums[0];
2 + 1 = 3

overwrites the array:

Before: [1, 2, 3, 4]
After:  [1, 3, 3, 4]

That new 3 is permanently stored in nums[1].

****************************

 */