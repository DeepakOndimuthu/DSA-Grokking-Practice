package slidingWindow.medium;

import java.util.HashMap;

/*
 MEDIUM
 No. 2
 Problem: Longest Subarray with Sum K
 Pattern: Prefix Sum + HashMap (Important)
 Status: ✅ Solved

 LeetCode similar:
 - 560 (Subarray Sum Equals K)

 Input:
 arr = [1,2,3,1,1,1,1]
 k = 3

 Output:
 3

 Explanation:
 Subarrays with sum = 3:
 [1,2] → length 2
 [3] → length 1
 [1,1,1] → length 3 ✅ longest
*/

public class LongestSubarraySumK02 {

    public static int longestSubarray(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            // if sum itself equals k
            if (sum == k) {
                maxLength = i + 1; // index starts from 0 so we add plus one
            }

            // check if (sum - k) seen before
            if (map.containsKey(sum - k)) {
                int length = i - map.get(sum - k);
                maxLength = Math.max(maxLength, length);
            }

            // store first occurrence of sum
            /*
            Only first occurrence is stored
            Never overwrite
            */
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,1,1,1,1};
        int k = 3;

        int result = longestSubarray(arr, k);

        System.out.println("Longest length: " + result);
    }
}

/*

Subarray Sum Equals K (LeetCode 560)
Goal:
Count how many subarrays = k
Output : count
Map value : frequency
Update : add counts

Longest Subarray with Sum K
Goal:
Find longest length of subarray = k
Output : max length
Map value : index
Update : calculate length

*****************

Subarray = continuous elements

Example:
arr = [1,2,3]

Valid subarrays:

[1]
[2]
[3]
[1,2]
[2,3]
[1,2,3]

❌ NOT subarray:
[1,3]  (skip element → invalid ❌)

Problem idea
Find longest subarray with sum = k
arr = [1,2,3,1,1,1,1]
k = 3

Valid subarrays:
[1,2] → sum = 3 → length = 2
[3] → sum = 3 → length = 1
[1,1,1] → sum = 3 → length = 3 ✅

Main Concept
Use Prefix Sum + HashMap
sum = sum of elements from start to current index
Example:
arr = [1,2,3]
i=0 → sum=1 (1)
i=1 → sum=3 (1 + 2)
i=2 → sum=6 ( 1+2+3)

int length = i - map.get(sum - k);
meaning:
current index = i
old index = map.get(sum-k)
Then subarray length:
length = i - oldIndex

Example:
sum = 6
k = 3
sum-k = 3

If 3 seen before at index 1:
subarray = index 2 to 3
length = 3 - 1 = 2

******

FULL DRY RUN
arr = [1,2,3,1,1,1,1]
k = 3

🔹i = 0
sum = 1
map = {1:0}

🔹i = 1
sum = 3
sum == k → length = 2
maxLength = 2

map = {1:0, 3:1}

🔹i = 2
sum = 6
sum-k = 3

map has 3 at index 1
length = 2 - 1 = 1

maxLength = 2
map = {1:0, 3:1, 6:2}

🔹i = 3
sum = 7
sum-k = 4 (not found)
map add → {7:3}

🔹i = 4
sum = 8
sum-k = 5 (not found)
map add → {8:4}

🔹 i = 5
sum = 9
sum-k = 6

map has 6 at index 2
length = 5 - 2 = 3 ✅

maxLength = 3
map = {9:5}

🔹i = 6
sum = 10
sum-k = 7

map has 7 at index 3
length = 6 - 3 = 3

maxLength = 3

Final Answer
maxLength = 3

********************

Final map is look like
map = {1:0, 3:1, 6:2, 7:3, 8:4, 9:5, 10:6}

Final full map (step-by-step)
i=0 → sum=1   → {1:0}
i=1 → sum=3   → {1:0, 3:1}
i=2 → sum=6   → {1:0, 3:1, 6:2}
i=3 → sum=7   → {1:0, 3:1, 6:2, 7:3}
i=4 → sum=8   → {1:0, 3:1, 6:2, 7:3, 8:4}
i=5 → sum=9   → {1:0, 3:1, 6:2, 7:3, 8:4, 9:5}
i=6 → sum=10  → {1:0, 3:1, 6:2, 7:3, 8:4, 9:5, 10:6}


 */