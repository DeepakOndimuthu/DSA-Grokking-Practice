package HashMap.medium;

import java.util.HashMap;

/*
 MEDIUM
 Problem: Two Sum
 Pattern: HashMap Lookup
 Status: ✅ Solved

 LeetCode:
 - 1 (Two Sum)

 Input:
 nums = [2, 7, 11, 15]
 target = 9

 Output:
 [0, 1]

 Explanation:
 nums[0] + nums[1] = 9
*/

public class TwoSum01 {

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        // key = number
        // value = index

        for (int i = 0; i < nums.length; i++) {

            int required = target - nums[i];

            // check if required number exists
            if (map.containsKey(required)) {
                return new int[]{map.get(required), i};
            }

            // store current number with index
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println(result[0] + ", " + result[1]);
    }
}
