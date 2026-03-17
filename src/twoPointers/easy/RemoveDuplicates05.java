package twoPointers.easy;

import java.util.Arrays;

/*
 EASY
 No. 5
 Problem: Remove Duplicates from Sorted Array
 Pattern: Two Pointers
 Status: ✅ Solved

 LeetCode similar:
 - 26 (Remove Duplicates from Sorted Array)

 Input:
 arr = [1,1,2,2,3]

 Output:
 [1,2,3,_,_]
 return = 3

 Explanation:
 Keep only unique elements.
 Modify array in-place.
 Return count of unique elements.
*/

public class RemoveDuplicates05 {

    public static int removeDuplicates(int[] arr) {

        if (arr.length == 0) return 0;

        int left = 0;

        for (int right = 1; right < arr.length; right++) {

            if (arr[right] != arr[left]) {
                left++;
                arr[left] = arr[right];
            }
        }

        return left + 1; // count of unique elements
    }

    public static void main(String[] args) {

        int[] arr = {1,1,2,2,3};

        int k = removeDuplicates(arr);

        System.out.println("Unique count = " + k);
        System.out.println("Array = " + Arrays.toString(arr));
    }
}

/*
[1,1,2,2,3]

concept
We do NOT remove elements
We overwrite duplicates

Step 1
left = 0 (value = 1)
right = 1 (value = 1)
Same → skip

Step 2
right = 2 (value = 2)
Different ✅
left++
arr[left] = arr[right]

Array becomes
[1,2,2,2,3]

Step 3
right = 3 (value = 2)
Same → skip

Step 4
right = 4 (value = 3)
Different ✅

left++
arr[left] = arr[right]

Array becomes
[1,2,3,2,3]

Final
Unique count = left + 1 = 3
Valid part:
[1,2,3]
Rest ignore:
[2,3]
 */