package linkedList.lc;

/*
BASIC
No. 9

Problem:
Merge k Sorted Lists

Pattern:
Linked List + Divide and Conquer

Status:
✅ Solved


LeetCode:

23 (Merge k Sorted Lists)

Input:

List1:
1 -> 4 -> 5

List2:
1 -> 3 -> 4

List3:
2 -> 6

Output:

1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6

Explanation:

Merge two lists at a time

Repeat until only one list remains

Return merged list
*/

public class MergeKSortedLists23 {

    // Node class
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node mergeTwoLists(Node list1, Node list2) {

        Node dummy = new Node(0);
        Node tail = dummy;

        while (list1 != null && list2 != null) {

            if (list1.data <= list2.data) {

                tail.next = list1;
                list1 = list1.next;

            } else {

                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        if (list1 != null) {

            tail.next = list1;

        } else {

            tail.next = list2;
        }

        return dummy.next;
    }

    public static Node mergeKLists(Node[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        Node result = lists[0];

        for (int i = 1; i < lists.length; i++) {

            result = mergeTwoLists(result, lists[i]);
        }

        return result;
    }

    public static void print(Node head) {

        Node temp = head;

        while (temp != null) {

            System.out.print(temp.data + " ");

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Node list1 = new Node(1);
        list1.next = new Node(4);
        list1.next.next = new Node(5);

        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(4);

        Node list3 = new Node(2);
        list3.next = new Node(6);

        Node[] lists = {list1, list2, list3};

        Node result = mergeKLists(lists);

        System.out.println("Merged List:");

        print(result);
    }
}

/*
Pattern

Take First List
        ↓
Merge with Second List
        ↓
Merge Result with Third List
        ↓
Repeat Until All Lists Are Merged
        ↓
Return Final List

Note: 21 (Merge Two Sorted Lists) same this sum concpet
and list we past it through loop and merge it

*************************
Dry Run

List1
1 -> 4 -> 5

List2
1 -> 3 -> 4

↓
Merge
1 -> 1 -> 3 -> 4 -> 4 -> 5

Now merge with List3
2 -> 6
↓
Final
1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6

***********************

First iteration
mergeTwoLists(lists[0], lists[1])
that first list[0] is we initial result value first above the loop


Second iteration
mergeTwoLists(result, lists[2])
where result is already the merged list of lists[0] and lists[1].

*******************************
 */