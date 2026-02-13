package Strings.traps;

/*
 TRAP
 Problem: StringBuilder Fast Concatenation
 Pattern: Performance Optimization
 Status: ✅ Recommended

 Logic:
 StringBuilder modifies same object.
 No new object creation in loop.
*/

public class FastStringBuilder06 {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            sb.append("a");
        }

        String result = sb.toString();

        System.out.println(result);
    }
}

/*
Immutable means: Once object is created, its value cannot be changed.
String is immutable
"abc"   (old object stays)
"abcd"  (new object created)

mutable - same object modified again and again
""  → "a" → "aa" → "aaa"

String       → immutable (new object each time) O(n²)
StringBuilder → mutable (same object updated) O(n)

fifth sum what happened internally
"" + "a"   → new string // created
"a" + "a"  → new string // new object
"aa" + "a" → new string // new object

 */
