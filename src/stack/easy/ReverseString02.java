package stack.easy;

import java.util.Stack;

/*
EASY
No. 2

Problem: Reverse String using Stack
Pattern: Stack (LIFO)

Status: ✅ Solved

LeetCode:
344 (Reverse String)

Input:
s = "hello"

Output:
"olleh"

Explanation:
Push all characters into stack.
Pop them → reverse order comes.
*/

public class ReverseString02 {

    public static String reverse(String s) {

        Stack<Character> stack = new Stack<>();

        // push all characters
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        // build reversed string
        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s = "hello";

        System.out.println(reverse(s)); // olleh
    }
}

/*

1. First part
stack.push(s.charAt(i));
After pushing:
stack = [h, e, l, l, o]

Top of stack = o (last inserted)

2. What is StringBuilder?
StringBuilder result = new StringBuilder();
It is like an empty box
We can add characters one by one
result = ""

3. What is pop()?
pop() = take top element + remove it

4.What is append()?
Add character to result
result.append('o');
result = "o"

Inserted → h e l l o
Removed → o l l e h

🔹 6. Simple idea

Push → normal order
Pop → reverse order

******************

stack.isEmpty()
Returns:
true → stack is empty
false → stack has elements

!stack.isEmpty()
! = NOT (reverse the result)

Original	After !
true		false
false		true

why !
We want to keep popping until stack becomes empty

Initial:

stack = [h, e, l, l, o]
Iteration 1:
stack.isEmpty() → false
!false → true ✅
loop runs

Iteration 2,3,4,5:
Same → loop runs

Final:
stack = []

Now:
stack.isEmpty() → true
!true → false ❌

loop stops

Simple memory trick
isEmpty() → “empty?”
!isEmpty() → “not empty?”

************

DRY RUN

Initial:

stack = [h, e, l, l, o]
result = ""

Step 1:
pop() → o
append → result = "o"
stack = [h, e, l, l]

Step 2:
pop() → l
append → result = "ol"
stack = [h, e, l]

Step 3:
pop() → l
append → result = "oll"
stack = [h, e]

Step 4:
pop() → e
append → result = "olle"
stack = [h]

Step 5:
pop() → h
append → result = "olleh"
stack = []

 */
