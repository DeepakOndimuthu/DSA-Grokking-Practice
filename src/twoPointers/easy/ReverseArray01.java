package twoPointers.easy;

/*
 EASY
 No. 1
 Problem: Reverse Array
 Pattern: Two Pointers
 Status: ✅ Solved

 LeetCode similar:
 - 344 (Reverse String)
 - Similar logic used for arrays

 Input:
 arr = [1, 2, 3, 4, 5]

 Output:
 [5, 4, 3, 2, 1]

 Explanation:
 Use two pointers.
 One pointer starts from beginning.
 One pointer starts from end.
 Swap elements and move pointers inward.
*/

import java.util.Arrays;

public class ReverseArray01 {

    public static void reverseArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            // swap
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // move pointers
            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        reverseArray(arr);

        System.out.println(Arrays.toString(arr));
    }
}

/*
Step 1
swap arr[0] and arr[4]
[5,2,3,4,1]
move pointers
left++
right--
left = 1
right = 3

Step 2
arr[1] and arr[3]
[5,4,3,2,1]
move pointers
left = 2
right = 2

left < right  → false
Loop stops.
 */