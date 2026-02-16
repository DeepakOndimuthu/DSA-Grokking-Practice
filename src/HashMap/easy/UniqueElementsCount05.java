package HashMap.easy;

import java.util.HashSet;

/*
 EASY
 No. 5
 Problem: Unique Elements Count
 Pattern: HashSet Unique Counting
 Status: ✅ Solved

 LeetCode similar:
 - 217 (Contains Duplicate) [concept related]

 Input:
 arr = [1, 2, 2, 3, 4, 4]

 Output:
 4

 Explanation:
 HashSet stores only unique elements.
 Size of set gives unique count.
*/

public class UniqueElementsCount05 {

    public static int uniqueCount(int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        return set.size();
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 4, 4};

        System.out.println(uniqueCount(arr));
    }
}
