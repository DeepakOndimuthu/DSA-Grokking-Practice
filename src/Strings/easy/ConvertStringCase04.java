package Strings.easy;

/*
 EASY
 No. 4
 Problem: Convert String to Lowercase / Uppercase
 Pattern: String Traversal / Built-in Methods
 Status: ✅ Solved

 LeetCode similar:
 - 709 (To Lower Case)
 - 1844 / 1309 (string transform based)
 - Used in frequency problems (1370 / 387)

 Input:  "IceCreAm"
 Output:
 Lowercase = "icecream"
 Uppercase = "ICECREAM"

 Explanation:
 Convert whole string to lowercase or uppercase.
 Used to handle case-insensitive comparisons.
*/

public class ConvertStringCase04 {

    public static String toLowerCase(String s) {
        return s.toLowerCase();
    }

    public static String toUpperCase(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String s = "IceCreAm";

        System.out.println("Lowercase = " + toLowerCase(s));
        System.out.println("Uppercase = " + toUpperCase(s));
    }
}
