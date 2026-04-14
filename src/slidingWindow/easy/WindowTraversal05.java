package slidingWindow.easy;

import java.util.Arrays;

/*
 EASY
 No. 5
 Problem: Window Traversal Basics
 Pattern: Sliding Window (Fixed Size - Traversal)
 Status: ✅ Solved

 LeetCode similar:
 - Basic concept (used in many problems)

 Input:
 arr = [1,2,3,4,5]
 k = 3

 Output:
 [1,2,3]
 [2,3,4]
 [3,4,5]

 Explanation:
 Just print all windows of size K
*/

public class WindowTraversal05 {

    public static void printWindows(int[] arr, int k) {

        int start = 0;

        for (int end = 0; end < arr.length; end++) {

            // when window size becomes k
            if (end >= k - 1) {

                // print window
                for (int i = start; i <= end; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println(); // It is for next line else print same horizontal

                start++; // slide window
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        int k = 3;

        printWindows(arr, k);
    }
}

/*
Note :
print with bracket:
int start = 0;

for (int end = 0; end < arr.length; end++) {

    if (end >= k - 1) {

        System.out.print("[");   // start bracket

        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");  // print in same line
        }

        System.out.println("]"); // end bracket + new line

        start++;
    }
}

 */