package Recursion.lc;

/*
LEETCODE
No. 3

Problem:
Reverse String

Pattern:
Recursion (Two Pointers)

Status:
✅ Solved

LeetCode:
344 (Reverse String)

Input:
['h','e','l','l','o']

Output:
['o','l','l','e','h']

Explanation:

Use two pointers.

Swap the left and right characters.

Move the left pointer forward.

Move the right pointer backward.

Repeat using recursion until both pointers meet.
*/

public class ReverseString344 {

    public static void reverse(char[] s, int left, int right) {

        // Base Case
        if (left >= right) {
            return;
        }

        // Swap
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        // Recursive Call
        reverse(s, left + 1, right - 1);
    }

    public static void main(String[] args) {

        char[] s = {'h', 'e', 'l', 'l', 'o'};

        reverse(s, 0, s.length - 1);

        System.out.println(s);
    }
}

/*
Dry Run

Input:
[h, e, l, l, o]

1st Call

left = 0
right = 4

Swap
h ↔ o

Array
[o, e, l, l, h]

Recursive call
Move the left pointer forward.
Move the right pointer backward.
reverse(s, 1, 3)

********************
2nd Call

left = 1
right = 3

Swap
e ↔ l

Array
[o, l, l, e, h]

Recursive call
reverse(s, 2, 2)

********************

3rd Call

left = 2
right = 2

Base Case
if (left >= right)
    return;

Recursion stops.

Final Output
[o, l, l, e, h]

**************************
 */