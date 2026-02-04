package Strings.easy;


/*
 EASY
 No. 9
 Problem: Compare Two Strings
 Pattern: Character Comparison / Built-in equals
 Status: ✅ Solved

 LeetCode similar:
 - 125 (Valid Palindrome) → string comparison
 - 844 (Backspace String Compare) → equals usage
 - Very common interview basic

 Input:
 s1 = "hello"
 s2 = "hello"

 Output:
 true

 Explanation:
 Compare two strings character by character.
 Strings are equal only if all characters match
 and length is same.
*/

public class CompareTwoStrings09 {

    // method 1: using equals()
    public static boolean compareUsingEquals(String s1, String s2) {

        if (s1 == null || s2 == null) {
            return false;
        }
        return s1.equals(s2);
    }

    // method 2: without using equals()
    public static boolean compareManually(String s1, String s2) {

        if (s1 == null || s2 == null) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";

        System.out.println(compareUsingEquals(s1, s2));
        System.out.println(compareManually(s1, s2));
    }
}
