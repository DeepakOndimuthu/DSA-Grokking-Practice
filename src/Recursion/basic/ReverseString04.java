package Recursion.basic;

/*
BASIC
No. 4

Problem:
Reverse String

Pattern:
Recursion (Basic)

Status:
✅ Solved

LeetCode Similar:

344 - Reverse String
541 – Reverse String II
557 – Reverse Words in a String III

Input:
"hello"

Output:
"olleh"

Explanation:

Swap the first and last characters,
then recursively move toward the center.
*/

public class ReverseString04 {

    public static void reverse(char[] arr, int left, int right) {

        // Base Case
        if (left >= right) {
            return;
        }

        // Swap
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        // Recursive Call
        reverse(arr, left + 1, right - 1);

    }

    public static void main(String[] args) {

        String str = "hello";

        char[] arr = str.toCharArray();

        reverse(arr, 0, arr.length - 1);

        System.out.println(new String(arr));

    }

}

/*
Explanation in LC section
 */
