package Recursion.lc;

public class PowXN50Method1 {

    public static double myPow(double x, int n) {

        long power = n;

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        return calculate(x, power);
    }

    public static double calculate(double x, long n) {

        // Base Case
        if (n == 0) {
            return 1;
        }

        double half = calculate(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        }

        return x * half * half;
    }

    public static void main(String[] args) {

        double x = 2.0;
        int n = 10;

        System.out.println(myPow(x, n));
    }
}

/*
LeetCode also tests negative powers

old one:
so,
myPow(2.0, -2)

myPow(2, -2)

return 2 * myPow(2, -3)
return 2 * myPow(2, -4)
return 2 * myPow(2, -5)
return 2 * myPow(2, -6)
...
n becomes:
-2
-3
-4
-5
-6
...

It is moving away from 0, not toward it.
So this condition is never true:

if (n == 0) {
    return 1;
}

The recursion never stops.
so why this method

old solution only works for:
n >= 0

******************************
How are negative powers handled?

In mathematics,

2^-1 = 1/2 = 0.5
2^-2 = 1/(2×2) = 0.25
2^-3 = 1/(2×2×2) = 0.125

So for negative powers, we use:
x^-n = 1 / x^n

For example,
2^-3
=1 / 2^3

=1 / 8

=0.125

**********************

DRY CODE

x = 2
n = 10

Step1

long power = n;
power = 10

so this if block not run
if (power < 0) {

call this return calculate(x, power);
calculate(2, 10)

***********************
Step 2:

double half = calculate(x, n / 2);
n / 2 => 10 / 2 => 5
Now it calls
i) calculate(2,5)

Again
5 / 2 = 2
calls
ii) calculate(2,2)

Again
2 / 2 = 1
calls
iii) calculate(2,1)

Again
1 / 2 = 0
calls
iv) calculate(2,0)

Base case
if(n==0)
    return 1;

returns
1

****************
The recursion tree

calculate(2,10)
        |
calculate(2,5)
        |
calculate(2,2)
        |
calculate(2,1)
        |
calculate(2,0)

Only 5 recursive calls.

********************

Now recursion comes back
calculate(2,1)

We already know
half = 1

Now
if(n % 2== 0)
1  % 2 => 1
return x * half * half;
2 × 1 × 1 => 2


calculate(2,2)
Now
half = 2

Check
2 % 2 => 0

Even number.
So
return half * half;
becomes
2 × 2 => 4

calculate(2,5)
Now
half = 4

Check
5 % 2 => 1
Odd.
So
2 × 4 × 4 => 32

calculate(2,10)
Now
half = 32

Check
10 % 2 => 0

Even.
So
32 × 32 => 1024

Done!

*********************
How program works / function calls:

myPow(2,10)
↓
calculate(2,10)
    waiting
↓
calculate(2,5)
    waiting
↓
calculate(2,2)
    waiting
↓
calculate(2,1)
    waiting
↓
calculate(2,0)

Notice:
During this time,
if (n % 2 == 0)

does NOT execute yet.
Everyone is waiting for half.

***********************************
Base case
Now
calculate(2,0)
runs

if (n == 0)
    return 1;
So

calculate(2,0)
is finished forever.
It will never execute again.
It returns
1

*************
Coming BACK

Now Java goes back to the paused function.
calculate(2,1)

Now
double half = 1;

NOW Java executes
if (n % 2 == 0)

It was waiting until now.
Since

1 % 2 = 1
it executes

return x * half * half;
returns
2

***********************
Now
calculate(2,1)

is also finished forever.
It will never execute again.

Now Java goes back again.
calculate(2,2)

Now
double half = 2;
NOW it executes
if (n % 2 == 0)

Since
2 % 2 = 0

it returns
4
******************************
Then
calculate(2,5)

gets
half = 4
Runs its if.

Returns
32
Then
**********************
calculate(2,10)

gets
half = 32
Runs its if.

Returns
1024

**********************
So the complete order is
DOWN

calculate(2,10)
calculate(2,5)
calculate(2,2)
calculate(2,1)
calculate(2,0)

----------------

UP

calculate(2,0)
return 1
(finished forever)

↓

calculate(2,1)
half = 1
if...
return 2
(finished forever)

↓

calculate(2,2)
half = 2
if...
return 4
(finished forever)

↓

calculate(2,5)
half = 4
if...
return 32
(finished forever)

↓

calculate(2,10)
half = 32
if...
return 1024
(finished forever)

↓

myPow()
return 1024

**************************
concept confuse time
"After calculate(2,0) returns 1, do we run calculate(2,0) again?"
❌ No. Never.
calculate(2,0) is completely finished.
It returns 1 once.

After that, Java goes back to the paused calculate(2,1) and continues from the line after:
double half = calculate(x, n / 2);

**********************************
This if part is only for negative powers.
power = -power;

x = 2
n = -3

maths
2^-3 => 1 / 2^3
=> 1 / 8 => 0.125

So Java changes the values before recursion starts.

so initially check
-3 < 0
execute
x = 1 / x;
x = 1 / 2 => 0.5

power = -power; [power = -(-3)]
power = 3

Now recursion starts.
calculate(0.5, 3)
0.5^3
0.5 × 0.5 × 0.5 => 0.125

*******************
Suppose we do only power we got answer
2^3 => 8
this result is ❌ Wrong!
2^-3 correct answer is 0.125
so why we change the x = 1/2 , x too

***********************


 */