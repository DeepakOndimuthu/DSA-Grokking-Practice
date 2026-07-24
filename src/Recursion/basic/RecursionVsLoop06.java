package Recursion.basic;

/*
BASIC
No. 6

Problem:
Recursion vs Loop

Pattern:
Recursion (Basic Concept)

Status:
✅ Covered

LeetCode Similar:

509 (Fibonacci Number)

50 (Pow(x, n))

203 (Remove Linked List Elements)

Input:
5

Output:

Using Loop:
1
2
3
4
5

Using Recursion:
1
2
3
4
5

Explanation:

Loop:
Repeats code using for or while.

Recursion:
A function calls itself until
it reaches the base case.

Both can solve repeated tasks,
but recursion uses the call stack.
*/

public class RecursionVsLoop06 {

    // Using Loop
    public static void printUsingLoop(int n) {

        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }

    }

    // Using Recursion
    public static void printUsingRecursion(int current, int n) {

        // Base Case
        if (current > n) {
            return;
        }

        System.out.println(current);

        // Recursive Call
        printUsingRecursion(current + 1, n);

    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println("Using Loop:");

        printUsingLoop(n);

        System.out.println("Using Recursion:");

        printUsingRecursion(1, n);

    }

}

/*

How Loop Works

for i = 1 → print 1

for i = 2 → print 2

for i = 3 → print 3

for i = 4 → print 4

for i = 5 → print 5

i = 6 → condition false → stop

***********************************

How Recursion Works

printUsingRecursion(1, 5)
        ↓
print 1

printUsingRecursion(2, 5)
        ↓
print 2

printUsingRecursion(3, 5)
        ↓
print 3

printUsingRecursion(4, 5)
        ↓
print 4

printUsingRecursion(5, 5)
        ↓
print 5

printUsingRecursion(6, 5)
        ↓
return

*******************

 */
