package slidingWindow.easy;

/*
 EASY
 No. 10
 Problem: Edge Cases in Sliding Window
 Pattern: Sliding Window (Edge Case Handling)
 Status: ✅ Solved

 LeetCode similar:
 - Applies to all sliding window problems

 Input:
 arr = []
 k = 3

 Output:
 Invalid input

 Explanation:
 Handle special cases safely
*/

public class EdgeCases10 {

    public static int maxSum(int[] arr, int k) {

        // edge case 1: null or empty array
        if (arr == null || arr.length == 0) {
            System.out.println("Invalid input: empty array");
            return -1;
        }

        // edge case 2: k <= 0
        if (k <= 0) {
            System.out.println("Invalid input: k must be > 0");
            return -1;
        }

        // edge case 3: k > array length
        if (k > arr.length) {
            System.out.println("Invalid input: k greater than array size");
            return -1;
        }

        int windowSum = 0;

        // first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // slide window
        for (int i = k; i < arr.length; i++) {

            windowSum += arr[i];
            windowSum -= arr[i - k];

            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr = {};
        int k = 3;

        int result = maxSum(arr, k);

        System.out.println("Result: " + result);
    }
}

/*

Note:
check before solving any sliding window:
1. arr == null OR empty
2. k <= 0
3. k > arr.length

Sample Inputs:

1. Empty array
arr = []
k = 3
Output:
Invalid input: empty array

2. Null array
arr = null
k = 3
Output:
Invalid input: empty array

3. k <= 0
arr = [1,2,3]
k = 0   OR   k = -1
Output:
Invalid input: k must be > 0

4. k > array length
arr = [1,2]
k = 3
Output:
Invalid input: k greater than array size

5. k == array length
arr = [1,2,3]
k = 3
Output:
sum = 6

6. k == 1
arr = [2,5,1]
k = 1
Output:
max = 5

7. All negative numbers
arr = [-2,-5,-1,-3]
k = 2

still works
Windows:
[-2,-5] = -7
[-5,-1] = -6
[-1,-3] = -4

Output:
max = -4

*****
int maxSum = windowSum;
Good ✔ (handles negative values)
int maxSum = 0;
WRONG ❌ (fails for negative arrays)
******

8. Single element array
arr = [5]
k = 1
Output:
5

9. Large values
arr = [100000, 200000, 300000]
k = 2
Works (but sometimes use long if overflow risk)

 */