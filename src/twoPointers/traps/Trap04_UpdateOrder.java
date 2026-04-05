package twoPointers.traps;

/*
 TRAP 4
 Problem: Pointer Update Order
*/

public class Trap04_UpdateOrder {

    public static void wrong(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            left++; // ❌ moved before using

            if (arr[left] != arr[right]) {
                return;
            }
        }
    }
}

/*
Note:
Update pointer AFTER using it

eg:
if (arr[left] != arr[right]) return;
left++;
right--;

 */