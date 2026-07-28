package Recursion.lc;

/*
LEETCODE
No. 11

Problem:
Power of Three

Pattern:
Recursion (Basic)

Status:
✅ Solved

LeetCode:
326 (Power of Three)

Input:
n = 27

Output:
true

Explanation:

A number is a Power of Three if:

It can be divided by 3
until it becomes 1.

If it reaches 1,

Return true.

If it becomes not divisible by 3
(or less than or equal to 0)
before reaching 1,

Return false.

Examples:

27 → 9 → 3 → 1 → true

45 → 15 → 5 → false

0 → false

-9 → false
*/

public class PowerOfThree326 {

    public static boolean isPowerOfThree(int n) {

        // Base Case
        if (n == 1) {
            return true;
        }

        // Invalid Number
        if (n <= 0 || n % 3 != 0) {
            return false;
        }

        // Recursive Call
        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {

        int n = 27;

        System.out.println(isPowerOfThree(n));
    }
}

/*

This problem is exactly like LeetCode 231 – Power of Two.
only that division is change
****************
Dry Run
Input
n = 27

1st Call
isPowerOfThree(27)

27 == 1 ? No
27 <= 0 ? No
27 % 3 != 0 ? No
↓
isPowerOfThree(9)

**************************
2nd Call
isPowerOfThree(9)
↓
isPowerOfThree(3)

*****************************
3rd Call
isPowerOfThree(3)
↓
isPowerOfThree(1)

**********************
4th Call (Base Case)
isPowerOfThree(1)
1 == 1
↓
return true

****************************
Returning (Waiting Calls)
isPowerOfThree(1)
returns true
↑
isPowerOfThree(3)
returns true
↑
isPowerOfThree(9)
returns true
↑
isPowerOfThree(27)
returns true

******************************
Example 2
Input
n = 45

Flow:
isPowerOfThree(45)
↓
45 / 3 = 15
↓
isPowerOfThree(15)
↓
15 / 3 = 5
↓
isPowerOfThree(5)
↓
5 % 3 != 0
↓
return false

*********************
Returning
isPowerOfThree(5)
returns false
↑
isPowerOfThree(15)
returns false
↑
isPowerOfThree(45)
returns false
Final Output
false
************************

 */