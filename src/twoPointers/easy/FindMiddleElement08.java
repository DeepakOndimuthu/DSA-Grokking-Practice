package twoPointers.easy;

/*
 EASY
 No. 8
 Problem: Find Middle Element
 Pattern: Two Pointers (Slow & Fast)
 Status: ✅ Solved

 LeetCode similar:
 - 876 (Middle of the Linked List) [same concept]
 - Array version (basic)

 Input:
 arr = [1,2,3,4,5]

 Output:
 3

 Explanation:
 Use two pointers:
 slow → moves 1 step
 fast → moves 2 steps
 When fast reaches end,
 slow will be at middle.
*/

public class FindMiddleElement08 {

    public static int findMiddle(int[] arr) {

        int slow = 0;
        int fast = 0;

        while (fast < arr.length && fast + 1 < arr.length) {
            slow++;       // move 1 step
            fast += 2;    // move 2 steps
        }

        return arr[slow];
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};

        System.out.println(findMiddle(arr));
    }
}

/*
fast moves 2x speed
slow moves 1x speed

Example:
[1,2,3,4,5]

Pointers:
slow = 0
fast = 0

Step 1
slow = 1
fast = 2

Step 2
slow = 2
fast = 4

Step 3
fast cannot move 2 steps → stop

Result:
arr[slow] = 3

***********

so slow =0
fast = 0

while(0<5 && 1<5){
slow++ -> slow =1;
fast += 2 -> fast = 2
}

while(1<5 && 3<5){
slow++ -> slow =2
fast += 2 -> fast = 4
}

while(2<5 && 5<5) so loop end
arr[2] = 3
2 → index
3 → value

 */