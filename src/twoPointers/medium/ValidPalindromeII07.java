package twoPointers.medium;

/*
 MEDIUM
 No. 7
 Problem: Valid Palindrome II
 Pattern: Two Pointers + Skip One Character
 Status: ✅ Solved

 LeetCode:
 - 680 (Valid Palindrome II)

 Input:
 s = "abca"

 Output:
 true

 Explanation:
 Remove one character ('b' or 'c')
 → "aca" or "aba" → palindrome
*/

public class ValidPalindromeII07 {

    public static boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                // try skipping one character
                return isPalindrome(s, left + 1, right) ||
                        isPalindrome(s, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }

    // helper function
    public static boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "abca";

        System.out.println(validPalindrome(s));
    }
}

/*
Normal palindrome:
check left == right

Here:
You can remove ONE character

Dry Code:
Example
"abca"
Step
a == a ✔
b != c ❌

Now try:

skip left → "aca" ✔
skip right → "aba" ✔

So: true

❗ Important
Only ONE deletion allowed

 */