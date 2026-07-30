package Recursion.lc;

import java.util.ArrayList;
import java.util.List;

/*
LEETCODE
No. 13

Problem:
Subsets

Pattern:
Recursion + Backtracking

Status:
✅ Solved

LeetCode:
78 (Subsets)

Input:
nums = [1,2,3]

Output:
[
[],
[1],
[2],
[3],
[1,2],
[1,3],
[2,3],
[1,2,3]
]

Explanation:

A subset is any combination of elements.

For every number, we have two choices:

1. Include it.
2. Exclude it.

When we reach the end of the array,
store the current subset.

Number of Subsets:

2^n

Examples:

[1]

[]
[1]

----------------

[1,2]

[]
[1]
[2]
[1,2]
*/

public class Subsets78 {

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private static void backtrack(int[] nums,
                                  int index,
                                  List<Integer> current,
                                  List<List<Integer>> result) {

        // Base Case
        if (index == nums.length) {

            result.add(new ArrayList<>(current));

            return;
        }

        // Include current element
        current.add(nums[index]);

        backtrack(nums, index + 1, current, result);

        // Backtrack
        current.remove(current.size() - 1);

        // Exclude current element
        backtrack(nums, index + 1, current, result);
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3};

        System.out.println(subsets(nums));
    }
}

/*

subsets function:

List<List<Integer>> result = new ArrayList<>();
result = []
Not
result = [[]]

backtrack(nums, 0, new ArrayList<>(), result);
nums = [1,2,3]
index = 0
current = []
result = []
so,
backtrack([1,2,3], 0, [], [])

********************************
backtrack function

i) Base Case
if(index==nums.length)
0==3 ?
No
Continue.

ii) Include current element
current.add(nums[index]);
index is 0
so nums[0] = 1

iii) backtrack(nums, index + 1, current, result);
backtrack([1,2,3],1,[1],[]) now call it again

same like recursive again base check and current add and index add one
final is current [1,2,3] and add that in result and return it

ok we got the first subset only but how the other subset works
this [1, 2], [1, 3], [1], [2, 3], [2], [3], [] we find it first one as of now
this is result: [[1, 2, 3], [1, 2], [1, 3], [1], [2, 3], [2], [3], []]

**************************
current.remove(current.size()-1);
Current = [1,2,3]
Remove last element = 3
now
current = [1,2]

**************************
then exclude

Index : 0 1 2
Nums  : 1 2 3
index is = 2 + 1 = 3

backtrack(nums, index + 1, current, result);
backtrack([1,2,3], 3, [1,2], [[1, 2, 3]])
then this run

*****************
visual every time recursive how result add

1) result
[
    [1,2,3],
    [1,2]
]

2) result
[
 [1,2,3],
 [1,2],
 [1,3]
]

3) result

[
 [1,2,3],
 [1,2],
 [1,3],
 [1]
]

like
final is
Final Result
[
 [1,2,3],
 [1,2],
 [1,3],
 [1],
 [2,3],
 [2],
 [3],
 []
]

***********************
✅Creates a new copy and stores that copy.
result.add(new ArrayList<>(current));

result.add(current);
❌ Adds the same List object.

For example

current = [1,2,3]
result.add(new ArrayList<>(current));

current
   │
   ▼
+-----------+
| 1 | 2 | 3 |
+-----------+

result
│
▼
+-----------+
| 1 | 2 | 3 |
+-----------+   ← NEW COPY

Now suppose backtracking removes 3.
current.remove(current.size()-1);

Current becomes
current
[1,2]

But the copy inside result does not change.
result

[
   [1,2,3]
]

Because it is a different object.

*******************************
Case 2 (Wrong)

Suppose we write
result.add(current);

Now Java does not make a copy.
It stores the same object.

Memory looks like this.

                +-----------+
current ───────▶| 1 | 2 | 3 |
                +-----------+
                     ▲
                     │
result ──────────────┘

Notice something.

There is only ONE list.
Both variables point to the same list.

Now backtracking executes
current.remove(current.size()-1);

Current becomes
[1,2]

Since result is pointing to the same list...
It also becomes

[
   [1,2]
]

😲 We lost [1,2,3].

Backtracking removes again.
current
[1]

Now result becomes
[
   [1]
]

Remove again.
current
[]

Result becomes
[
   []
]
*****************************
 */