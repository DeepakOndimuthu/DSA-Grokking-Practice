package slidingWindow.medium;

/*
 MEDIUM
 No. 4
 Problem: Smallest Subarray with Sum >= K
 Pattern: Sliding Window (Variable Size)
 Status: ✅ Solved

 LeetCode similar:
 - 209 (Minimum Size Subarray Sum)

 Input:
 arr = [2,3,1,2,4,3]
 k = 7

 Output:
 2

 Explanation:
 Subarrays with sum >= 7:
 [2,3,1,2] → length 4
 [3,1,2,4] → length 4
 [1,2,4] → length 3
 [2,4,3] → length 3
 [4,3] → length 2 ✅ smallest
*/

public class SmallestSubarray04 {

    public static int minLength(int[] arr, int k) {

        int start = 0;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int end = 0; end < arr.length; end++) {

            windowSum += arr[end];

            // when sum >= k → try to shrink
            while (windowSum >= k) {

                minLength = Math.min(minLength, end - start + 1);

                windowSum -= arr[start];
                start++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {

        int[] arr = {2,3,1,2,4,3};
        int k = 7;

        int result = minLength(arr, k);

        System.out.println("Smallest length: " + result);
    }
}

/*

concept:
1. Expand window → add elements
2. When sum >= k → VALID window
3. Now shrink from left → try to make it smaller
4. Keep minimum length

valid → shrink
invalid → expand

🚍 Easy example
Fill bucket (add water)
When full → remove from left slowly
Try smallest full bucket

***************

DRY RUN
arr = [2,3,1,2,4,3]
k = 7

🔹Step 1 → end = 0
windowSum = 2 (<7)

🔹end = 1
windowSum = 5 (<7)

🔹end = 2
windowSum = 6 (<7)

🔹end = 3
windowSum = 8 (>=7) ✅
window = [2,3,1,2]
Now WHILE loop starts
length = 4
minLength = 4
Shrink:
remove 2 → windowSum = 6
start = 1
Now while <7 → stop

🔹end = 4
windowSum = 6 + 4 = 10 (>=7)
window = [3,1,2,4]
While loop
length = 4 → min = 4
remove 3 → sum = 7
start = 2
Still >=7: so again while loop
length = 3 → min = 3
remove 1 → sum = 6
start = 3
stop

🔹end = 5
windowSum = 6 + 3 = 9 (>=7)
window = [2,4,3]
While loop
length = 3 → min = 3
remove 2 → sum = 7
start = 4
still >=7:
length = 2 → min = 2 ✅
remove 4 → sum = 3
start = 5
stop

minLength = 2

 */