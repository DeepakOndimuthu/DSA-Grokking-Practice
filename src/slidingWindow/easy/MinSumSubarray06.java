package slidingWindow.easy;

/*
 EASY
 No. 6
 Problem: Minimum Sum Subarray of Size K
 Pattern: Sliding Window (Fixed Size)
 Status: ✅ Solved

 LeetCode similar:
 - 643 (Maximum Average Subarray I) (concept)

 Input:
 arr = [2,1,5,1,3,2]
 k = 3

 Output:
 6

 Explanation:
 Subarrays of size 3:
 [2,1,5] -> sum = 8
 [1,5,1] -> sum = 7
 [5,1,3] -> sum = 9
 [1,3,2] -> sum = 6  ✅ min

 So minimum sum = 6
*/

public class MinSumSubarray06 {

    public static int minSum(int[] arr, int k) {

        int windowSum = 0;

        // first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int minSum = windowSum;

        // slide window
        for (int i = k; i < arr.length; i++) {

            windowSum += arr[i];       // add next element
            windowSum -= arr[i - k];   // remove first element

            minSum = Math.min(minSum, windowSum);
        }

        return minSum;
    }

    public static void main(String[] args) {

        int[] arr = {2,1,5,1,3,2};
        int k = 3;

        int result = minSum(arr, k);

        System.out.println("Minimum sum: " + result);
    }
}