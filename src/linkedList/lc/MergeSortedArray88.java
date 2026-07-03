package linkedList.lc;

/*
BASIC
No. 1

Problem:
Merge Sorted Array

Pattern:
Two Pointers (From End)

Status:
✅ Solved


LeetCode:

88 (Merge Sorted Array)

Input:

nums1 = [1,2,3,0,0,0]
m = 3

nums2 = [2,5,6]
n = 3

Output:

[1,2,2,3,5,6]

Explanation:

Start from the end of both arrays

Compare larger values

Place larger value at the end of nums1

Move corresponding pointer

Repeat until nums2 is empty
*/

public class MergeSortedArray88 {

    public static void merge(int[] nums1, int m,
                             int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {

                nums1[k] = nums1[i];
                i--;

            } else {

                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        while (j >= 0) {

            nums1[k] = nums2[j];

            j--;
            k--;
        }
    }

    public static void print(int[] nums) {

        for (int num : nums) {

            System.out.print(num + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;

        int[] nums2 = {2, 5, 6};
        int n = 3;

        System.out.println("Before Merge:");

        print(nums1);

        merge(nums1, m, nums2, n);

        System.out.println("After Merge:");

        print(nums1);
    }
}

/*
concept:

m = Number of valid elements in nums1
n = Number of elements in nums2

nums1
[1,2,3,0,0,0]

does NOT mean there are six numbers.
Only the first 3 numbers are valid.
1
2
3

Think like this:

nums1
[1][2][3][ ][ ][ ]

Those zeros are just placeholders.
They are not part of the sorted array.

nums2
[2][5][6]

Now we must put these numbers into the empty spaces.

Final should become
[1][2][2][3][5][6]

******************************

Why don't we compare from the front?

Suppose we start at index 0.

nums1
[1][2][3][ ][ ][ ]

nums2
[2][5][6]

Compare
1
2

Now where do we put
2

If we insert it,
1 2 2 3

But
3

must move.
Then
5
Then
6

Everything keeps shifting.
Very slow.

Instead,
start from the end.
Empty spaces are already there.

[1][2][3][ ][ ][ ]
          ↑

So we fill them from right to left.
Nothing needs to move.

****************************
Pattern:

Pointer i = Last valid element of nums1
            ↓
Pointer j = Last element of nums2
            ↓
Pointer k = Last position of nums1
            ↓
Compare nums1[i] and nums2[j]
            ↓
Place larger value at nums1[k]
            ↓
Move corresponding pointer
            ↓
Repeat until nums2 is empty

simple terms:
Compare i and j
↓
Put the larger value at k
↓
Move that pointer
↓
Move k
↓
Repeat

***********************
These three pointers

int i = m - 1;
int j = n - 1;
int k = m + n - 1;

1) i= 3-1 = 2
Index
0 1 2

So

i
↓
3

Visual
nums1

[1][2][3][ ][ ][ ]
        ↑
        i
i always points to the last valid number in nums1.

**************************

2) j = n - 1;
J = 3-1 = 2;

nums2

[2][5][6]
        ↑
        j
j points to the last number of nums2.

**************************

3) k = m + n -1;
k = 3+3-1 = 5

nums1

[1][2][3][ ][ ][ ]
                 ↑
                 k
k points to the last empty position.

*************************

Now compare

Current
nums1
[1][2][3][ ][ ][ ]
        ↑
        i

nums2
[2][5][6]
        ↑
        j

k
 ↓
Last position

***********************
now Compare

3 & 6
Who is bigger?
6

So
nums1[k] = nums2[j];

Before
[1][2][3][ ][ ][ ]

After
[1][2][3][ ][ ][6]

Move
j--
k--

Now
nums2

[2][5][6]
     ↑
     j

nums1
[1][2][3][ ][ ][6]
              ↑
              k

********************
Next compare

3 & 5

Bigger
5

Put
[1][2][3][ ][5][6]

Move
j--
k--

*******************
Next compare

3 & 2

Now
3

is bigger.
Put
[1][2][3][3][5][6]

Move
i--
k--

Continue until finished.

****************

Why only this loop?
while (j >= 0)

Why not
while(i>=0)

Because if nums2 finishes first, the remaining values in nums1 are already in the correct place.

*******************
Example:

nums1
[1][2][3][ ][ ][ ]

nums2
[0][1][2]

Suppose after merging,

only
1
2
3

remain in nums1.
They are already at the front.

No work needed.

But if nums1 finishes first,
we still have numbers left in nums2.

Those must be copied.
That's why only

while (j >= 0)
is needed.

******************
Doubt about those empty box [] is empty or [0] contain ?

Actual that empty placeholder is

Before
[1][2][3][0][0][0]

After
[1][2][3][0][5][6]

the placeholder zeros are overwritten.


*************
second doubt why second while j only

Case 1

nums1
[1][2][3][0][0][0]

nums2
[4][5][6]

Merge starts.

Eventually
nums1
[1][2][3][4][5][6]

At the end
i = -1
j = -1

Everything finished.
No second loop needed.

so,
while (j >= 0)
doesn't run.

********************
Case 2
Suppose

nums1
[4][5][6][0][0][0]

nums2
[1][2][3]


Compare
6 vs 3 → put 6
[4][5][6][0][0][6]

Compare
5 vs 3 → put 5
[4][5][6][0][5][6]

Compare
4 vs 3 → put 4
[4][5][6][4][5][6]

Now
i = -1

because all valid elements of nums1 are used.
But
j = 2
still points to 3.

We still have
3
2
1

left in nums2.
So the second loop runs.
while (j >= 0)

Copy
3
[4][3][4][5][6]

Copy
2
[2][3][4][5][6]

Copy
1
[1][2][3][4][5][6]

Done.
*******************

 */