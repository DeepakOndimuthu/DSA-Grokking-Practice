package twoPointers.medium;

import java.util.Arrays;

/*
 MEDIUM
 No. 8
 Problem: Closest Pair Sum
 Pattern: Two Pointers (Opposite Direction)
 Status: ✅ Solved

 Input:
 arr = [1,3,4,7,10]
 target = 15

 Output:
 [4,10]  (sum = 14, closest to 15)

 Explanation:
 Find pair whose sum is closest to target.
*/

public class ClosestPairSum08 {

    public static int[] closestPair(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (left < right) {

            int sum = arr[left] + arr[right];
            int diff = Math.abs(target - sum);

            if (diff < minDiff) {
                minDiff = diff;
                result[0] = arr[left];
                result[1] = arr[right];
            }

            if (sum < target) {
                left++;   // need bigger sum
            } else {
                right--;  // need smaller sum
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1,3,4,7,10};
        int target = 15;

        System.out.println(Arrays.toString(closestPair(arr, target)));
    }
}

/*
We use Math.abs() to compare closeness correctly
(We need distance, not direction)
so why we not use the target - sum and use the Math.abs()
Example:
Home = 15 km
You are at 14 km → distance = 1
You are at 17 km → distance = 2

Case 1
sum = 14
target - sum = 1

Case 2
sum = 17
target - sum = -2

We get:
1 and -2
-2 < 1 ❌ (wrong logic)

correct way
Math.abs(target - sum)

We get:
|15 - 14| = 1
|15 - 17| = 2

*****************

Step Example
[1,3,4,7,10], target = 15

step1
left = 1
right = 10
sum = 11
diff = 4
best =[1,10]

step1
left = 3
right = 10
sum = 13
diff = 2
best = [3,10]

step1
left = 4
right = 10
sum = 14
diff = 1
best = [4,10]

step1
left = 7
right = 10
sum = 17
diff = 2
best = skip
 */