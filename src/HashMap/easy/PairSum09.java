package HashMap.easy;

import java.util.HashMap;

/*
 EASY
 No. 9
 Problem: Pair Sum using HashMap
 Pattern: HashMap Lookup
 Status: ✅ Solved

 LeetCode similar:
 - 1 (Two Sum)

 Input:
 arr = [2, 7, 11, 15]
 target = 9

 Output:
 true

 Explanation:
 Check if two numbers add up to target sum.
*/

public class PairSum09 {

    public static boolean pairSum(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {

            int required = target - num;

            // if required number already seen
            if (map.containsKey(required)) {
                return true;
            }

            // store current number
            map.put(num, 1); // read the below note section why this 1
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};
        int target = 9;

        System.out.println(pairSum(arr, target));
    }
}

/*
Note:
HashMap always stores data like: key → value ; ex:  2 → 1

LeetCode sum solve using hashmap
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
   }
 */

