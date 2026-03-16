package twoPointers.easy;

/*
 EASY
 No. 3
 Problem: Check Palindrome
 Pattern: Two Pointers
 Status: ✅ Solved

 LeetCode similar:
 - 125 (Valid Palindrome)
 - 9 (Palindrome Number)

 Input:
 s = "madam"

 Output:
 true

 Explanation:
 Compare first and last characters.
 If they are equal move pointers inward.
 If mismatch occurs → not a palindrome.
*/

public class CheckPalindrome03 {

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