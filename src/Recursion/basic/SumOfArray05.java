package Recursion.basic;

/*
BASIC
No. 5

Problem:
Sum of Array

Pattern:
Recursion (Basic)

Status:
✅ Solved

LeetCode Similar:

1480 (Running Sum of 1d Array)

303 (Range Sum Query - Immutable)

Input:
[1, 2, 3, 4, 5]

Output:
15

Explanation:

Find the sum of all array elements
using recursion.

1 + 2 + 3 + 4 + 5 = 15
*/

public class SumOfArray05 {

    public static int sumArray(int[] arr, int index) {

        // Base Case
        if (index == arr.length) {
            return 0;
        }

        // Recursive Call
        return arr[index] + sumArray(arr, index + 1);

    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(sumArray(arr, 0));

    }

}

/*

Array:  [1, 2, 3, 4, 5]

Index:   0  1  2  3  4
Value:   1  2  3  4  5

arr.length = 5

****************

Program starts

1) sumArray(arr, 0)
return arr[0] + sumArray(arr, 1);
it becomes
return 1 + sumArray(arr, 1); - waiting

2) index = 1
return 2 + sumArray(arr, 2); - waiting

3) index = 2
return 3 + sumArray(arr, 3); - waiting

4) index = 3
return 4 + sumArray(arr, 4); - waiting

5) index = 4
return 5 + sumArray(arr, 5); - waiting

6) Now Base case - sumArray(arr, 5)
5 == 5 so return 0;

**********************

Now the waiting calculations run while coming back

sumArray(arr, 5)
returns 0
↑
5 + 0 = 5
↑
4 + 5 = 9
↑
3 + 9 = 12
↑
2 + 12 = 14
↑
1 + 14 = 15

*******************

Important point:

1) sumArray(arr, 4) returns 5
Now go back to the waiting call:
return 4 + sumArray(arr, 4);
4+5 = 9

Note:
Java now replaces the completed function call with its returned answer:
sumArray(arr, 4)
        ↓
        5

*******************
visual

The connection is simply:

sumArray(arr, 4)
{
    return 5 + sumArray(arr, 5);
             ↓
             0

    return 5;
}

So whenever the waiting line sees:
sumArray(arr, 4)
it receives the returned value 5 from that function call.

*************************

Example
Exactly like:

int answer = getNumber();

If getNumber() returns 5, then it becomes:

int answer = 5;

Here the same thing happens:

4 + sumArray(arr, 4)
↓
4 + 5

***************************

Visual

GOING DOWN:

1 + sumArray(arr, 1)
    2 + sumArray(arr, 2)
        3 + sumArray(arr, 3)
            4 + sumArray(arr, 4)
                5 + sumArray(arr, 5)
                    return 0


COMING BACK:

5 + 0  = 5
4 + 5  = 9
3 + 9  = 12
2 + 12 = 14
1 + 14 = 15

***************************************
Dry Run

sumArray(arr, 0)

= 1 + sumArray(arr, 1)

= 1 + 2 + sumArray(arr, 2)

= 1 + 2 + 3 + sumArray(arr, 3)

= 1 + 2 + 3 + 4 + sumArray(arr, 4)

= 1 + 2 + 3 + 4 + 5 + sumArray(arr, 5)

index == arr.length

return 0

= 1 + 2 + 3 + 4 + 5 + 0

= 15
**********************


 */