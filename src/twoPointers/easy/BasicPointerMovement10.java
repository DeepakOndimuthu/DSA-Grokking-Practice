package twoPointers.easy;

/*
 EASY
 No. 10
 Problem: Basic Pointer Movement
 Pattern: Two Pointers
 Status: ✅ Solved

 Input:
 arr = [1,2,3,4,5]

 Output:
 Pairs printed from both ends

 Explanation:
 Left pointer starts from beginning
 Right pointer starts from end
 Move inward
*/

public class BasicPointerMovement10 {

    public static void printPairs(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            System.out.println(arr[left] + " , " + arr[right]);

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};

        printPairs(arr);
    }
}

/*
Note other problems:
Reverse array → use <
Palindrome → use <
Printing pairs → can use <=

This sum
while (left <= right) { //3 <= 1 ❌ false this sum that time loop ends

left <= right → includes middle
left < right  → excludes middle


 */