package Strings.traps;

/*
 TRAP
 No. 4
 Problem: Unicode / Case Sensitivity
 Pattern: Character Handling
 Status: ✅ Trap Covered

 Input:
 "Apple"
 "apple"

 Output:
 false (case sensitive)

 Logic:
 1. String comparison is case sensitive
 2. Use toLowerCase() if needed
*/

public class UnicodeCaseTrap04 {

    public static void main(String[] args) {

        String s1 = "Apple";
        String s2 = "apple";

        System.out.println(s1.equals(s2)); // false

        System.out.println(
                s1.toLowerCase().equals(s2.toLowerCase())
        ); // true
    }
}
