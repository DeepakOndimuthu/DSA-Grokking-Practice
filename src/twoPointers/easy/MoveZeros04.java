package twoPointers.easy;

import java.util.Arrays;

/*
 EASY
 No. 4
 Problem: Move Zeros to End
 Pattern: Two Pointers
 Status: ✅ Solved

 LeetCode similar:
 - 283 (Move Zeroes)

 Input:
 arr = [0,1,0,3,12]

 Output:
 [1,3,12,0,0]

 Explanation:
 Move all zeros to the end of array
 while keeping order of non-zero elements.
*/

public class MoveZeros04 {

    public static void moveZeros(int[] arr) {

        int left = 0;

        for (int right = 0; right < arr.length; right++) {

            if (arr[right] != 0) {

                // swap
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {0,1,0,3,12};

        moveZeros(arr);

        System.out.println(Arrays.toString(arr));
    }
}

/*
concept
If arr[right] != 0
swap(arr[left], arr[right])
left++

left  → position for next non-zero
right → scanning pointer

Input- [0,1,0,3,12]

Step 1
right = 0
arr[0] = 0
Skip

Step 2
right = 1
arr[1] = 1
Swap with left
[1,0,0,3,12]
Move
left = 1

Step 3
right = 3
arr[3] = 3
Swap
[1,3,0,0,12]

Step 4
right = 4
arr[4] = 12
Swap
[1,3,12,0,0]

Result
[1,3,12,0,0]
 */