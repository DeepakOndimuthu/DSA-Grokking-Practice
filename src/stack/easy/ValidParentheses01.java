package stack.easy;

import java.util.Stack;

/*
EASY
No. 1

Problem: Valid Parentheses
Pattern: Stack (LIFO)

Status: ✅ Solved

LeetCode:
20 (Valid Parentheses)

Input:
s = "()[]{}"

Output:
true

Explanation:
Push opening brackets into stack.
When closing bracket comes → check top of stack.
If matching → pop.
If not → invalid.
*/

public class ValidParentheses01 {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // closing brackets
            else {

                // if stack empty → invalid
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // check matching
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {

                    return false;
                }
            }
        }

        // if stack empty → valid
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s = "()[]{}";

        System.out.println(isValid(s)); // true
    }
}

/*

Stack
Stack = Plate stack in hotel
You put plate → top
You remove plate → top

Rule:
LIFO = Last In First Out

Stack Operations
push() → add element to top
pop() → remove element from top
peek() → see top element
isEmpty() → check empty or not

***********
Problem

"()[]{}" → check valid or not

This is about:
➡️ Order + matching

Example:

( must close with )
{ must close with }
[ must close with ]

Last opened must close first → LIFO → Stack perfect

*****************
Dry Run
Step	Char	Stack	Action
1	     (	     (	    push
2	     )	    empty	pop + match
3	     [	     [	    push
4	     ]	    empty	pop + match
5	     {	     {	    push
6	     }	    empty	pop + match

*****************
🔹Step 1: First character (
stack = [ ( ] first add (push) it

🔹Step 2: Next character )

Check 1: Stack empty?
if (stack.isEmpty())
Stack is NOT empty → so skip ❌

Check 2: char top = stack.pop();
Take the top element AND remove it from stack
So here:
stack = [ ( ]

After pop():
top = '('
stack = [ ]   (empty now)

🔹 Step 3: Matching check
if ((ch == ')' && top != '('))
ch == ')' -> Current character is closing bracket )
top != '(' -> The last opening bracket should be ( -> If NOT → mismatch

final
return stack.isEmpty();
input: ()[]{}
All matched → stack becomes empty
stack = [ ]
So: its return true

*************************

🔹 Why we check this?
Because:
Closing	Expected opening
)	       (
}	       {
]	       [

🔹 Example 1 (Correct)
top = '('
ch = ')'
top == '(' → correct
Condition becomes FALSE
So NOT returning false → continue

🔹 Example 2 (Wrong)
top = '['
ch = ')'

Check:
(ch == ')' && top != '(')

top != '(' → TRUE
Condition TRUE → return false ❌

***************

this else part if matching time :
ch == ')'
ch is )
So this is TRUE ✅

easy understand of second close bracket time ( :
'(' != '(' - means “Is ( NOT equal to ( ?”
Answer: FALSE ❌ (because both are same)
that second close bracket time

(TRUE && FALSE)
Result = FALSE

if (FALSE)
👉 So it will NOT go inside if block
👉 So it will NOT return false
👉 So this is VALID match ✅

******************

 */