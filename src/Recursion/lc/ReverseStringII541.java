package Recursion.lc;

/*
LEETCODE
No. 6

Problem:
Reverse String II

Pattern:
Recursion (String)

Status:
✅ Solved

LeetCode:
541 (Reverse String II)

Input:
s = "abcdefg"
k = 2

Output:
"bacdfeg"

Explanation:

Reverse the first k characters
for every 2k characters.

If remaining characters are less than k,

Reverse all remaining characters.

If remaining characters are between k and 2k,

Reverse only the first k characters.

Repeat using recursion until the string ends.
*/

import java.util.Arrays;

public class ReverseStringII541 {

    public static String reverseStr(String s, int k) {

        char[] chars = s.toCharArray();

        reverse(chars, 0, k);

        return new String(chars);
    }

    public static void reverse(char[] chars, int start, int k) {

        // Base Case
        if (start >= chars.length) {
            return;
        }

        int left = start;
        int right = Math.min(start + k - 1, chars.length - 1);

        // Reverse first k characters
        while (left < right) {

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        // Recursive Call
        reverse(chars, start + (2 * k), k);
    }

    public static void main(String[] args) {

        String s = "abcdefg";
        int k = 2;

        System.out.println(reverseStr(s, k));
    }
}

/*

Note:
normal string is -> s = "abcdefg"
new String(chars) -> abcdefg
Arrays.toString(chars) -> [a, b, c, d, e, f, g]

s.toCharArray() - String → char[]
new String(chars) - char[] → String
Arrays.toString(chars) - Prints the array as "[a, b, c]" (for debugging)

*******************
DRY RUN

Input
s = "abcdefg"
k = 2
*************************
1st Call
start = 0

Reverse first 2 characters
ab → ba

String becomes
bacdefg

Next recursive call
start = 4
*****************************
2nd Call
start = 4

Reverse first 2 characters
ef → fe

String becomes
bacdfeg

Next recursive call
start = 8
************************
3rd Call
start = 8

Base Case
if (start >= chars.length)
    return;

Recursion stops.
Final Output
bacdfeg

**************************

 */