package Strings.easy;

/*
 EASY
 No. 3
 Problem: Count Vowels and Consonants
 Pattern: String Traversal + Condition Check
 LeetCode similar: #345 & #2586
 Status: ✅ Solved

 Input: "hello world"
 Output:
 Vowels = 3
 Consonants = 7

 Explanation:
 Traverse each character in the string.
 If character is a vowel → increment vowel count.
 Else if character is a letter → increment consonant count.
 Ignore spaces and symbols.
*/

public class CountVowelsAndConsonants03 {

    public static void count(String s) {

        int vowels = 0;
        int consonants = 0;

        s = s.toLowerCase(); // handle case sensitivity

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // check if character is a letter
            if (ch >= 'a' && ch <= 'z') {

                // check vowels
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels = " + vowels);
        System.out.println("Consonants = " + consonants);
    }

    public static void main(String[] args) {
        String s = "hello world";
        count(s);
    }
}

