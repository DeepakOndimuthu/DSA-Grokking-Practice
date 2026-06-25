package linkedList.lc;

/*
BASIC
No. 11

Problem:
Find the Duplicate Number

Pattern:
Slow Pointer + Fast Pointer (Cycle Detection)

Status:
✅ Solved


LeetCode:
287 (Find the Duplicate Number)

Input:
[1,3,4,2,2]

Output:
2


Explanation:

Treat array like a linked list

Use slow and fast pointers

Find meeting point

Move one pointer to beginning

Move both one step

The meeting value is the duplicate number
*/

public class FindDuplicateNumber287 {

    public static int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        // Find meeting point
        do {

            slow = nums[slow];

            fast = nums[nums[fast]];

        } while (slow != fast);

        // Find duplicate
        slow = nums[0];

        while (slow != fast) {

            slow = nums[slow];

            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 2, 2};

        System.out.println(findDuplicate(nums));
    }
}

/*

Pattern
This problem uses the same idea as LeetCode 142 (Linked List Cycle II).

Instead of following linked list nodes:
Node -> Node -> Node

we follow array indexes:
Index : 0  1  2  3  4
Value : 1  3  4  2  2

**************

int slow = nums[0];
int fast = nums[0];
so
slow = 1
fast = 1

*************
First loop
slow = nums[slow];
slow = nums[1] so value is 3
slow = 3

fast = nums[nums[fast]];
fast = nums[nums[1]] -> nums[3] so value is 2
fast = 2

State:
slow = 3
fast = 2

Second loop
slow = nums[3];
slow = 2

fast = nums[nums[fast]];
fast = nums[nums[2]] -> nums[4]
fast = 2

state:
slow = 2
fast = 2

First loop stops.

*******************
Second while loop
slow = nums[0];
slow = 1
fast = 2

so while enter
Round 1:
slow = nums[1];
slow = 3
fast = nums[2];
fast = 4

State:
slow = 3
fast = 4

Round 2:
slow = nums[3];
slow = 2
fast = nums[4];
fast = 2

Both become
2
Meet.

Return
return slow;
2

 */