package HashMap.easy;

import java.util.HashMap;
import java.util.Map;

/*
 EASY
 No. 2
 Problem: Count Characters using HashMap
 Pattern: HashMap Counting
 Status: ✅ Solved

 LeetCode similar:
 - 387 (First Unique Character in a String)
 - 242 (Valid Anagram)

 Input:
 s = "apple"

 Output:
 a -> 1
 p -> 2
 l -> 1
 e -> 1

 Explanation:
 Count frequency of each character
 using HashMap.
*/

public class CountCharacters02 {

    public static void countCharacters(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // if character already exists
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
            // first time occurrence
            else {
                map.put(ch, 1);
            }
        }

        // print result
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        String s = "apple";

        countCharacters(s);
    }
}
