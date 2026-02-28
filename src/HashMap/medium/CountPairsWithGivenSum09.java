package HashMap.medium;

import java.util.*;

/*
 MEDIUM
 Problem: Count Pairs With Given Sum
 Pattern: HashMap + Complement
 Status: ✅ Solved

  LeetCode:
 - 15 (3Sum)
 - 18 (4Sum)

 Example:
 arr = {1, 5, 7, -1, 5}
 target = 6

 Output:
 3
*/

public class CountPairsWithGivenSum09 {

    public static int countPairs(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : arr) {

            int complement = target - num;

            // If complement already seen
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }

            // Store current number frequency
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {1, 5, 7, -1, 5};
        int target = 6;

        System.out.println(countPairs(arr, target));
    }
}

/*
count = 0
map = { }

num = 1
6 - 1 = 5
Map does NOT contain 5.
So count stays 0.
map = {1 → 1}

num = 5
6 - 5 = 1
Map contains 1.
so count is,
count += map.get(1)
count = 0 + 1 = 1
map = {1 → 1, 5 → 1}

num = 7
6 - 7 = -1
Map does NOT contain -1.
So count still 1.
map = {1 → 1, 5 → 1, 7 → 1}

num = -1
6 - (-1) = 7
Map contains 7.
So:
count += map.get(7)
count = 1 + 1 = 2
map = {1 → 1, 5 → 1, 7 → 1, -1 → 1}

num = 5 (second 5)
6 - 5 = 1
Map contains 1.
count += map.get(1)
count = 2 + 1 = 3
map = {1 → 1, 5 → 2, 7 → 1, -1 → 1}
 */