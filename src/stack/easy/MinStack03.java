package stack.easy;

import java.util.Stack;

/*
MEDIUM
No. 3

Problem: Min Stack
Pattern: Stack (Design)

Status: ✅ Solved

LeetCode:
155 (Min Stack)

Input:
push(5), push(2), push(10), push(1)

Output:
getMin() → 1

Explanation:
Use one stack for values.
Use another stack to track minimum.
*/

public class MinStack03 {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack03() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {

        stack.push(val);

        // push to minStack if empty or smaller
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {

        int removed = stack.pop();

        // remove from minStack if needed
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {

        MinStack03 obj = new MinStack03();

        obj.push(5);
        obj.push(2);
        obj.push(10);
        obj.push(1);

        System.out.println(obj.getMin()); // 1

        obj.pop();

        System.out.println(obj.getMin()); // 2
    }
}

/*

program flow
🔹 Full flow summary

Order is:

Constructor → create stacks
push() → add values
getMin() → print min
pop() → remove top
getMin() → print new min

*************************

🔹 1. What is .peek()?
minStack.peek()

Means:
See top element
DO NOT remove it

Example:
minStack = [5, 2]
minStack.peek() → 2

Stack remains same:
[5, 2]

peek() - see top only
pop() - remove top

**************************
🔹 2. What is this problem?

We need a stack that can do:

push(x)
pop()
top()
getMin() → return minimum element

And all operations should be fast (O(1))

**************************
🔹 3. Why normal stack not enough?

Example:
stack = [5, 2, 10, 1]
Minimum = 1

If we remove 1:
stack = [5, 2, 10]

Now min = 2
❗ Problem:

If we use only one stack → need to scan full stack → slow ❌

****************************

🔹 4. Solution Idea

Use 2 stacks

1) stack → store all values
2) minStack → store only minimum values

********************
DRY CODE:
Push sequence: 5, 2, 10, 1

Step 1: push(5)
stack    = [5]
minStack = [5]

Step 2: push(2)
2 <= 5 → true
stack    = [5, 2]
minStack = [5, 2]

Step 3: push(10)
10 <= 2 → false
stack    = [5, 2, 10]
minStack = [5, 2]

Step 4: push(1)
1 <= 2 → true
stack    = [5, 2, 10, 1]
minStack = [5, 2, 1]

**************************
🔹 4. Then this line runs
first sop next call the pop
obj.pop();
stack = [5, 2, 10, 1]

Step 1:
int removed = stack.pop();
Remove top from main stack

After:
removed = 1
stack = [5, 2, 10]

Step 2: Check this
if (removed == minStack.peek())

Before:
minStack = [5, 2, 1]
peek = 1
👉 So:
removed = 1
peek = 1
👉 Condition TRUE ✅

minStack.pop();

👉 Remove from minStack also
After:
minStack = [5, 2]
so second sop time call the min output is
getMin() → 2 ✅ correct

**************

🔹 6. What about top()?
This function:
Returns last element
Does NOT remove

Example:
After pop:
stack = [5, 2, 10]
obj.top() → 10

****************

 */