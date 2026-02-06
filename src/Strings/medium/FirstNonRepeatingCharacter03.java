package Strings.medium;


/*
 MEDIUM
 No. 3
 Problem: First Non-Repeating Character
 Pattern: Frequency Counting
 Status: ✅ Solved

 LeetCode similar:
 - 387 (First Unique Character in a String)

 Input:  "leetcode"
 Output: 'l'

 Explanation:
 Count frequency of each character.
 Traverse the string again and return
 the first character whose frequency is 1.
*/

public class FirstNonRepeatingCharacter03 {

    public static char firstNonRepeating(String s) {

        int[] freq = new int[26];

        // step 1: count frequency
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // step 2: find first character with freq = 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }

        return '\0'; // no non-repeating character - empty/null character
    }

    public static void main(String[] args) {
        String s = "leetcode";

        char result = firstNonRepeating(s);

        if (result == '\0') {
            System.out.println("No non-repeating character");
        } else {
            System.out.println("First non-repeating character = " + result);
        }
    }
}
