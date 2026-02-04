package Strings.easy;

/*
 EASY
 No. 8
 Problem: Find First Character of String
 Pattern: Direct Access / Edge Case Handling
 Status: ✅ Solved

 LeetCode similar:
 - 387 (First Unique Character) → index usage
 - 709 (To Lower Case) → charAt usage
 - Very common interview warm-up

 Input:  "hello"
 Output: 'h'

 Explanation:
 The first character of a string is at index 0.
 Handle empty string to avoid error.
*/

public class FindFirstCharacter08 {

    public static char findFirstChar(String s) {

        // edge case: empty string
        if (s == null || s.length() == 0) {
            return '\0'; // null character
        }

        return s.charAt(0);
    }

    public static void main(String[] args) {
        String s = "hello";

        char firstChar = findFirstChar(s);

        if (firstChar == '\0') {
            System.out.println("String is empty");
        } else {
            System.out.println("First character = " + firstChar);
        }
    }
}
