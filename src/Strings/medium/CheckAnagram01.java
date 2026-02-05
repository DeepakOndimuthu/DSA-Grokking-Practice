package Strings.medium;

/*
 MEDIUM
 No. 1
 Problem: Check Anagram
 Pattern: Frequency Counting
 Status: ✅ Solved

 LeetCode similar:
 - 242 (Valid Anagram)

 Input:
 s = "anagram"
 t = "nagaram"

 Output:
 true

 Explanation:
 Two strings are anagrams if:
 - both have same length
 - both have same character frequency
*/

public class CheckAnagram01 {

    public static boolean isAnagram(String s, String t) {

        // step 1: length check
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        // step 2: count characters of s
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // step 3: reduce using characters of t
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 'a']--;
        }

        // step 4: check all counts are zero
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }
}

