package HashMap.easy;

import java.util.HashMap;
import java.util.Map;

/*
 EASY
 No. 1
 Problem: Frequency of Elements
 Pattern: HashMap Counting
 Status: ✅ Solved

 LeetCode similar:
 - 387 (First Unique Character in a String)
 - 242 (Valid Anagram) [frequency concept]

 Input:
 arr = [1, 2, 2, 3, 1, 4]

 Output:
 1 -> 2
 2 -> 2
 3 -> 1
 4 -> 1

 Explanation:
 Count how many times each element appears
 using HashMap.
*/

public class FrequencyOfElements01 {

    public static void frequency(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {

            // if element exists increase count
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1); //map.get(num) -> value stored for this key
                //map.put(2, map.get(2) + 1)
                //Current value is: map.get(2) = 1  -> get the value stored for key 2 ; first time save it value 1;
                //map.get(2) + 1 so -> 1 + 1 = 2
            }
            // else add first time
            else {
                map.put(num, 1);
            }
        }

        // print result
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        /*
        Map.Entry -> one pair of key and value
        1 → 2
         */
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 1, 4};

        frequency(arr);
    }
}

