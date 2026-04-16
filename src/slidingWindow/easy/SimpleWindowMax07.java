package slidingWindow.easy;

import java.util.Arrays;

/*
 EASY
 No. 7
 Problem: Simple Window Maximum
 Pattern: Sliding Window (Fixed Size - Basic Max)
 Status: ✅ Solved

 LeetCode similar:
 - 239 (Sliding Window Maximum) (advanced version)

 Input:
 arr = [2,1,5,1,3,2]
 k = 3

 Output:
 [5,5,5,3]

 Explanation:
 Subarrays of size 3:
 [2,1,5] -> max = 5
 [1,5,1] -> max = 5
 [5,1,3] -> max = 5
 [1,3,2] -> max = 3
*/

public class SimpleWindowMax07 {

    public static int[] findMax(int[] arr, int k) {

        int[] result = new int[arr.length - k + 1];

        int start = 0;

        for (int end = 0; end < arr.length; end++) {

            // when window size becomes k
            if (end >= k - 1) {

                int max = arr[start];

                // find max in current window
                for (int i = start; i <= end; i++) {
                    if (arr[i] > max) {
                        max = arr[i];
                    }
                }

                result[start] = max;

                start++; // slide window
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {2,1,5,1,3,2};
        int k = 3;

        int[] result = findMax(arr, k);

        System.out.println(Arrays.toString(result));
    }
}

/*

Dry code
arr = [2,1,5,1,3,2]
k = 3

Step 1 → end = 0,1
window not ready

Step 2 → end = 2 ✅
start = 0
window = [2,1,5]

max = arr[0] = 2

Loop:
i = 0 → 2 > 2 ❌
i = 1 → 1 > 2 ❌
i = 2 → 5 > 2 ✅ → max = 5
result[0] = 5

Step 3 → end = 3 ✅
start = 1
window = [1,5,1]
Find max
max = arr[1] = 1

Loop:
i = 1 → 1 > 1 ❌
i = 2 → 5 > 1 ✅ → max = 5
i = 3 → 1 > 5 ❌
result[1] = 5

Step 4 → end = 4 ✅
start = 2
window = [5,1,3]
Find max
max = arr[2] = 5

Loop:
i = 2 → 5 > 5 ❌
i = 3 → 1 > 5 ❌
i = 4 → 3 > 5 ❌
result[2] = 5


Step 5 → end = 5 ✅
start = 3
window = [1,3,2]
Find max
max = arr[3] = 1

Loop:
i = 3 → 1 > 1 ❌
i = 4 → 3 > 1 ✅ → max = 3
i = 5 → 2 > 3 ❌
result[3] = 3

Final Output
[5,5,5,3]

 */