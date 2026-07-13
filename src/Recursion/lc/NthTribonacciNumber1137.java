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

public class NthTribonacciNumber1137 {

    public static int tribonacci(int n) {

        // Base Cases
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        // Recursive Calls
        return tribonacci(n - 1)
                + tribonacci(n - 2)
                + tribonacci(n - 3);
    }

    public static void main(String[] args) {

        int n = 4;

        System.out.println(tribonacci(n));
    }
}

/*
concept:

Each number is the sum of the previous three numbers.

*******************

Index : 0 1 2 3 4 5 6  7  8

Value : 0 1 1 2 4 7 13 24 44

**********************

Dry Run

n = 4

Recursion:

1) function start time
tribonacci(4)
=
tribonacci(3)
+
tribonacci(2)
+
tribonacci(1)

2) Now
tribonacci(3)
=
tribonacci(2)
+
tribonacci(1)
+
tribonacci(0)

*********************
3) Base Cases
tribonacci(2) = 1

tribonacci(1) = 1

tribonacci(0) = 0

***********************
so,
tribonacci(3)
= 1 + 1 + 0
= 2

tribonacci(4)
=2 + 1 + 1
=4

*****************

DRY RUN
Where/How does 4 → 3 → 2 → 1 → 0 happen?

Call 1
tribonacci(4)

Not a base case.
So execute

return tribonacci(3)
     + tribonacci(2)
     + tribonacci(1);

Java first needs
tribonacci(3)

So it jumps there.

Notice:
tribonacci(2)

and

tribonacci(1)
are waiting.

********************

Call 2
tribonacci(3)

Again not base case.
Execute

return tribonacci(2)
     + tribonacci(1)
     + tribonacci(0);

Again Java starts with

tribonacci(2)

********************

Call 3
tribonacci(2)

Base case.
return 1;

Finished.

***************

Return to
tribonacci(3)

Now Java knows

tribonacci(2) = 1
Now Java executes

tribonacci(1)

********************
Call 4
tribonacci(1)

Base case.
return 1;

Return to
tribonacci(3)

Now Java knows
tribonacci(1) = 1

Now Java executes

tribonacci(0)

******************
Call 5
tribonacci(0)

Base case.
return 0;

Return to
tribonacci(3)

Now Java knows
tribonacci(0) = 0

*****************

Now all three values are known.

tribonacci(2) = 1
tribonacci(1) = 1
tribonacci(0) = 0

tribonacci(3)
=1 + 1 + 0
=2

Return
2

*******************
Now we go back to
tribonacci(4)

Remember it was waiting here.

return tribonacci(3)
     + tribonacci(2)
     + tribonacci(1);

Now Java already knows
tribonacci(3)
=2

so,
2
+
tribonacci(2)
+
tribonacci(1)

**************
Now Java calls

tribonacci(2)
Base case
1

Then
tribonacci(1)
Base case
1

Now
2 + 1 + 1
=4
Return
4
*********************

 */