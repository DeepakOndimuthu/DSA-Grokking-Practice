package Strings.traps;

/*
 No. 1
 Problem: Edge Case – Empty String
 Pattern: Defensive Check
 Status: ✅ Trap Covered

 Input: ""
 Output: Handle safely

 Logic:
 1. Check length == 0
 2. Avoid charAt(0) crash
*/

public class EmptyStringTrap01 {

    public static void checkString(String s) {
        if (s.length() == 0) {
            System.out.println("String is empty");
            return;
        }

        System.out.println("First character: " + s.charAt(0));
    }

    public static void main(String[] args) {
        String s = "";
        checkString(s);
    }
}
