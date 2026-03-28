package twoPointers.medium;

import java.util.Arrays;

/*
 MEDIUM
 No. 6
 Problem: Partition Array
 Pattern: Two Pointers (Partition / Rearrangement)
 Status: ✅ Solved

 LeetCode:
 - 75 (Dutch National Flag)

 Input:
 arr = [3,1,2,4,6,5]
 pivot = 3

 Output:
 [1,2,3,4,6,5] (or any valid partition)

 Explanation:
 Move all elements < pivot to left
 Move all elements >= pivot to right
*/

public class PartitionArray06 {

    public static void partition(int[] arr, int pivot) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            while (left <= right && arr[left] < pivot) {
                left++;
            }

            while (left <= right && arr[right] >= pivot) {
                right--;
            }

            if (left < right) {
                // swap
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {3,1,2,4,6,5};
        int pivot = 3;

        partition(arr, pivot);

        System.out.println(Arrays.toString(arr));
    }
}

/*
Partition (Divide array into two parts)
left → elements < pivot
right → elements >= pivot

Input:
[3,1,2,4,6,5], pivot = 3

Output:
[2,1,3,4,6,5]
✔️ Condition satisfied
Order is NOT important

Left side → [2,1]  (< 3)
Right side → [3,4,6,5] (>= 3)

Find wrong elements and swap them
Order is NOT important

Left finds big
Right finds small
Swap

************
Examples
1️⃣ QuickSort
Pick pivot
Partition array
Then sort left & right
This problem = QuickSort core step

2️⃣ Data Filtering
Example:
Move all negative numbers to left
Move positive to right

3️⃣ Dutch National Flag
Sort 0,1,2 using partition idea

Another example
Students line:
< 50 marks → left
>= 50 marks → right
we don’t care about order
Only grouping matters
 */