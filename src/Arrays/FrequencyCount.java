package Arrays;

/*
 No. 4
 Problem: Frequency of Elements in an Array
 Pattern: HashMap + Counting
 Status: ✅ Solved
 Input: nums = [1, 2, 2, 3, 1]
 Output:
 1 -> 2
 2 -> 2
 3 -> 1
 Explanation:
 Use HashMap to store element counts.
*/

import java.util.HashMap;
import java.util.Map;

public class FrequencyCount {

    public static void countFrequency(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1};
        countFrequency(nums);
    }
}
