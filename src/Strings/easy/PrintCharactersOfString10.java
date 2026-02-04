package Strings.easy;

/*
 EASY
 No. 10
 Problem: Print Characters of a String
 Pattern: String Traversal
 Status: ✅ Solved

 LeetCode similar:
 - 344 (Reverse String) → character traversal
 - 387 (First Unique Character) → char access
 - Common interview warm-up

 Input:  "hello"
 Output:
 h
 e
 l
 l
 o

 Explanation:
 Traverse the string character by character
 and print each character.
*/

public class PrintCharactersOfString10 {

    public static void printCharacters(String s) {

        if (s == null || s.length() == 0) {
            System.out.println("String is empty");
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
    }

    public static void main(String[] args) {
        String s = "hello";
        printCharacters(s);
    }
}
