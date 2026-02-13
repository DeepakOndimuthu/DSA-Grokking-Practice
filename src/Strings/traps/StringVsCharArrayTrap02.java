package Strings.traps;


/*
 TRAP
 No. 2
 Problem: String vs char[] Difference
 Pattern: Concept Understanding
 Status: ✅ Trap Covered

 Input:
 String s = "hello";
 char[] arr = {'h','e','l','l','o'};

 Output:
 Understand difference in mutability.

 Logic:
 1. String is immutable (cannot change directly)
 2. char[] is mutable (can change values)
*/

public class StringVsCharArrayTrap02 {

    public static void main(String[] args) {

        String s = "hello";
        char[] arr = {'h','e','l','l','o'};

        // arr can be changed
        arr[0] = 'H';
        System.out.println(arr);

        // String cannot be changed directly
        s = "Hello";
        System.out.println(s);
    }
}
