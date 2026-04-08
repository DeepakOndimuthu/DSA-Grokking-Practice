package slidingWindow.easy;

/*
 EASY
 No. 1
 Problem: Maximum Sum Subarray of Size K
 Pattern: Sliding Window (Fixed Size)
 Status: ✅ Solved

 LeetCode similar:
 - 643 (Maximum Average Subarray I)

 Input:
 arr = [2,1,5,1,3,2]
 k = 3

 Output:
 9

 Explanation:
 Subarrays of size 3:
 [2,1,5] -> sum = 8
 [1,5,1] -> sum = 7
 [5,1,3] -> sum = 9  ✅ max
 [1,3,2] -> sum = 6

 So maximum sum = 9
*/

public class MaxSumSubarray01 {

    public static int maxSum(int[] arr, int k) {

        int windowSum = 0;
        int maxSum = 0;

        // first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum;

        // slide window
        for (int i = k; i < arr.length; i++) {

            windowSum += arr[i];       // add next element
            windowSum -= arr[i - k];   // remove first element of window

            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr = {2,1,5,1,3,2};
        int k = 3;

        int result = maxSum(arr, k);

        System.out.println("Maximum sum: " + result);
    }
}

/*

Input:
arr = [2,1,5,1,3,2]
k = 3

concept, We do:
Add new element ➕
Remove old element ➖

A) first window
arr[0], arr[1], arr[2]
= 2 + 1 + 5 = 8

so,
windowSum = 8
maxSum = 8
This loop gets first 3 values

B) Second part Sliding Window (Main Logic)
i = 3
arr[i] = 1
arr[i-k] = arr[0] = 2
so,
windowSum = 8 + 1 = 9
windowSum = 9 - 2 = 7
New window:
[1, 5, 1] = 7
maxSum = max(8, 7) = 8

i = 4
arr[i] = 3
arr[i-k] = arr[1] = 1
windowSum = 7 + 3 = 10
windowSum = 10 - 1 = 9
New window:
[5, 1, 3] = 9
maxSum = max(8, 9) = 9 ✅

i = 5
arr[i] = 2
arr[i-k] = arr[2] = 5
Step:
windowSum = 9 + 2 = 11
windowSum = 11 - 5 = 6
New window:
[1, 3, 2] = 6
maxSum = max(9, 6) = 9

******

Leetcode sum small diff that is avg find so return
(double) maxSum / k;

 */