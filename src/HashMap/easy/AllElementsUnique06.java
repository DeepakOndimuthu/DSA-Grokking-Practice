package HashMap.easy;

import java.util.HashSet;

/*
 EASY
 No. 6
 Problem: Check if All Elements are Unique
 Pattern: HashSet Lookup
 Status: ✅ Solved

 LeetCode similar:
 - 217 (Contains Duplicate)

 Input:
 arr = [1, 2, 3, 4]

 Output:
 true

 Explanation:
 If any element repeats,
 array does not contain all unique elements.
*/

public class AllElementsUnique06 {

    public static boolean allUnique(int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {

            // already present -> duplicate found
            if (set.contains(num)) {
                return false;
            }

            set.add(num);
        }

        return true;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        System.out.println(allUnique(arr));
    }
}
