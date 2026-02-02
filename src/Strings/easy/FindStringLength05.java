package Strings.easy;

/*
 EASY
 No. 5
 Problem: Find Length of String
 Pattern: String Traversal / Built-in
 Status: ✅ Solved

 LeetCode similar:
 - 709 (To Lower Case) → uses length()
 - 125 (Valid Palindrome) → uses length()
 - 387 (First Unique Character) → uses length()

 Input:  "hello world"
 Output: 11

 Explanation:
 Count number of characters in the string.
 Spaces are also counted.
*/

public class FindStringLength05 {

    // method 1: using built-in
    public static int lengthUsingBuiltIn(String s) {
        return s.length();
    }

    // method 2: without using length()
    public static int lengthWithoutBuiltIn(String s) {
        int count = 0;

        for (char ch : s.toCharArray()) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "hello world";

        System.out.println("Length (built-in) = " + lengthUsingBuiltIn(s));
        System.out.println("Length (manual) = " + lengthWithoutBuiltIn(s));
    }
}
