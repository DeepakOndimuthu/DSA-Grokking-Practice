package linkedList.basic;

/*
BASIC
No. 6

Problem:
Merge Two Sorted Lists

Pattern:
Linked List (Merge)

Status:
✅ Solved


LeetCode:

21 (Merge Two Sorted Lists)
23  (Merge k Sorted Lists)
88 (Merge Sorted Array)
148 (Sort List)

Input:

List 1:
10 -> 30 -> 50

List 2:
20 -> 40 -> 60

Output:

10 -> 20 -> 30 -> 40 -> 50 -> 60

Explanation:

Compare both list nodes

Take the smaller node

Move that pointer forward

Repeat until one list ends

Attach remaining nodes
*/

public class MergeTwoSortedLists06 {

    // Node class
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node merge(Node list1, Node list2) {

        Node dummy = new Node(0);
        Node current = dummy;

        while (list1 != null && list2 != null) {

            if (list1.data <= list2.data) {

                current.next = list1;
                list1 = list1.next;

            } else {

                current.next = list2;
                list2 = list2.next;

            }

            current = current.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            current.next = list1;
        }

        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }

    public static void print(Node head) {

        Node temp = head;

        while (temp != null) {

            System.out.print(temp.data + " ");

            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        // List 1
        Node list1 = new Node(10);
        list1.next = new Node(30);
        list1.next.next = new Node(50);

        // List 2
        Node list2 = new Node(20);
        list2.next = new Node(40);
        list2.next.next = new Node(60);

        System.out.println("Merged List:");

        Node result = merge(list1, list2);

        print(result);

    }

}

/*

check LC folder 06 mergeTwoSortedList program

 */