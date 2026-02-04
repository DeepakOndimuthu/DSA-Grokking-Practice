package Strings.easy;


/*
 EASY
 No. 7
 Problem: Count Words in a String
 Pattern: String Traversal / Space Detection
 Status: ✅ Solved

 LeetCode similar:
 - 434 (Number of Segments in a String)

 Input:  "hello world java"
 Output: 3

 Explanation:
 A word is a group of characters separated by spaces.
 Count when a non-space character starts a word.
*/

public class CountWordsInString07 {

    // method 1: without split()
    public static int countWords(String s) {

        int count = 0;
        boolean inWord = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch != ' ' && !inWord) {
                count++;
                inWord = true;
            } else if (ch == ' ') {
                inWord = false;
            }
        }
        return count;
    }

    // method 2: using split (simple)
    public static int countWordsUsingSplit(String s) {

        if (s == null || s.trim().isEmpty()) {
            return 0;
        }
        return s.trim().split("\\s+").length;
    }

    public static void main(String[] args) {
        String s = "hello world   java";

        System.out.println("Word count = " + countWords(s));
        System.out.println("Word count (split) = " + countWordsUsingSplit(s));
    }
}
