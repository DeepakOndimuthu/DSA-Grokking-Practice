package Strings.medium;

/*
 MEDIUM
 No. 9
 Problem: Replace Characters
 Pattern: String Traversal / StringBuilder
 Status: ✅ Solved

 LeetCode similar:
 - 151 (Reverse Words in a String) [string manipulation type]
 - 443 (String Compression) [replacement idea]

 Input:
 s = "apple"
 oldChar = 'p'
 newChar = 'b'

 Output:
 "abble"

 Explanation:
 Replace all occurrences of oldChar with newChar.
*/

public class ReplaceCharacters09 {

    public static String replaceCharacters(String s, char oldChar, char newChar) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // replace condition
            if (ch == oldChar) {
                result.append(newChar);
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s = "apple";

        System.out.println(replaceCharacters(s, 'p', 'b'));
    }
}
