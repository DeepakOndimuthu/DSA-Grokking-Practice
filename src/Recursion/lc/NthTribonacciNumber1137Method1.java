package Recursion.lc;

/*
LEETCODE
No. 5

Problem:
N-th Tribonacci Number

Pattern:
Recursion (Basic)

Status:
✅ Solved

LeetCode:
1137 (N-th Tribonacci Number)

Input:
4

Output:
4

Explanation:

The Tribonacci sequence is:

0
1
1
2
4
7
13
24
44
...

Each number is the sum of the previous three numbers.

Base Cases:

tribonacci(0) = 0

tribonacci(1) = 1

tribonacci(2) = 1

Formula:

tribonacci(n) =
tribonacci(n - 1)
+ tribonacci(n - 2)
+ tribonacci(n - 3)
*/

public class NthTribonacciNumber1137Method1 {

    static int[] memo;

    public static int tribonacci(int n) {

        memo = new int[n + 1];

        return calculate(n);
    }

    public static int calculate(int n) {

        // Base Cases
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        // Already Calculated
        if (memo[n] != 0) {
            return memo[n];
        }

        // Store Answer
        memo[n] = calculate(n - 1)
                + calculate(n - 2)
                + calculate(n - 3);

        return memo[n];
    }

    public static void main(String[] args) {

        int n = 4;

        System.out.println(tribonacci(n));
    }
}

/*
Initially:

Index : 0 1 2 3 4 5 6
Value : 0 0 0 0 0 0 0

Examples

After computing tribonacci(3):
Index : 0 1 2 3 4 5 6
Value : 0 0 0 2 0 0 0

After computing tribonacci(4):
Index : 0 1 2 3 4 5 6
Value : 0 0 0 2 4 0 0

After computing tribonacci(5):
Index : 0 1 2 3 4 5 6
Value : 0 0 0 2 4 7 0

After computing tribonacci(6):
Index : 0 1 2 3 4 5 6
Value : 0 0 0 2 4 7 13

Now suppose another recursive call needs:
calculate(5)

Java checks:
if (memo[5] != 0)

Since
memo[5] = 7

it immediately executes:
return memo[5];

It does not recurse into calculate(4), calculate(3), and calculate(2) again

**********************
 */

