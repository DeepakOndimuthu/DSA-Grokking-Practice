package HashMap.easy;

import java.util.HashMap;
import java.util.Map;

/*
 EASY
 No. 7
 Problem: Count Words in Sentence
 Pattern: HashMap Counting
 Status: ✅ Solved

 LeetCode similar:
 - 819 (Most Common Word) [concept similar]

 Input:
 s = "apple banana apple mango"

 Output:
 apple -> 2
 banana -> 1
 mango -> 1

 Explanation:
 Sentence is split into words.
 HashMap stores word frequency.
*/

public class CountWords07 {

    public static void countWords(String s) {

        HashMap<String, Integer> map = new HashMap<>();

        // split sentence into words
        String[] words = s.split(" ");

        for (String word : words) {

            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        // print result
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        String s = "apple banana apple mango";

        countWords(s);
    }
}