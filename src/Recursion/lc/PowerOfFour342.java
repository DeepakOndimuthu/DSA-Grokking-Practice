package Recursion.lc;

/*
LEETCODE
No. 12

Problem:
Power of Four

Pattern:
Recursion (Basic)

Status:
✅ Solved

LeetCode:
342 (Power of Four)

Input:
n = 64

Output:
true

Explanation:

A number is a Power of Four if:

It can be divided by 4
until it becomes 1.

If it reaches 1,

Return true.

If it becomes not divisible by 4
(or less than or equal to 0)
before reaching 1,

Return false.

Examples:

64 → 16 → 4 → 1 → true

48 → 12 → 3 → false

0 → false

-16 → false
*/

public class PowerOfFour342 {

    public static boolean isPowerOfFour(int n) {

        // Base Case
        if (n == 1) {
            return true;
        }

        // Invalid Number
        if (n <= 0 || n % 4 != 0) {
            return false;
        }

        // Recursive Call
        return isPowerOfFour(n / 4);
    }

    public static void main(String[] args) {

        int n = 64;

        System.out.println(isPowerOfFour(n));
    }
}

/*

This problem is exactly like LeetCode 231 – Power of Two & 326 – Power of Three.
only that division is change

Note: (this is just input 1 is how true so why 4^0 = 1 so..)
4^0 = 1
4^1 = 4
4^2 = 16
4^3 = 64
4^4 = 256

Note:
at end the false concept explain how works java
Think of it like a friend

*********************

Dry Run

Input
n = 64

1st Call
isPowerOfFour(64)

64 == 1 ? No
64 <= 0 ? No
64 % 4 != 0 ? No
↓
isPowerOfFour(16)

******************
2nd Call
isPowerOfFour(16)
↓
isPowerOfFour(4)

*****************
3rd Call
isPowerOfFour(4)
↓
isPowerOfFour(1)

*********************
4th Call (Base Case)
isPowerOfFour(1)
1 == 1
↓
return true

***************************
Returning (Waiting Calls)
isPowerOfFour(1)
returns true
↑
isPowerOfFour(4)
returns true
↑
isPowerOfFour(16)
returns true
↑
isPowerOfFour(64)
returns true

*************************
Example 2
Input
n = 48

Flow:

isPowerOfFour(48)
↓
48 / 4 = 12
↓
isPowerOfFour(12)
↓
12 / 4 = 3
↓
isPowerOfFour(3)
↓
3 % 4 != 0
↓
return false
***********************
Returning
isPowerOfFour(3)
returns false
↑
isPowerOfFour(12)
returns false
↑
isPowerOfFour(48)
returns false

Final Output
false

***************************
concept:

Step 1
We call:
isPowerOfFour(48)

It executes:
return isPowerOfFour(48 / 4);

which becomes
return isPowerOfFour(12);

Now 48 stops and waits.
48
│
└── waiting...

*************************

Step 2

Now Java runs:
isPowerOfFour(12)

It executes:
return isPowerOfFour(12 / 4);

which becomes
return isPowerOfFour(3);

Now 12 also stops and waits.
48
│
└── waiting for 12

12
│
└── waiting for 3

************************
Step 3

Now Java runs:
isPowerOfFour(3)

It checks:
3 % 4 != 0
Yes.

So it returns
return false;

************************
Now the stack looks like this:

48
│
└── waiting
12
│
└── waiting
3
↓
false

**********************

Now the important part

Look at this code again:

return isPowerOfFour(3);

What does that mean?
It means:

"Whatever isPowerOfFour(3) returns, I will return the same thing."

Since
isPowerOfFour(3)
returned
false

this line becomes
return false;

So
isPowerOfFour(12)
returns
false

***********************
Then 48

Remember its code:

return isPowerOfFour(12);

Now Java replaces it with the returned value.
It becomes
return false;
So

isPowerOfFour(48)
also returns
false

******************
Think of it like a friend

Imagine three friends.

Friend 48 says:
"I'll tell you my answer after asking Friend 12."

Friend 12 says:
"I'll tell you my answer after asking Friend 3."

Friend 3 checks and says:
"The answer is false."

Friend 12 doesn't calculate anything else. He simply says:
"Friend 3 said false, so my answer is false."

Friend 48 also doesn't calculate anything else. He says:
"Friend 12 said false, so my answer is false."

******************************
 */
