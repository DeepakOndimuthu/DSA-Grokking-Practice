package Recursion.basic;

/*
BASIC
No. 1

Problem: Print Numbers

Pattern:
Recursion (Basic)

Status:
✅ Solved

LeetCode Similar:

509 (Fibonacci Number) -> Uses same recursion idea
50  -> Pow(x, n)
344 -> Reverse String (can also be solved recursively)

Input:
5

Output:
1
2
3
4
5

Explanation:

Print numbers from 1 to N using recursion.

Instead of using a loop,
the function calls itself until it reaches N.
*/

public class PrintNumbers01 {

    public static void printNumbers(int current, int n) {

        // Base Case
        if (current > n) {
            return;
        }

        System.out.println(current);

        // Recursive Call
        printNumbers(current + 1, n);
    }

    public static void main(String[] args) {

        int n = 5;

        printNumbers(1, n);

    }

}

/*
printNumbers(1,5)

prints 1
↓

printNumbers(2,5)

prints 2
↓

printNumbers(3,5)

prints 3
↓

printNumbers(4,5)

prints 4
↓

printNumbers(5,5)

prints 5
↓

printNumbers(6,5)

6 > 5

return
 */