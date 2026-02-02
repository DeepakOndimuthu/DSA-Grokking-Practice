package Strings.easy;

/*
 EASY
 No. 6
 Problem: Remove Spaces from String
 Pattern: String Traversal / StringBuilder
 Status: ✅ Solved

 LeetCode similar:
 - 125 (Valid Palindrome) → space ignoring
 - 844 (Backspace String Compare) → string rebuild
 - Used in parsing problems

 Input:  "hello world java"
 Output: "helloworldjava"

 Explanation:
 Traverse each character.
 If character is not a space, append to result.
*/

public class RemoveSpacesFromString06 {

    // method 1: using StringBuilder
    public static String removeSpaces(String s) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    // method 2: using replace (built-in)
    public static String removeSpacesUsingReplace(String s) {
        return s.replace(" ", "");
    }

    public static void main(String[] args) {
        String s = "hello world java";

        System.out.println(removeSpaces(s));
        System.out.println(removeSpacesUsingReplace(s));
    }
}
