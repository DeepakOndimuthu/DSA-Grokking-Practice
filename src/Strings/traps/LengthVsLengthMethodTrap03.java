package Strings.traps;


/*
 TRAP
 No. 3
 Problem: length() vs length
 Pattern: Syntax Trap
 Status: ✅ Trap Covered

 Input:
 String s = "abc";
 char[] arr = {'a','b','c'};

 Output:
 Correct usage without compile error.

 Logic:
 1. String uses length()
 2. Array uses length
*/

public class LengthVsLengthMethodTrap03 {

    public static void main(String[] args) {

        String s = "abc";
        char[] arr = {'a','b','c'};

        System.out.println(s.length()); // correct
        System.out.println(arr.length); // correct
    }
}
