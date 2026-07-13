package Recursion.basic;

/*
BASIC
No. 3

Problem:
Fibonacci

Pattern:
Recursion (Basic)

Status:
✅ Solved

LeetCode Similar:

509 (Fibonacci Number)

70 (Climbing Stairs)

1137 – (N-th Tribonacci Number (Extension of Fibonacci))

Input:
5

Output:
5

Explanation:

Fibonacci sequence:

0 1 1 2 3 5 8 13 ...

Each number is the sum of the previous two numbers.

F(5) = 5
*/

public class Fibonacci03 {

    public static int fibonacci(int n) {

        // Base Case
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        // Recursive Calls
        return fibonacci(n - 1) + fibonacci(n - 2);

    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println(fibonacci(n));

    }

}

/*
Explaination is LC section
 */