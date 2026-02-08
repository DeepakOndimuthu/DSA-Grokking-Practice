package Strings.medium;

/*
 MEDIUM
 No. 4
 Problem: Reverse Words in a String
 Pattern: String Split + Reverse Traversal
 Status: ✅ Solved

 LeetCode similar:
 - 151 (Reverse Words in a String)

 Input:  "hello world java"
 Output: "java world hello"

 Explanation:
 Split string into words.
 Traverse from last word to first word.
 Build result string.
*/

public class ReverseWordsInString04 {

    public static String reverseWords(String s) {

        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);

            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "hello world java";
        System.out.println(reverseWords(s));
    }
}
