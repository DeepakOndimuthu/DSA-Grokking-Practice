package Strings.easy;

/*
 EASY
 No. 2
 Problem: Check Palindrome
 Pattern: Two Pointers
 Status: ✅ Solved
 LeetCode similar: #125 & #9

 Input:  "madam"
 Output: true

 Explanation:
 Compare first and last character.
 Move pointers inward.
 If mismatch → not palindrome.
*/

public class CheckPalindrome02 {

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

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
        String s = "madam";
        System.out.println(isPalindrome(s));
    }
}
