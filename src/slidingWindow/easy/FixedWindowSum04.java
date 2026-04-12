package slidingWindow.easy;

import java.util.Arrays;
import java.util.Deque;

/*
 EASY
 No. 4
 Problem: Fixed Window Sum
 Pattern: Sliding Window (Fixed Size)
 Status: ✅ Solved

 LeetCode similar:
 - 643 (Maximum Average Subarray I) (concept)
 - 239 (Sliding Window Maximum) (advanced version)

 Input:
 arr = [2,1,5,1,3,2]
 k = 3

 Output:
 [8,7,9,6]

 Explanation:
 Subarrays of size 3:
 [2,1,5] -> sum = 8
 [1,5,1] -> sum = 7
 [5,1,3] -> sum = 9
 [1,3,2] -> sum = 6
*/

public class FixedWindowSum04 {

    public static int[] findWindowSums(int[] arr, int k) {

        int[] result = new int[arr.length - k + 1];

        int windowSum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {

            windowSum += arr[end]; // add element

            // when window size reaches k
            if (end >= k - 1) {

                result[start] = windowSum;

                windowSum -= arr[start]; // remove first element
                start++; // slide window
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {2,1,5,1,3,2};
        int k = 3;

        int[] result = findWindowSums(arr, k);

        System.out.println(Arrays.toString(result));
    }
}

/*

Note:
Difference from Previous Problems

1) Max Sum - one value
2) Average - array (avg)
3) Count - number
4) Fixed Sum - array (sum)

concept
Same as previous problems
But now we store sum of each window

 */

