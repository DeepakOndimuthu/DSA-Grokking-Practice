package linkedList.lc;

/*
BASIC
No. 10

Problem:
Happy Number

Pattern:
Slow Pointer + Fast Pointer (Cycle Detection)

Status:
✅ Solved


LeetCode:
202 (Happy Number)

Input:
19

Output:
true


Explanation:

Replace number with the sum of squares of its digits

Slow moves one step

Fast moves two steps

If fast reaches 1

Number is Happy

If slow and fast meet

A cycle exists

Number is Not Happy
*/

public class HappyNumber202 {

    public static int getNext(int n) {

        int sum = 0;

        while (n > 0) {

            int digit = n % 10;

            sum += digit * digit;

            n /= 10;
        }

        return sum;
    }

    public static boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        do {

            slow = getNext(slow);

            fast = getNext(getNext(fast));

        } while (slow != fast);

        return slow == 1;
    }

    public static void main(String[] args) {

        int n = 19;

        System.out.println(isHappy(n));
    }
}

/*
Example 1
Input:
19

Process:
19
↓
1² + 9²
↓
1 + 81
↓
82
↓
8² + 2²
↓
64 + 4
↓
68
↓
6² + 8²
↓
36 + 64
↓
100
↓
1² + 0² + 0²
↓
1

Since it reaches:
1

Answer:
true
If not Happy

*****************************
Example:
2

It becomes:
2
↓
4
↓
16
↓
37
↓
58
↓
89
↓
145
↓
42
↓
20
↓
4

Notice:
4

comes again.
It entered a cycle.

So:
false

**********************
getNext function explain:
int digit = n % 10; - This gets the last digit.

First: Loop one
Example:
19 % 10
=
9
So

digit = 9

second:
sum += digit * digit;
sum = sum + (digit × digit)

current:
sum = 0
digit = 9

So
sum = 0 + 81= 81

Third:
n /= 10;
n = n / 10;
n = 19 / 10 = 1

loop Second
Now
n = 1

Again
digit = n % 10;
1 % 10 = 1

Square
1 × 1 = 1

Add
81 + 1 = 82

Remove digit
1 / 10 = 0

Now
n = 0

Loop stops.
******************************
Why do-while?

Suppose we used while initially
slow = 19
fast = 19
Already equal.
Condition: 19 != 19
false

Loop never runs! Wrong.
We need at least one calculation. so do-while
A do-while loop always executes once before checking the condition

*****************************
isHappy function First loop

slow = getNext(slow);
19
↓
82

slow = 82

fast = getNext(getNext(fast));

Two steps:
getNext(
    getNext(fast)
)

First we get - 82
second time - 68

fast = 68

while(slow != fast)
Is
82 != 68

Yes.
Loop again.

**************************
For a Happy Number:

slow = 1
fast = 1

Condition
1 != 1
false

Loop stops.

Return
return slow == 1;
Is
1 == 1
true

******************

if NOT Happy
Example
2

Eventually
slow = 20
fast = 20

They meet.
Loop stops.

Now
return slow == 1;
Is
20 == 1
false

Return
false

***************************
Remainder:

Example 1
19 % 10

Divide:
10 ) 19

10 × 1 = 10
19 - 10 = 9

Remainder:9

So:
19 % 10 = 9

*************
Example 2
1 % 10

Can 10 go into 1?
10 ) 1

10 × 0 = 0

Subtract:
1 - 0 = 1

Remainder:1

So:
1 % 10 = 1

Even though 1 is smaller than 10, the remainder is the number itself.

**************
More Examples
7 % 10 = 7
25 % 10 = 5
123 % 10 = 3

**********************

 */
