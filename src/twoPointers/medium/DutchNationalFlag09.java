package twoPointers.medium;

import java.util.Arrays;

/*
 MEDIUM
 No. 9 / 10
 Problem: Sort Colors / Dutch National Flag
 Pattern: 3-Pointer Partition
 Status: ✅ Solved

 Input:
 nums = [2,0,2,1,1,0]

 Output:
 [0,0,1,1,2,2]

 Explanation:
 Arrange 0s, 1s, and 2s in one pass.
*/

public class DutchNationalFlag09 {

    public static void sortColors(int[] nums) {

        int low = 0;                 // next position for 0
        int mid = 0;                 // current element
        int high = nums.length - 1;  // next position for 2

        while (mid <= high) {

            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if (nums[mid] == 1) {
                mid++; // already correct
            }
            else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {2,0,2,1,1,0};

        sortColors(nums);

        System.out.println(Arrays.toString(nums));
    }
}

/*
3 groups:
0 → left
1 → middle
2 → right

Pointer:
low  → next place for 0
mid  → current element
high → next place for 2

Rules:
0 → swap with low, move both
1 → just move mid
2 → swap with high, move high only

***************

Imagine:

[ 0 area | 1 area | unknown area | 2 area ]
   ↑        ↑           ↑            ↑
  low      mid        mid         high

Value	Action
0	move to left
1	ignore
2	move to right

my understanding: zero means left side arrange it and high values we arrange it right side and
middle values we not any change its automatically arrange it we arrange the left and right time

*****************

Input:
[2,0,2,1,1,0]

Initial:
low = 0
mid = 0
high = 5

nums[mid] = 2
Rule:
👉 2 should go to RIGHT

So:
swap(mid, high)
Array:
[0,0,2,1,1,2]

Update:
high-- → 4

Step2
nums[mid] = 0

Rule:
👉 0 should go LEFT

swap(low, mid)

Array:
[0,0,2,1,1,2]  (same because both 0)

Update:
low++ → 1
mid++ → 1

Step 3
nums[mid] = 0

Swap again:
swap(low, mid)

Array same.
Update:
low = 2
mid = 2


Step 4
nums[mid] = 2

Swap with high:
swap(2, 4)

Array:
[0,0,1,1,2,2]

Update:
high-- → 3

Step 5
nums[mid] = 1

Rule:
👉 already correct
mid++

Step 6
nums[mid] = 1
mid++

Final
Stop Condition
mid > high

*******************

Dutch National Flag problem

If 0 → swap with low
If 1 → just move
If 2 → swap with high

low → where 0 should go
mid → current element
high → where 2 should go

Step Example
[2,0,2,1,1,0]

Process → result:
[0,0,1,1,2,2]

memory trich
0 → left
1 → middle
2 → right

*******************
concept
Real Life Example

Imagine:
You are sorting balls:

Red (0)
White (1)
Blue (2)

Now:
Left basket → red
Right basket → blue
You are standing in middle and picking balls one by one

YOU = mid
Without you:
Who will pick balls and check color?
*/
