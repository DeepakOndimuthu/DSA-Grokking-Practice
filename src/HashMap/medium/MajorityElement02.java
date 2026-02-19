package HashMap.medium;

import java.util.HashMap;

/*
 MEDIUM
 Problem: Majority Element
 Pattern: HashMap Frequency Counting
 Status: ✅ Solved

 LeetCode:
 - 169 (Majority Element)

 Input:
 nums = [3, 2, 3]

 Output:
 3

 Explanation:
 Element appearing more than n/2 times (it's strictly more than half)
 is majority element.
*/

public class MajorityElement02 {

    public static int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {

            map.put(num, map.getOrDefault(num, 0) + 1);

            // check immediately
            if (map.get(num) > n / 2) {
                return num;
            }
        }

        return -1; // not found
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 3};

        System.out.println(majorityElement(nums));
    }
}

/*
 map.put(num, map.getOrDefault(num, 0) + 1);
 If number already exists → get old value
 If not → take default value 0
 Then add 1

ex:
Iteration 2
num = 3
map.getOrDefault(3,0) = 0
0 + 1 = 1
map.put(3,1) means 3 → 1 this like

Iteration 2
num = 2
map.getOrDefault(2,0) = 0
0 + 1 = 1
map.put(2,1)
3 → 1
2 → 1

Iteration 3
num = 3 again
map.getOrDefault(3,0) = 1
1 + 1 = 2
map.put(3,2)

 */

