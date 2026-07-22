package Recursion.lc;

/*
LEETCODE
No. 9

Problem:
Range Sum Query - Immutable

Pattern:
Recursion (Array)

Status:
✅ Solved

LeetCode:
303 (Range Sum Query - Immutable)

Input:
nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2)

Output:
1

Explanation:

Find the sum of array elements
between the left index and right index.

For:

left = 0
right = 2

Values:

-2 + 0 + 3 = 1

Use recursion to move from
the left index to the right index.

Base Case:

When left is greater than right,

return 0.
*/

public class RangeSumQueryImmutable303 {

    private int[] nums;

    public RangeSumQueryImmutable303(int[] nums) {

        this.nums = nums;
    }

    public int sumRange(int left, int right) {

        // Base Case
        if (left > right) {
            return 0;
        }

        // Recursive Call
        return nums[left] + sumRange(left + 1, right);
    }

    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};

        RangeSumQueryImmutable303 obj =
                new RangeSumQueryImmutable303(nums);

        System.out.println(obj.sumRange(0, 2));
    }
}

/*

For sumRange(0, 2), the recursive flow is:

sumRange(0, 2)
1) return -2 + sumRange(1, 2);  // waiting
↓
2) return 0 + sumRange(2, 2);   // waiting
↓
3) return 3 + sumRange(3, 2);   // waiting

4) Base case
left = 3
right = 2

3 > 2 → true
return 0

**********************
Coming back:

1) sumRange(3, 2) returns 0
↓
3 + 0 = 3

2) sumRange(2, 2) returns 3
↓
0 + 3 = 3

3) sumRange(1, 2) returns 3
↓
-2 + 3 = 1

Final:
sumRange(0, 2) returns 1

**********************
Important point:

go to basic folder sumOfArray05 problem and important point logic is
here also works that waiting to java run time

*************************
LeetCode 303 is designed differently. It asks us to create an object that stores the array.
so why we use obj creation in this problem

private int[] nums;

    public RangeSumQueryImmutable303(int[] nums) {
        this.nums = nums;
    }


Not simple use like public static int sumRange(int[] nums,

**************************

Here, sumRange() is inside the class, but it is outside the constructor.
how obj.sumRange(0, 2) call works,

CLASS
│
├── variable: nums
│
├── constructor
│
└── method: sumRange()


1) RangeSumQueryImmutable303 obj =
        new RangeSumQueryImmutable303(nums);

Java creates an object:
obj
│
├── nums = [-2, 0, 3, -5, 2, -1]
│
└── can use sumRange()

The constructor saves the array here:
this.nums = nums;

Now obj remembers that array.

**************************************

So later:

obj.sumRange(0, 2)

means:
Use the sumRange() method belonging to obj.

Because obj already has the array stored, we don't need to pass nums again.

So we can call many times:
obj.sumRange(0, 2);
obj.sumRange(2, 5);
obj.sumRange(0, 5);

***************************
Visual
1) obj is a RangeSumQueryImmutable303 object
2) And the class definition says every object of this class has access to its non-static methods:

RangeSumQueryImmutable303 CLASS
│
├── Field
│   └── nums
│
├── Constructor
│   └── RangeSumQueryImmutable303(...)
│
└── Method
    └── sumRange(...)

**************************************

concept of obj call the method

So:
obj.sumRange(0, 2);

means:
"Hey obj, run your sumRange() method."

Because obj was created from:
RangeSumQueryImmutable303

**********************************

 */
