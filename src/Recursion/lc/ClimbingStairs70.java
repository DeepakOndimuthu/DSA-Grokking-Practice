package Recursion.lc;

/*
LEETCODE
No. 4

Problem:
Climbing Stairs

Pattern:
Recursion (Basic)

Status:
✅ Solved

LeetCode:
70 (Climbing Stairs)

Input:
n = 4

Output:
5

Explanation:

You can climb either:

1 step

or

2 steps

To reach the current stair,

you can come from:

One stair before

or

Two stairs before

Formula:

ways(n) = ways(n - 1) + ways(n - 2)

Base Cases:

ways(1) = 1

ways(2) = 2
*/

public class ClimbingStairs70 {

    public static int climbStairs(int n) {

        // Base Cases
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        // Recursive Calls
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {

        int n = 4;

        System.out.println(climbStairs(n));
    }
}

/*
Problem

You are climbing a staircase.

Each time you can climb:
1 step
2 steps

Find how many different ways you can reach the top.

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

*********************
 */