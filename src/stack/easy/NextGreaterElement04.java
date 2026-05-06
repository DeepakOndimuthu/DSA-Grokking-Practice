package stack.easy;

import java.util.Arrays;
import java.util.Stack;

/*
MEDIUM
No. 4

Problem: Next Greater Element
Pattern: Monotonic Stack

Status: ✅ Solved

LeetCode:
496 (Next Greater Element I)

Similar:
503 (Next Greater Element II)
739 (Daily Temperatures)

Input:
arr = [4,5,2,10]

Output:
[5,10,10,-1]

Explanation:
Find next greater element
on right side for every element.

4 -> 5
5 -> 10
2 -> 10
10 -> -1
*/

public class NextGreaterElement04 {

    public static int[] nextGreater(int[] arr) {

        int n = arr.length;

        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        // traverse from right
        for (int i = n - 1; i >= 0; i--) {

            // remove smaller elements
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // if stack empty → no greater element
            if (stack.isEmpty()) {
                result[i] = -1;
            }
            else {
                result[i] = stack.peek();
            }

            // push current element
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {4,5,2,10};

        int[] ans = nextGreater(arr);

        System.out.println(Arrays.toString(ans));
    }
}

/*

concept
Find the next greater element on right side

Input:
[4, 5, 2, 10]

Output:
[5, 10, 10, -1]

Because:
Element	Next Greater
4	 5
5	10
2	10
10	-1

***************
Why n - 1?

Array:
index: 0 1 2 3
value: 4 5 2 10

n = 4
n - 1 = 3
index 3 = last element = 10

*******************

Why start from last?

Because:
We need to find:
“next greater element on RIGHT side”

So first we process right side.

********************
DRY RUN

Input:
[4,5,2,10]

Initial:
stack = []
result = [0,0,0,0]

🔹Iteration 1
i = 3
arr[i] = 10

Stack empty

So:
result[3] = -1
Push 10:
stack = [10]

********************
🔹iteration 2
i = 2
arr[i] = 2

Check:
stack.peek() <= 2
10 <= 2 → false

So no pop

Next greater:
result[2] = 10
Push 2:
stack = [10,2]

********************
🔹Iteration 3
i = 1
arr[i] = 5

Check:
2 <= 5 → true

👉 pop 2

Now:
stack = [10]

Check again:
10 <= 5 → false

So stop
Next greater:
result[1] = 10

Push 5:
stack = [10,5]

********************
🔹Iteration 4
i = 0
arr[i] = 4

Check:
5 <= 4 → false

Next greater:
result[0] = 5

Push 4:
stack = [10,5,4]

🔹 Final result
[5,10,10,-1]

**********************
 */
