package HashMap.medium;

import java.util.HashSet;

/*
 MEDIUM
 Problem: Subarray with Sum Zero
 Pattern: Prefix Sum + HashSet
 Status: ✅ Solved

 LeetCode:
 - 560 (Subarray Sum Equals K)
 - 523 – (Continuous Subarray Sum)

 Input:
 arr = [4, 2, -3, 1, 6]

 Output:
 true

 Explanation:
 Subarray [2, -3, 1] has sum 0.
*/

public class SubarraySumZero05 {

    public static boolean hasZeroSumSubarray(int[] arr) {

        HashSet<Integer> set = new HashSet<>();
        int sum = 0;

        for (int num : arr) {

            sum += num;

            // Case 1: sum becomes zero
            if (sum == 0) {
                return true;
            }

            // Case 2: sum already seen
            if (set.contains(sum)) {
                return true;
            }

            set.add(sum);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, -3, 1, 6};

        System.out.println(hasZeroSumSubarray(arr));
    }
}

/*
Note:
HashSet - fast lookup ,Values may be negative, values may be large & No fixed size needed

Iteration 1
num = 4
sum = 0 + 4 = 4
Set = {4}

Iteration 2
num = 2
sum = 4 + 2 = 6
Set = {4, 6}

Iteration 3
num = -3
sum = 6 - 3 = 3
Set = {4, 6, 3}

Iteration 4
num = 1
sum = 3 + 1 = 4
Now check: Is 4 already in set? YES ✅

Index 0 → sum = 4
Index 3 → sum = 4
Difference:
sum(3) - sum(0) = 4 - 4 = 0

So Subarray between index 1 to 3 = 0
2 + (-3) + 1 = 0


 */