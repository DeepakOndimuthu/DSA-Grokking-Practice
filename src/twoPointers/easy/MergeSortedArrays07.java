package twoPointers.easy;

import java.util.Arrays;

/*
 EASY
 No. 7
 Problem: Merge Two Sorted Arrays
 Pattern: Two Pointers
 Status: ✅ Solved

 LeetCode similar:
 - 88 (Merge Sorted Array)

 Input:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6], n = 3

 Output:
 [1,2,2,3,5,6]

 Explanation:
 Merge nums2 into nums1 in sorted order.
 nums1 has extra space at the end.
*/

public class MergeSortedArrays07 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1; // last element of nums1
        int j = n - 1; // last element of nums2
        int k = m + n - 1; // last position of nums1

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // if nums2 still has elements
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        merge(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1));
    }
}

/*
This is two example why second while
Example 1:
Compare nums1[i] and nums2[j]
Put BIGGER one at nums1[k]
Move that pointer
Always do k--

Fill from back → avoid overwrite

nums1 = [1,2,3,0,0,0]
nums2 = [2,5,6]

Pointers:

i = 2 → (3)
j = 2 → (6)
k = 5 → last index

Step 1
compare 3 and 6
6 bigger → put at end
nums1[k] = nums2[j]
nums1[5] = 6
[1,2,3,0,0,6]
Move:
j=1
k=4

Step 2
compare 3 and 5
5 bigger → put at
nums1[4] = 5
[1,2,3,0,5,6]
Move
j=0
k=3


Step 3
compare 3 and 2
3 bigger → put at
nums1[3] = nums1[i] = 3
[1,2,3,3,5,6]
Move
i=1
k=2

Step 4
compare 2 and 2 condition //nums1[1]=2 and nums2[0]=2
Both equal
we take nums2 (else part)
nums1[2] = nums2[0] = 2
put 2 at
[1,2,2,3,5,6]
Move
j=-1
k=1

Loop stops
j < 0 → stop
**************************
Example2
second while when the edge case works
this example
nums1 = [4,5,6,0,0,0]   (m = 3)
nums2 = [1,2,3]         (n = 3)

We fill nums1 from back.
But sometimes:

👉 nums1 finishes first
👉 nums2 still has values

So we must copy remaining nums2.

Initial
i = 2 (6)
j = 2 (3)
k = 5

Step 1
6 > 3 → put 6
[4,5,6,0,0,6]
move:
i = 1
k = 4

Step 2
5 > 3 → put 5
[4,5,6,0,5,6]
move:
i = 0
k = 3

Step 3
4 > 3 → put 4
[4,5,6,4,5,6]
move:
i = -1   ❗ nums1 finished
k = 2

Important Moment
Now:
i = -1
j = 2
👉 nums1 finished
👉 nums2 still has [1,2,3]

❓ What is in nums1 now?
[4,5,6,4,5,6]
👉 WRONG result
We didn’t place 1,2,3 yet

Now second while runs
while (j >= 0)

Step 4
nums1[2] = nums2[2] = 3
[4,5,3,4,5,6]
move:
j = 1
k = 1

Step 5
nums1[1] = nums2[1] = 2
[4,2,3,4,5,6]
move:
j = 0
k = 0
Step 6
nums1[0] = nums2[0] = 1
[1,2,3,4,5,6]

 */