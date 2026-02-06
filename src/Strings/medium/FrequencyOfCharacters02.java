package Strings.medium;

/*
 MEDIUM
 No. 2
 Problem: Frequency of Characters in a String
 Pattern: Frequency Counting
 Status: ✅ Solved

 LeetCode similar:
 - 387 (First Unique Character in a String)
 - 242 (Valid Anagram)
 - 1370 (Increasing Decreasing String)

 Input:  "banana"
 Output:
 b -> 1
 a -> 3
 n -> 2

 Explanation:
 Count how many times each character appears
 using a frequency array.
*/

public class FrequencyOfCharacters02 {

    public static void characterFrequency(String s) {

        int[] freq = new int[26];

        // step 1: count frequency
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // step 2: print frequency
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                System.out.println((char)(i + 'a') + " -> " + freq[i]);
            }
        }
    }

    public static void main(String[] args) {
        String s = "banana";
        characterFrequency(s);
    }
}
