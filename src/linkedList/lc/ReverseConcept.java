package linkedList.lc;

public class ReverseConcept {

    /*

            Normal Swap
            A = 5
            B = 10

            Want:
            A = 10
            B = 5

            If you do:
            A = B;
            B = A;

            Result:
            A = 10
            B = 10
            ❌ Lost the old value.

            So we use:
            temp = A;
            A = B;
            B = temp;

            Save old value before changing it.

            ***********************
            Linked List Reverse
            previous, current, next

            Now think about this list:
            2 -> 1

            Goal:
            1 -> 2

            can we simply do this
            current.next = previous;
            No!

            Because before changing it,
            2 -> 1

            If we immediately do:
            2 -> null

            then
            1
            is lost forever.

            So before cutting the connection, we must save where to go next.

            That is why:
            Node next = current.next;

            Exactly like:
            temp = A;
            It is a backup.

            *******************
            Swap
            temp = A; Save old value.
            Reverse
            next = current.next; Save next node.

            Then swap changes value.
            A = B;
            Reverse changes arrow.
            current.next = previous;

            Swap finishes.
            B = temp;
            Reverse moves forward.
            current = next;

            *********************

            The real reason for 3 variables

            Imagine you are climbing a ladder.
            2 ----> 1

            You are standing on 2.
            If you break the ladder behind you immediately,

            2 -> null

            How will you reach 1?
            You can't.

            So first you remember:
            "My next step is 1."

            That memory is:
            next = current.next;

            Now you can safely cut the ladder

            previous = past
            current = present
            next = future

            Every loop is only this:
            Remember where to go next
            ↓
            Turn current backwards
            ↓
            Mark current as finished
            ↓
            Walk to remembered node

            **********************
     */
}
