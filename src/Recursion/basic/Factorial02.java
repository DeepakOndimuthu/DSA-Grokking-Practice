package Recursion.basic;

/*
BASIC
No. 2

Problem:
Factorial

Pattern:
Recursion (Basic)

Status:
✅ Solved

LeetCode Similar:

509 (Fibonacci Number)

50 (Pow(x, n))

70 (Climbing Stairs (can also be solved using recursion))

Input:
5

Output:
120

Explanation:

Factorial means multiplying all numbers
from 1 to N.

5! = 5 × 4 × 3 × 2 × 1 = 120
*/

public class Factorial02 {

    public static int factorial(int n) {

        // Base Case
        if (n == 0 || n == 1) {
            return 1;
        }

        // Recursive Call
        return n * factorial(n - 1);

    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println(factorial(n));

    }

}

/*
Dry Run:

factorial(5)
and check the base case its false so go to recursive call

return 5 * factorial(4);

step1:
factorial(4) - So it waits.

step2:
factorial(3) - So it waits.

step3:
factorial(3) - So it waits.

step4:
factorial(2) - So it waits.

step5:
factorial(1) - So it waits.


Now
if (n == 0 || n == 1)

Yes!
Execute
return 1;
Function ends.

**************************

Now we come BACK
We return to

1) factorial(2) -  Remember it was waiting here
return 2 * factorial(1);
Now
factorial(1) = 1
So Java changes it to
return 2 * 1;
Result
2
Return
2

2) factorial(3)
return 3 * factorial(2);
Now
factorial(2) = 2
return 3 * 2;
Result
6
Return
6

3) factorial(4)
return 4 * factorial(3);
Now
factorial(3) = 6
return 4 * 6;
Result
24
Return
24

4) factorial(5)
return 5 * factorial(4);
Now
factorial(4) = 24
return 5 * 24;
Result
120
Return
120

5) factorial(3)
return 3 * factorial(2);
Now
factorial(2) = 2
return 3 * 2;
Result
6
Return
6
**********************
 */