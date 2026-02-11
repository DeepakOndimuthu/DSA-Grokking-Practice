package Strings.medium;

/*
 MEDIUM
 No. 8
 Problem: Check Rotation of String
 Pattern: String Concatenation
 Status: ✅ Solved

 LeetCode similar:
 - 796 (Rotate String)

 Input:
 s = "abcde"
 goal = "cdeab"

 Output:
 true

 Explanation:
 A string is a rotation if it can be obtained by moving
 characters from front to end.

 Example:
 "abcde" → "bcdea" → "cdeab"

 Trick:
 If goal is rotation of s,
 then goal must exist inside (s + s).
*/

public class CheckRotationOfString08 {

    public static boolean isRotation(String s, String goal) {

        // step 1: length must be same
        if (s.length() != goal.length()) {
            return false;
        }

        // step 2: concatenate string
        String doubled = s + s;

        // step 3: check goal exists inside doubled string
        return doubled.contains(goal);
    }

    public static void main(String[] args) {

        String s = "abcde";
        String goal = "cdeab";

        System.out.println(isRotation(s, goal));
    }
}

/*
concatenate string part
s + s = "abcdeabcde"
abcde   ✅
 bcdea  ✅
  cdeab ✅
   deabc ✅
    eabcd ✅
 All rotations appear as a continuous substring.
 */
