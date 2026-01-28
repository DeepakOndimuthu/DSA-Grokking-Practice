package Strings.easy;

/*
 EASY
 No. 1
 Problem: Reverse a String
 Pattern: Two Pointers / Loop from end
 LeetCode similar: #344
 Status: ✅ Solved

 Input:  "hello"
 Output: "olleh"

 Explanation:
 Start from last character.
 Append each character to a new string.
*/

public class ReverseString01 {

    public static String reverse(String s) {
        String result = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            result = result + s.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverse(s));
    }
}
