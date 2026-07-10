package Recursion.lc;

public class ClimbingStairs70Method1 {

    static int[] memo;

    public static int climbStairs(int n) {

        memo = new int[n + 1]; // Java creates an array.
        return climb(n);
    }

    public static int climb(int n) {

        // Base Cases
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        // Already Calculated
        if (memo[n] != 0) {
            return memo[n];
        }

        // Store Answer
        memo[n] = climb(n - 1) + climb(n - 2);

        return memo[n];
    }

    public static void main(String[] args) {

        int n = 40;

        System.out.println(climbStairs(n));
    }
}

/*
This method has only two places that vary the basics
basic is tell time exceed in leetcode so why this code

n = 5
memo = new int[6];
n + 1 = 5 + 1 = 6

Initially Java fills it with zeros.

Index : 0 1 2 3 4 5

Value : 0 0 0 0 0 0

************************

climb(3)
is called for the first time.

Array
0 0 0 0 0 0

Check
if(memo[3] != 0)

It is
0

So
0 != 0
False.

Java says
"I don't have the answer."

******************
recall same recursive again 3 is next time come time avoid
for example

suppose answer is
3

Then
memo[3] = 3;

Array becomes

Index
0 1 2 3 4 5

Value
0 0 0 3 0 0

*********************
Later...

Another recursion again calls

climb(3)

Now Java checks

if(memo[3] != 0)
This time

memo[3] = 3

So
3 != 0
True.

Now Java immediately executes
return memo[3];

which is
return 3;

It does not calculate again.

**************************
why this concept,
Think of memo as a notebook 📒
Without notebook

Teacher:
What's 5 × 5?

You:
25

Teacher asks again after 5 minutes.
You calculate again. No. that's concept we use.

*************************
ok n=40 means
answer is 165580141

You climb 40 steps
It means:
"There are 165,580,141 different ways to reach step 40."

*******************
Think of it like Google Maps.

Suppose you want to go from your home to your office.

There might be:

Road A
Road B
Road C

Now imagine there are 165 million different routes.

You still travel only once.

But there are 165 million possible ways to travel.

The Climbing Stairs problem is asking:

"How many different ways (paths) can you reach the top?"

Not:

"How many steps do you climb?"

********************************

 */
