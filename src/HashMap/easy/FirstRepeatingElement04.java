package HashMap.easy;

import java.util.HashSet;

/*
 EASY
 No. 4
 Problem: First Repeating Element
 Pattern: HashSet Lookup
 Status: ✅ Solved

 LeetCode similar:
 - 217 (Contains Duplicate) [logic variation]

 Input:
 arr = [4, 5, 1, 2, 5, 1]

 Output:
 5

 Explanation:
 While traversing array,
 first element that appears again
 is the answer.
*/

public class FirstRepeatingElement04 {

    public static int firstRepeating(int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {

            // already present -> first repeating
            if (set.contains(num)) {
                return num;
            }

            set.add(num);
        }

        return -1; // no repeating element
    }

    public static void main(String[] args) {

        int[] arr = {4, 5, 1, 2, 5, 1};

        System.out.println(firstRepeating(arr));
    }
}
