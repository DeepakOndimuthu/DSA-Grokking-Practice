package Recursion.lc;

/*
LEETCODE
No. 10

Problem:
Power of Two

Pattern:
Recursion (Basic)

Status:
✅ Solved

LeetCode:
231 (Power of Two)

Input:
n = 16

Output:
true

Explanation:

A number is a Power of Two if:

It can be divided by 2
until it becomes 1.

If it reaches 1,

Return true.

If it becomes odd
(or less than or equal to 0)
before reaching 1,

Return false.

Examples:

16 → 8 → 4 → 2 → 1 → true

18 → 9 → false

0 → false

-8 → false
*/

public class PowerOfTwo231 {

    public static boolean isPowerOfTwo(int n) {

        // Base Case
        if (n == 1) {
            return true;
        }

        // Invalid Number
        if (n <= 0 || n % 2 != 0) {
            return false;
        }

        // Recursive Call
        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {

        int n = 16;

        System.out.println(isPowerOfTwo(n));
    }
}

/*
Dry Run

Input:
n = 16

1st Call
isPowerOfTwo(16)

16 == 1 ? No

16 <= 0 ? No

16 % 2 != 0 ? No

↓
isPowerOfTwo(8)

********************
2nd Call
isPowerOfTwo(8)
↓
isPowerOfTwo(4)

***********************
3rd Call
isPowerOfTwo(4)
↓
isPowerOfTwo(2)

**********************

4th Call
isPowerOfTwo(2)
↓
isPowerOfTwo(1)

*******************

5th Call
isPowerOfTwo(1)

1 == 1
↓

return true

***********************

Now every waiting function returns true:

isPowerOfTwo(1)
returns true
↑
isPowerOfTwo(2)
returns true
↑
isPowerOfTwo(4)
returns true
↑
isPowerOfTwo(8)
returns true
↑
isPowerOfTwo(16)
returns true

************************
Example 2

Input:
n = 18

Flow:

18
↓
18 / 2 = 9
↓
isPowerOfTwo(9)
↓
9 % 2 != 0
↓
return false

Final Output:
false

****************

 */
