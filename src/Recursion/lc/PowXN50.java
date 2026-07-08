package Recursion.lc;

/*
LEETCODE
No. 2

Problem:
Pow(x, n)

Pattern:
Recursion (Basic)

Status:
✅ Solved

LeetCode:
50 (Pow(x, n))

Input:
x = 2.0
n = 10

Output:
1024.0

Explanation:

Find x raised to the power n.

Base Case:

If n is 0

Return 1

Otherwise

Multiply x with the result of x raised to (n - 1).

Formula:

pow(x, n) = x × pow(x, n - 1)
*/

public class PowXN50 {

    public static double myPow(double x, int n) {

        // Base Case
        if (n == 0) {
            return 1;
        }

        // Recursive Call
        return x * myPow(x, n - 1);
    }

    public static void main(String[] args) {

        double x = 2.0;
        int n = 10;

        System.out.println(myPow(x, n));
    }
}

/*
concept:
Expression	Meaning	Answer
2^1	2	2
2^2	2 × 2	4
2^3	2 × 2 × 2	8
2^4	2 × 2 × 2 × 2	16
2^5	2 × 2 × 2 × 2 × 2	32
2^6	2 × 2 × 2 × 2 × 2 × 2	64
2^7	2 × 2 × 2 × 2 × 2 × 2 × 2	128
2^8	2 × 2 × 2 × 2 × 2 × 2 × 2 × 2	256
2^9	2 × 2 × 2 × 2 × 2 × 2 × 2 × 2 × 2	512
2^10	2 multiplied 10 times	1024

********************
Small dry code

myPow(2, 3)
it becomes

2 × myPow(2, 2)

= 2 × (2 × myPow(2, 1))
= 2 × (2 × (2 × myPow(2, 0)))
= 2 × 2 × 2 × 1
= 8

Notice the base case:
if (n == 0) {
    return 1;
}

Why return 1?
Because in mathematics,

2^0 = 1
5^0 = 1
10^0 = 1

*********************
 */