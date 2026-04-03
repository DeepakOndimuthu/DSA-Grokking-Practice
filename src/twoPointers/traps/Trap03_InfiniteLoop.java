package twoPointers;

/*
 TRAP 3
 Problem: Infinite Loop
*/

public class Trap03_InfiniteLoop {

    public static void wrong(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            if (arr[left] < arr[right]) {
                left++; // OK
            }
            // ❌ forgot to move right
        }
    }
}

/*
If pointer not updated → infinite loop ❌
Every condition must move pointer
 */