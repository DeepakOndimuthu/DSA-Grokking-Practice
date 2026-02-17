package HashMap.easy;

import java.util.HashMap;

/*
 EASY
 No. 8
 Problem: Find Element with Frequency 1
 Pattern: HashMap Frequency Counting
 Status: ✅ Solved

 LeetCode similar:
 - 136 (Single Number) [concept related]
 - 387 (First Unique Character)

 Input:
 arr = [1, 2, 2, 3, 4, 4]

 Output:
 1

 Explanation:
 Element with frequency 1 is returned.
*/

public class FrequencyOneElement08 {

    public static int findFrequencyOne(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: count frequency
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: find first element with frequency 1
        for (int num : arr) {
            if (map.get(num) == 1) {
                return num;
            }
        }

        return -1; // no such element
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 4, 4};

        System.out.println(findFrequencyOne(arr));
    }
}