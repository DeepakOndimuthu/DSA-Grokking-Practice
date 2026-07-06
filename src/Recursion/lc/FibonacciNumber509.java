package Recursion.lc;

/*
LEETCODE
No. 1

Problem:
Fibonacci Number

Pattern:
Recursion (Basic)

Status:
✅ Solved

LeetCode:
509 (Fibonacci Number)

Input:
5

Output:
5

Explanation:

The Fibonacci sequence is:

0
1
1
2
3
5
8
...

Each number is the sum of the previous two numbers.

Base Cases:

fib(0) = 0
fib(1) = 1

For all other numbers:

fib(n) = fib(n - 1) + fib(n - 2)
*/

public class FibonacciNumber509 {

    public static int fib(int n) {

        // Base Cases
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        // Recursive Calls
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println(fib(n));
    }
}

/*
Sum ask,
Find the Fibonacci number at index 5?
(not index return , return index 5 value )

The indexes are
Index	Fibonacci Number
0	0
1	1
2	1
3	2
4	3
5	5
6   8

So
fib(5)
returns 5

If the input is
fib(4)
Output : 3

If the input is
fib(6)
Output: 8
 */