package Strings.traps;

/*
 TRAP
 No. 5
 Problem: Time Complexity of String Operations
 Pattern: Performance Awareness
 Status: ✅ Trap Covered

 Input:
 String concatenation in loop

 Output:
 Understand performance issue

 Logic:
 1. String is immutable
 2. s = s + ch creates new object each time
 3. Use StringBuilder for better performance
*/

public class StringTimeComplexityTrap05 {

    public static void main(String[] args) {

        String s = "";

        // slow approach
        for (int i = 0; i < 5; i++) {
            s = s + "a";
        }

        System.out.println(s);
    }
}
