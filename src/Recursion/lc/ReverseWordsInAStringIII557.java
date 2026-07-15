package Recursion.lc;

/*
LEETCODE
No. 7

Problem:
Reverse Words in a String III

Pattern:
Recursion (String + Two Pointers)

Status:
✅ Solved

LeetCode:
557 (Reverse Words in a String III)

Input:
s = "Let's take LeetCode contest"

Output:
"s'teL ekat edoCteeL tsetnoc"

Explanation:

Reverse each word separately.

Keep the word order the same.

Find the end of the current word.

Reverse the current word using two pointers.

Then recursively move to the next word.

Example:

Let's -> s'teL

take -> ekat

LeetCode -> edoCteeL

contest -> tsetnoc
*/

import java.util.Arrays;

public class ReverseWordsInAStringIII557 {

    public static String reverseWords(String s) {

        char[] chars = s.toCharArray();

        reverseWords(chars, 0);

        return new String(chars);
    }

    public static void reverseWords(char[] chars, int start) {

        // Base Case
        if (start >= chars.length) {
            return;
        }

        int end = start;

        // Find the end of the current word
        while (end < chars.length && chars[end] != ' ') {
            end++;
        }

        // Reverse the current word
        reverse(chars, start, end - 1);

        // Recursive Call
        reverseWords(chars, end + 1);
    }

    public static void reverse(char[] chars, int left, int right) {

        while (left < right) {

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        String s = "Let's take LeetCode contest";

        System.out.println(reverseWords(s));
    }
}

/*

start = 0  → "Let's"    → "s'teL"
start = 6  → "take"     → "ekat"
start = 11 → "LeetCode" → "edoCteeL"
start = 20 → "contest"  → "tsetnoc"

start = remembers where the word STARTS
end   = searches for where the word ENDS

******************

Concept Note:
method overloading
Java allows this. It is called method overloading.

In this program two methods with the same name, but their parameters are different:
1) public static String reverseWords(String s)
2) public static void reverseWords(char[] chars, int start)

******************

Index:  0   1   2   3   4   5   6   7   8   9 ...
Char :  L   e   t   '   s  ' '  t   a   k   e ...

At first:
start = 0;
int end = start;

start = 0
end   = 0

*******************
while loop :
Find the end of the current word

end = 0 → chars[0] = L → not space → end++
end = 1 → chars[1] = e → not space → end++
end = 2 → chars[2] = t → not space → end++
end = 3 → chars[3] = ' → not space → end++
end = 4 → chars[4] = s → not space → end++
end = 5 → chars[5] = space → STOP

So after the while loop:
start = 0
end   = 5

*************************
Now:
reverse(chars, start, end - 1);

becomes:
reverse(chars, 0, 5 - 1);

so:
reverse(chars, 0, 4);

       start             end
         ↓                ↓
Index:   0  1  2  3  4   5
Char :   L  e  t  '  s  ' '
                         ↑
                       space

******************************
Therefore, we reverse only:
reverse()
index 0 to index 4

Let's
↓
s'teL

Result:
s'teL

*********************
Recursive Call time start value is

start = 0  → Let's
start = 6  → take
start = 11 → LeetCode
start = 20 → contest
start = 27 → Base Case → STOP

*********************
 */