package Strings.medium;

/*
 MEDIUM
 No. 6
 Problem: Valid Palindrome (Ignore Symbols)
 Pattern: Two Pointers
 Status: ✅ Solved

 LeetCode similar:
 - 125 (Valid Palindrome)

 Input:
 s = "A man, a plan, a canal: Panama"

 Output:
 true

 Explanation:
 A string is palindrome if it reads same forward and backward.

 Rules:
 - Ignore spaces
 - Ignore symbols
 - Ignore uppercase / lowercase difference

 After removing symbols and converting to lowercase:
 "amanaplanacanalpanama"
 which is a palindrome.
*/

public class ValidPalindrome06 {

    public static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // compare characters (ignore case)
            if (Character.toLowerCase(s.charAt(left)) !=
                    Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(s));
    }
}

/*
Character.isLetterOrDigit(s.charAt(left))
true → if character is a-z, A-Z, or 0-9
false → if character is space or symbol

while concept:
Keep moving left pointer until we find a letter or digit.

left = 0 → 'A'
right = last index → 'a'
toLowerCase('A') == toLowerCase('a') ✅
*/