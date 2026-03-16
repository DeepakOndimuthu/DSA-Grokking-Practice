package twoPointers.easy;

/*
 EASY
 No. 2
 Problem: Reverse String
 Pattern: Two Pointers
 Status: ✅ Solved

 LeetCode similar:
 - 344 (Reverse String)

 Input:
 s = "hello"

 Output:
 "olleh"

 Explanation:
 Use two pointers.
 One pointer at beginning.
 One pointer at end.
 Swap characters and move inward.
*/

public class ReverseString02 {

    public static void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left < right) {

            // swap characters
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            // move pointers
            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        char[] s = {'h','e','l','l','o'};

        reverseString(s);

        System.out.println(s);
    }
}