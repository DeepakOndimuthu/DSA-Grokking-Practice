package slidingWindow.medium;

/*
 MEDIUM
 No. 5
 Problem: Variable Window Template
 Pattern: Sliding Window (Expand + Shrink)
 Status: ✅ Core Concept

 Use this template for:
 - longest substring
 - smallest subarray
 - max consecutive ones
 - many interview problems
*/

public class VariableWindowTemplate05 {

    public static int solve(int[] arr, int k) {

        int start = 0;
        int windowValue = 0; // sum / count / map etc.
        int answer = 0;      // max or min

        for (int end = 0; end < arr.length; end++) {

            // STEP 1: expand window
            windowValue += arr[end]; // sum of window

            // STEP 2: shrink window (when invalid)
            // sum becomes too big → shrink
            while (windowValue > k) {
                windowValue -= arr[start];
                start++;
            }

            // STEP 3: update answer
            // Store maximum length (longest subarray with sum <= k)
            answer = Math.max(answer, end - start + 1);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,1,1,1};
        int k = 3;

        int result = solve(arr, k);

        System.out.println("Answer: " + result);
    }
}

/*

this sum is find,
Longest subarray length where sum <= k

[1,2] → sum=3 → len=2
[2,1] → sum=3 → len=2
[1,1,1] → sum=3 → len=3 ✅
Output
3

*/
