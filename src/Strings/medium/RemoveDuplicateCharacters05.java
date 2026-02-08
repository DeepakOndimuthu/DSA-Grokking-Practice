package Strings.medium;

/*
 MEDIUM
 No. 5
 Problem: Remove Duplicate Characters
 Pattern: Frequency / Boolean Array
 Status: ✅ Solved

 LeetCode similar:
 - 316 (Remove Duplicate Letters)
 - 1047 (Remove All Adjacent Duplicates)

 Input:  "banana"
 Output: "ban"

 Explanation:
 Keep first occurrence of each character.
 Skip characters already seen.
*/

public class RemoveDuplicateCharacters05 {

    public static String removeDuplicates(String s) {

        boolean[] seen = new boolean[26];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!seen[ch - 'a']) {
                seen[ch - 'a'] = true;
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "banana";
        System.out.println(removeDuplicates(s));
    }
}
