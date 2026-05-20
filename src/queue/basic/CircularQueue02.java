package queue.basic;

/*
EASY
No. 2

Problem: Circular Queue Implementation
Pattern: Queue Data Structure
Status: ✅ Solved

LeetCode similar:

622 (Design Circular Queue)

Input:
enqueue(10)
enqueue(20)
enqueue(30)

dequeue()

enqueue(40)

Output:
10 removed

Queue:
20 30 40

Explanation:
Circular Queue reuses empty spaces.

When rear reaches end,
it goes back to beginning.

This avoids wasted space.
*/

public class CircularQueue02 {

    int[] queue = new int[5];

    int front = 0;
    int rear = -1;
    int size = 0;

    // enqueue
    public void enqueue(int data) {

        if (size == queue.length) {
            System.out.println("Queue is full");
            return;
        }

        rear = (rear + 1) % queue.length;

        queue[rear] = data;

        size++;

        System.out.println(data + " inserted");
    }

    // dequeue
    public void dequeue() {

        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println(queue[front] + " removed");

        front = (front + 1) % queue.length;

        size--;
    }

    // display
    public void display() {

        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Queue:");

        for (int i = 0; i < size; i++) {

            int index = (front + i) % queue.length;

            System.out.print(queue[index] + " ");
        }
    }

    public static void main(String[] args) {

        CircularQueue02 q = new CircularQueue02();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.dequeue();

        q.enqueue(40);

        q.display();
    }
}