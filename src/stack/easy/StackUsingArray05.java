package stack.easy;

/*
BASIC
No. 5

Problem: Stack using Array
Pattern: Stack Implementation

Status: ✅ Solved

Input:
push(10)
push(20)
push(30)

Output:
30
20

Explanation:
Stack follows LIFO
(Last In First Out)

Last inserted element
comes out first.
*/

public class StackUsingArray05 {

    int[] stack;
    int top;
    int size;

    // constructor
    public StackUsingArray05(int size) {

        this.size = size;

        stack = new int[size];

        top = -1;
    }

    // push
    public void push(int value) {

        // stack full
        if (top == size - 1) {
            System.out.println("Stack Overflow");
            return;
        }

        top++;

        stack[top] = value;

        System.out.println(value + " pushed");
    }

    // pop
    public int pop() {

        // stack empty
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int removed = stack[top];

        top--;

        return removed;
    }

    // peek
    public int peek() {

        if (top == -1) {
            System.out.println("Stack Empty");
            return -1;
        }

        return stack[top];
    }

    // isEmpty
    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {

        StackUsingArray05 stack = new StackUsingArray05(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop()); // 30

        System.out.println(stack.peek()); // 20
    }
}

/*

Dry Run

Initial:
stack = [0,0,0,0,0]
top = -1

push(10)
top++ → 0
stack[0] = 10

Now:
[10,0,0,0,0]
top = 0

push(20)
top++ → 1
stack[1] = 20

Now:
[10,20,0,0,0]
top = 1

push(30)
top++ → 2
stack[2] = 30

Now:
[10,20,30,0,0]
top = 2

pop()
removed = stack[2]

removed:30

Then:
top-- → 1
Now top is: 20

peek()
stack[top]

means:
stack[1]

returns:20

 */